package filmnow;

public class Filme {
	private String nome;
	private int ano;
	private String local;
	private boolean hot;
	private int posicionHot;
	
	public Filme(String nome, int ano, String local) {
		this.nome = nome;
		this.ano = ano;
		this.local = local;
		this.hot = false;
		this.posicionHot = 11;
	}

	// Gets
	public String getNome() {
		return nome;
	}

	public int getAno() {
		return ano;
	}

	public String getLocal() {
		return local;
	}
	
	public boolean getHot() {
		return this.hot;
	}

	public int getPosicionHot() {
		return this.posicionHot;
	}

	// Sets
	public void setHot(boolean hot) {
		this.hot = hot;
	}
	
	public void setPosicionHot(int posicion) {
		this.posicionHot = posicion;
	}


	// Funções reescritas de Object
	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		
		if (o == null || this.getClass() != o.getClass()) {
			return false;
		}
		
		Filme obj = (Filme) o;
		
		return  (this.nome.equals(obj.nome) && this.ano == obj.ano);

	}
	
	@Override
	public String toString() {
		String out = "";
		
		if (this.hot){
			out += "🔥 ";
		}

		out += this.nome;
		out += ", ";
		out += this.ano;
		out += "\n";
		out += this.local;
		
		return out;
	}
}
