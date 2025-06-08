#!/usr/bin/python
import urllib.request
import urllib.error
import urllib.parse
import json
import os
import subprocess
import sys


def _run(filename):
    shell = os.name == 'nt'
    if filename.endswith('py'):
        executor = ['python', filename]
        return subprocess.Popen(executor, stdin=subprocess.PIPE, stdout=subprocess.PIPE, stderr=subprocess.PIPE, universal_newlines=True, shell=shell)
    elif filename.endswith('sh'):
        executor = ['bash', filename]
        return subprocess.Popen(executor, stdin=subprocess.PIPE, stdout=subprocess.PIPE, stderr=subprocess.PIPE, universal_newlines=True, shell=shell)
    elif filename.endswith('f90') or filename.endswith('c'):
        compiler = 'gfortran' if filename.endswith('f90') else 'gcc'
        executor = [compiler, filename]
        exect = subprocess.Popen(executor, stdout=subprocess.PIPE, stderr=subprocess.PIPE, universal_newlines=True, shell=shell)
        output, output_err = exect.communicate()
        if exect.wait():
            print(ERROR % ('Compiling...', output_err))
            exit(1)
        return subprocess.Popen('./a.out', stdin=subprocess.PIPE, stdout=subprocess.PIPE, stderr=subprocess.PIPE, universal_newlines=True, shell=shell)
    elif filename.endswith('java'):
        # Compilar
        exect = subprocess.Popen(['javac', filename], stdout=subprocess.PIPE, stderr=subprocess.PIPE, universal_newlines=True, shell=shell)
        output, output_err = exect.communicate()
        if exect.wait():
            print(ERROR % ('Compiling...', output_err))
            exit(1)
        # Executar: só o nome do arquivo, sem diretórios, sem extensão
        class_name = os.path.splitext(os.path.basename(filename))[0]
        return subprocess.Popen(['java', '-Duser.language=en', class_name], stdin=subprocess.PIPE, stdout=subprocess.PIPE, stderr=subprocess.PIPE, universal_newlines=True, shell=shell)
    elif filename.endswith('pl'):
        return subprocess.Popen(['swipl', '-q', '-f', filename], stdin=subprocess.PIPE, stdout=subprocess.PIPE, stderr=subprocess.PIPE, universal_newlines=True, shell=shell)
    elif os.access(filename, os.X_OK):
        return subprocess.Popen([os.path.abspath(filename)], stdin=subprocess.PIPE, stdout=subprocess.PIPE, stderr=subprocess.PIPE, universal_newlines=True)


def http_get(url):
    return json.loads(urllib.request.urlopen(url).read().decode('utf-8'))


def http_post(url, data):
    req = urllib.request.Request(url, data=data.encode('utf-8'), headers={'Content-Type': 'application/json'})
    return json.loads(urllib.request.urlopen(req).read().decode('utf-8'))


BASE = 'http://dirlididi.com/api/'

HEAD = """= PROBLEM NAME
%s
= PROBLEM DESCRIPTION
%s
"""
TEST = """== TEST - %s
%s
== INPUT:
%s
== OUTPUT:
%s
"""
ERROR = """==ERROR FOR INPUT:
%s
== ERROR MSG:
%s
"""
FAILURE = """== FAILED FOR INPUT:
%s
== FAILED OUTPUT:
%s
"""


def get_problem(key):
    return http_get(BASE + 'problem/' + key)


def submit_code(token, key, code, tests_result):
    result = {'tests': tests_result, 'key': key, 'code': code, 'token': token}
    return http_post(BASE + 'code/' + key, json.dumps(result))


def has_failure(results):
    return results.replace('.', '') != ''


def _get(key):
    problem = get_problem(key)
    print(HEAD % (problem["name"], problem["description"]))
    published_tests = [x for x in problem['tests'] if x['publish']]
    if published_tests:
        print("= PROGRAM EXAMPLES")
        for test in published_tests:
            print(TEST % (test['description'], test.get('tip', ''), test['input'], test['output']))


def _submit(key, token, filename, source):
    problem = get_problem(key)
    tests_result = []
    for test in problem['tests']:
        print(f"\n== Running test '{test['description']}'")
        exect = _run(filename)
        input_ = test['input']
        output, output_err = exect.communicate(input_)
        if exect.wait() != 0:
            print(ERROR % (input_, output_err))
            exit(1)
        tests_result.append((test['key'], output))

    with open(source, 'r', encoding='utf-8') as f:
        code = f.read()

    content = submit_code(token, key, code, tests_result)

    print("\n== API RESPONSE:")
    print(content)

    if 'result' not in content:
        print("\nErro na submissão. Verifique seu token ou o problema.")
        exit(1)

    print("\nResults: " + content['result'])
    if has_failure(content['result']):
        for i, r in enumerate(content['result']):
            if r != '.':
                failed_test = tests_result[i]
                print(FAILURE % (problem['tests'][i]['input'], failed_test[1]))


def _usage():
    print(f"Usage:\n {sys.argv[0]} get <problem_key>\n {sys.argv[0]} submit <problem_key> <token> <filename> [filename_src]")
    exit(1)


def main():
    if len(sys.argv) < 3:
        _usage()

    command = sys.argv[1].lower()
    key = sys.argv[2]

    if command == 'get':
        _get(key)
    elif command == 'submit':
        if len(sys.argv) not in [5, 6]:
            _usage()
        token = sys.argv[3]
        filename = sys.argv[4]
        source = sys.argv[5] if len(sys.argv) == 6 else filename
        _submit(key, token, filename, source)
    else:
        _usage()


if __name__ == "__main__":
    main()
