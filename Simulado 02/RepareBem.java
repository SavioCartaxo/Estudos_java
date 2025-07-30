public class RepareBem {
    
    private Reparo[] listaReparo;
    private int contadorReparos;
    private OS[] listaOS;
    private int contadorOS;

    public RepareBem() {
        this.listaReparo = new Reparo[100];
        this.contadorReparos = 0;
        this.listaOS = new OS[500];
        this.contadorOS = 0;
    }

    public void cadastrarReparo(String id, String descricao, double preco) {
        if (this.contadorReparos <= 100){
            this.listaReparo[this.contadorReparos] = (new Reparo(id, descricao, preco));
            this.contadorReparos++;
        }
    }

    public void reajustarPrecoReparo(String idReparo, double percentual) {
        for (int i = 0; i < this.contadorReparos; i++) {
            if (this.getIdReparo(i).equals(idReparo)) {
                this.getReparo(i).reajustarPreco(percentual);
                break;
            }
        }
    }

    public void mudarStatusOrdemDeServico( int idOS, String status ) {
        this.listaOS[idOS - 1].setStatus(status);
    }

    public double obterValorOrdemServico(int idOS) {
        return this.listaOS[idOS - 1].getPreco();
    }

    public String listarOrdemDeServico() {
        String out = "";

        for (int i = 0; i < contadorOS; i++) {
            out += this.listaOS[i].toString();
            out += "\n";
        }

        return out;
    }

    public String listarOrdemDeServico(String status) {
        String out = "Ordens de Serviço - ";
        out += status + "\n";

        for (int i = 0; i < contadorOS; i++) {
            if (this.listaOS[i].getStatus().equals(status)) {    
                out += this.listaOS[i].toString();
                out += "\n";
            }
        }

        if (out.equals("Ordens de Serviço - " + status + "\n")) 
            out = "Não há ordens de serviço do tipo " + status;
        
        return out;
    }

    public int cadastrarOrdemDeServico(String cliente, String telefone, String roupa) {
        this.listaOS[this.contadorOS] = new OS(cliente, telefone, roupa, this.contadorOS + 1);
        this.contadorOS++;

        return this.contadorOS;
    }

    public String exibirOrdemDeServico( int IDOS ) {
        return this.listaOS[IDOS - 1].toString();
    }

    public void incluirReparoOrdemDeServico( int idOS, String idReparo ) {
        this.getOS(idOS -1).addReparo(this.pegaReparoComOID(idReparo)); 
    }

    private Reparo pegaReparoComOID(String idReparo) {
        int n = 0;
        for (int i = 0; i < this.contadorReparos; i++) {
            if (this.listaReparo[i].getId().equals(idReparo)) {
                n = i;
                break;
            }
        }

        return this.listaReparo[n];
    }

    private OS getOS(int posicao) {
        return this.listaOS[posicao];
    }

    private Reparo getReparo(int posicao) {
        return this.listaReparo[posicao];
    }

    private String getIdReparo(int posicao) {
        return this.listaReparo[posicao].getId();
    }

}
