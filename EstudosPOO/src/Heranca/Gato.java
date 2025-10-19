package src.Heranca;

public class Gato extends Animal{
    private String cor;

    public Gato(String nome, int idade, String cor){
        super(nome, idade);
        this.cor = cor;
    }

    @Override
    public String som(){
        return "Miau!";
    }

    public String getCor(){
        return this.cor;
    }

    public void setCor(String cor){
        this.cor = cor;
    }
}
