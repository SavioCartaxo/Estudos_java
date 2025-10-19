package src.AbstractClass;

public abstract class Animal {
    protected String nome;

    public Animal(String nome){
        this.nome = nome;
    }

    public String bomDia(){
        return this.nome + " Diz Bom dia.";
    }

    public abstract String fala();
}
