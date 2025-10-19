package src.HerancaInterface;

public interface Inter {
    
    // implementar metodo = default
    public default String dorme(){
        return "zzzz";
    }

    // metodo abstrato
    public abstract String fazSom();
}
