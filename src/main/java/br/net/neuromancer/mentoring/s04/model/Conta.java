package br.net.neuromancer.mentoring.s04.model;

public class Conta {

	private int id;
	private int numero;
	private Banco banco;
	
	
	
	public Conta(int id, int numero, Banco banco) {
		super();
		this.id = id;
		this.numero = numero;
		this.banco = banco;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public Banco getBanco() {
		return banco;
	}
	public void setBanco(Banco banco) {
		this.banco = banco;
	}
	@Override
	public String toString() {
		return "Conta [id=" + id + ", numero=" + numero + ", banco=" + banco + "]";
	}
	
	
	
}
