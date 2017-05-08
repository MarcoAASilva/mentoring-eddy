package modelo;

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
 
 	public String toString() {
 		return String.format("Categoria (%d, %s, %s)", id, descricao, complemento);
 	}
 }