package src.Heranca;

public class Animal {
    private String nome;
    private int idade;

    public Animal(String nome, int idade){
        this.idade = idade;
        this.nome = nome;
    }

    public String som(){
        return "Som";
    }
    
    public int getIdade(){
        return this.idade;
    }

    public void setIdade(int idade){
        this.idade = idade;
    }

    public String getNome(){
        return this.nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }
}
