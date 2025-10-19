package src.Interface;

public interface Animal {
    
    public abstract String fazerSom();
    public abstract int dizerIdade();
    
    public default String dormir(){ // defaut
        return "zzz";
    }
}
