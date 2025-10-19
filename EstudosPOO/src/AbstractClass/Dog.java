package src.AbstractClass;

public class Dog extends Animal {
    private int idade;

    public Dog(String nome, int idade){
        super(nome);
        this.idade = idade;
    }

    public int getIdade(){
        return this.idade;
    }

    public String fala(){
        return "Au Au";
    }
}
