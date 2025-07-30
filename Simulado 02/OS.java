public class OS {
    private int ID;
    private String cliente;
    private String roupa;
    private String telefone;
    private Reparo[] listaReparos;
    private int contadorReparos;
    private String status;

    public OS(String cliente, String telefone, String roupa, int ID) {
        this.cliente = cliente;
        this.telefone = telefone;
        this.roupa = roupa;
        this.ID = ID;
        this.listaReparos = new Reparo[10];
        this.contadorReparos = 0;
        this.status = "Não iniciado";
    }

    public void addReparo(Reparo reparo) {
        if (contadorReparos < 10){
            this.listaReparos[contadorReparos] = reparo;
        }
        contadorReparos++;
    }


    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCliente() {
        return this.cliente;
    }

    public String getTelefone() {
        return this.telefone;
    }

    public String getRoupa() {
        return this.roupa;
    }

    public Reparo[] getListaReparos() {
        return this.listaReparos;
    }

    public int getID() {
        return this.ID;
    }

    public double getPreco() {
        double preco = 0;
        
        for (int i = 0; i < this.listaReparos.length; i++) {
            preco += listaReparos[i].getPreco();
        }
        
        return preco;
    }

    @Override
    public String toString() {
        String out = "";

        out += "#" + this.ID;
        out += "; cliente: " + this.cliente;
        out += "; roupa: " + this.roupa;
        out += "; reparos: " + this.listaReparos.length;
        out += "; total: R$";
        out += this.getPreco();

        return out;
    }
}
