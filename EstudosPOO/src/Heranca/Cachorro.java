package src.Heranca;

public class Cachorro extends Animal{
    private String dono;

    public Cachorro(String nome, int idade, String dono){
        super(nome, idade);
        this.dono = dono;
    }

    @Override
    public String som(){
        return "au au";
    }
    
    public String getDono(){
        return this.dono;
    }

    public void setDono(String dono){
        this.dono = dono;
    }
}
