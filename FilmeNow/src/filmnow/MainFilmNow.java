package filmnow;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * Interface com menus texto para manipular o sistema FilmNow.
 * 
 * @author eliane
 *
 */
public class MainFilmNow {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		FilmNow fn = new FilmNow();

		System.out.println("Carregando filmes ...");
		
		try {
		
			/*
			 * Essa é a maneira de lidar com possíveis erros por falta do arquivo. 
			 */
			carregaFilmes("filmes_inicial.csv", fn);
		
		} catch (FileNotFoundException e) {
			System.err.println("Arquivo não encontrado: " + e.getMessage());
		} catch (IOException e) {
			System.err.println("Erro lendo arquivo: " + e.getMessage());
		}

		String escolha = "";
		while (true) {
			escolha = menu(scanner);
			comando(escolha, fn, scanner);
		}

	}

	/**
	 * Exibe o menu e captura a escolha do/a usuário/a.
	 * 
	 * @param scanner Para captura da opção do usuário/a.
	 * @return O comando escolhido.
	 */
	
	private static String menu(Scanner scanner) {
		System.out.println(
				"\n---\nMENU\n" + 
						"(A)Adicionar filme\n" + 
						"(M)Mostrar todos\n" + 
						"(D)Detalhar filme\n" +
						"(E)Exibir HotList\n" +
						"(H)Atribuir Hot\n" +
						"(R)Remover Hot\n" +
						"(S)Sair\n" + 
						"\n" + 
						"Opção: ");
		return scanner.next().toUpperCase();
	}

	/**
	 * Interpreta a opção escolhida por quem está usando o sistema.
	 * 
	 * @param opcao   Opção digitada.
	 * @param fn  O sistema FilmNow que estamos manipulando.
	 * @param scanner Objeto scanner para o caso do comando precisar de mais input.
	 */
	private static void comando(String opcao, FilmNow fn, Scanner scanner) {
		switch (opcao) {
		case "A":
			adicionaFilme(fn, scanner);
			break;
		case "M":
			mostrarFilmes(fn);
			break;
		case "D":
			detalharFilme(fn, scanner);
			break;
		case "E":
			exibirHotList(fn);
			break;
		case "H":
			atribuiHot(fn, scanner);
			break;
		case "R":
			RemoverHot(fn, scanner);
			break;
		case "S":
			sai();
			break;
		default:
			System.out.println("Opção inválida!");
		}
	}


	/**
	 * Cadastra um filme no sistema. 
	 * 
	 * @param fn O sistema FilmNow a ser manipulado.
	 * @param scanner Scanner para pedir informações do contato.
	 */
	private static void adicionaFilme(FilmNow fn, Scanner scanner) {
		System.out.print("\nPosição no sistema: ");
		int posicao = scanner.nextInt();
		
		// Checa se o filme pode ser adicionado na lista e adiciona(se possivel)
		if (posicao - 1 < fn.getTamanho()) {
			
			System.out.print("\nNome: ");
			String nome = scanner.next();
			System.out.print("\nAno: ");
			int ano = scanner.nextInt();
			System.out.print("\nLocal de Exibição: ");
			String local = scanner.next();
				
			// Percorre a lista e checa de o filme ja existe
			
			Filme filmeQueEstamosTentandoAdicionar = new Filme(nome, ano, local);
			boolean jaExiste = false;
			
			for (int i = 0; i < fn.getTamanho(); i++) {
				if (filmeQueEstamosTentandoAdicionar.equals(fn.getFilme(i))) {
					jaExiste = true;
					break;
				}
			}
			
			// Se o Filme não existe, é adicionado na lista, se já existe, é informado ao usuário
			
			if (!jaExiste) 
				fn.cadastraFilme(posicao, nome, ano, local);
			
			else 
				System.out.println("FILME JA ADICIONADO");
				
			
		} else {
			System.out.println("POSIÇÃO INVÁLIDA");
		}
		
	}


		/**
	 * Imprime lista de filmes.
	 * 
	 * @param fn O sistema FilmNow a ser manipulado.
	 */
	private static void mostrarFilmes(FilmNow fn) {

		for (int i = 0; i < fn.getTamanho(); i++) {
			if (fn.getFilme(i) != null) {			
				System.out.println(formataFilme(i, fn));
			}
		}
	}


		/**
	 * Formata um filme para impressão. 
	 * 
	 * @param posicao A posição do filme (que é exibida)/
	 * @param filme O filme a ser impresso.
	 * @return A String formatada.
	 */
	private static String formataFilme(int posicao, FilmNow fn) {
		return posicao + 1 + " - " +  fn.getNomeFilme(posicao);
	}


	/**
	 * Imprime os detalhes de um dos filmes. 
	 * 
	 * @param fn O sistema FilmNow a ser manipulado.
	 * @param scanner Scanner para capturar qual contato.
	 */
	private static void detalharFilme(FilmNow fn, Scanner scanner) {
		System.out.print("\nPosicao do filme: ");
		int posicao = scanner.nextInt();
		
		Filme filme = fn.getFilme(posicao - 1);
		if (filme == null) {
			System.out.println("POSIÇÃO INVÁLIDA!");
		} else {
			System.out.println("Dados do filme:\n" + fn.GettoStringFilme(posicao - 1));
		}

	}
	

	private static void exibirHotList(FilmNow fn) {
		for (int i = 0; i < fn.getTamanho(); i++) {
			
			if (fn.getFilme(i) != null) {
				
				if (fn.getHotFilme(i)) {
					System.out.printf("%d - %s, %d%n", 
					fn.getPosicionHotFilme(i), 
					fn.getNomeFilme(i), 
					fn.getAnoFilme(i)
					);
				}
			}
		}
	}

	private static boolean atribuiHot(FilmNow fn, Scanner sc) {
		System.out.print("Posicao do Filme na Lista: ");
		int posicaoFilmeLista = sc.nextInt();
		System.out.print("posicao da Hot: ");
		int posicaoHotList = sc.nextInt();

		System.out.println(1);
		// Hotlist só tem 10 espaços
		if(posicaoHotList > 10) {
			return false;
		}

		System.out.println(2);
		// Se o Filme já está na HotList, não podemos adiciona-lo novamente
		if (fn.getFilme(posicaoFilmeLista - 1) != null) {	
			if (fn.getFilme(posicaoFilmeLista -1 ).getHot()) {
				System.out.println("Filme já está na HotList");
				return false;
			}
		}

		System.out.println(3);
		// Se já existir um filme nessa posicao da hotlist é preciso remover o status de Hot desse filme
		for (int i = 0; i < fn.getTamanho(); i++) {
			if (fn.getFilme(i) != null) {	
				if (fn.getFilme(i).getHot()) {
					if (fn.getFilme(i).getPosicionHot() == posicaoHotList) {
						fn.getFilme(i).setHot(false);
						fn.getFilme(i).setPosicionHot(11); // isso não é necessário, coloquei apenas para que de erro se a hot nao funcionar como o esperado
						break;
					}
				}
			}
		}

		System.out.println(4);
		fn.getFilmes()[posicaoFilmeLista - 1].setHot(true);
		fn.getFilmes()[posicaoFilmeLista - 1].setPosicionHot(posicaoHotList);

		
		System.out.println(5);
		System.out.printf("ADICIONAD À HOTLIST NA POSIÇÃO %d!%n", posicaoHotList);

		return true;
	}

	private static boolean RemoverHot(FilmNow fn, Scanner sc) {

		System.out.print("Posicao> ");
		int posicao = sc.nextInt();
		boolean removeuFilme = false;

		// Procura e remove da HotList
		for (int i = 0; i < fn.getTamanho(); i++) {
			if (fn.getFilme(i) != null) {
				if (fn.getFilme(i).getHot()) {
					if (fn.getFilme(i).getPosicionHot() == posicao) {
						fn.getFilme(i).setHot(false);
						fn.getFilme(i).setPosicionHot(11);
						removeuFilme = true;
						break;
					}
				}
			}
		}

		return removeuFilme;
	}

	/**
	 * Sai da aplicação.
	 */
	private static void sai() {
		System.out.println("\nVlw flw o/");
		System.exit(0);
	}

	/**
	 * Lê carga de filmes de um arquivo csv. 
	 * 
	 * @param arquivoFilmes O caminho para o arquivo.
	 * @param fn O sistema FilmNow a ser populado com os dados.
	 * @throws IOException Caso o arquivo não exista ou não possa ser lido.
	 */
	private static void carregaFilmes(String arquivoFilmes, FilmNow fn) throws FileNotFoundException, IOException {
		LeitorFilmNow leitor = new LeitorFilmNow();
		
		int carregados =  leitor.carregaContatos(arquivoFilmes, fn);
		System.out.println("Carregamos " + carregados + " registros.");
	}
}
