package br.net.neuromancer.mentoring.s04.model;

public class Banco {
	private int id;
	private String nome;
	
	public Banco(int id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	@Override
	public String toString() {
		return "Banco [id=" + id + ", nome=" + nome + "]";
	}
	
	
	

}
