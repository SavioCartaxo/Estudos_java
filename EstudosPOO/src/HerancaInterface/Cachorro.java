package src.HerancaInterface;

public class Cachorro extends Hera implements Inter{
    private String dono;

    public Cachorro(String dono, String nome){
        super(nome);
        this.dono = dono;
    }

    public String fazSom(){
        return "Au Au";
    }
    public String getDono(){
        return this.dono;
    }

    public void setDono(String dono){
        this.dono = dono;
    }
}
