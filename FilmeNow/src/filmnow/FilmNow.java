package filmnow;

/**
 * Sistema que mantém os seus filmes prediletos. Podem existir 100 filmes. 
 * 
 * @author eliane
 * @author SavioCartaxo
 * 
 */
public class FilmNow {
	
	private static final int TAMANHO = 100;
	
	private Filme[] filmes; //uma representacao simploria da lista de filmes

	/**
	 * Cria o FilmNow.
	 */
	public FilmNow() {
		this.filmes = new Filme[TAMANHO];
	}
	
	/**
	 * Acessa a lista de filmes mantida.
	 * @return O array de filmes.
	 */
	public Filme[] getFilmes() {
		return this.filmes;
	}

	/**
	 * Acessa os dados de um filme específico.
	 * @param posicao Posição do filme no sistema.
	 * @return Dados do filme. Null se não há filme na posição.
	 */
	public Filme getFilme(int posicao) {
		return this.filmes[posicao];
	}

	/**
	 * Adiciona um filme em uma posição. Se já existir filme na posição, sobrescreve o anterior. 
	 * @param posicao Posição do filme.
	 * @param nome Nome do filme.
	 * @param ano Ano de lançamento do filme.
	 * @param local Local onde o filme pode ser assitido.
	 */
	public void cadastraFilme(int posicao, String nome, int ano, String local) {
		if (posicao <= 100) {
			this.filmes[posicao - 1] = new Filme(nome, ano, local);
		}
		
	}
	
	public int getTamanho() {
		return 100;
	}
	
	public String pegaNome(int posicao) {
		return this.filmes[posicao].getNome();
	}

	public int pegaAno(int posicao) {
		return this.filmes[posicao].getAno();
	}
	
	public String getNomeFilme(int posicao) {
		return this.filmes[posicao].getNome();
	}

	public String GettoStringFilme(int posicao) {
		return this.filmes[posicao].toString();
	}

	public int getPosicionHotFilme(int posicao) {
		return this.filmes[posicao].getPosicionHot();
	}

	public int getAnoFilme(int posicao) {
		return this.filmes[posicao].getAno();
	}

	public boolean getHotFilme(int posicao) {
		return this.filmes[posicao].getHot();
	}
}
