package br.net.neuromancer.mentoring.s04.model;

//
// por quê não usar um enumeration?
//
public class Categoria {
	private int id;
	private String descricao;
	private String complemento;
	
	public Categoria(int id, String descricao, String complemento) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.complemento = complemento;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	@Override
	public String toString() {
		return "Categoria [id=" + id + ", descricao=" + descricao + ", complemento=" + complemento + "]";
	}
	
	
	

}
