package src.Interface;

public class Cachorro implements Animal{
    private int idade;

    public Cachorro(int idade){
        this.idade = idade;
    }

    @Override
    public String fazerSom(){
        return "Au au";
    }

    @Override
    public int dizerIdade(){
        return this.idade;
    }
}
