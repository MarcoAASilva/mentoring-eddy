package br.net.neuromancer.mentoring.s04.model;

import java.util.Date;

public abstract class Lancamento {
	
	private int id;
	private String descricao;
	private float valor;
	private Categoria categoria;
	private Conta conta;
	private Date data;
	
	public Lancamento(int id, Conta conta, String descricao, float valor, Categoria categoria, Date data) {
		super();
		this.id = id;
		this.conta = conta;
		this.descricao = descricao;
		this.valor = valor;
		this.categoria = categoria;
		this.data = data;
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
	public float getValor() {
		return valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public Conta getConta() {
		return conta;
	}
	public void setConta(Conta conta) {
		this.conta = conta;
	}

	@Override
	public String toString() {
		return "Lancamento [id=" + id + ", descricao=" + descricao + ", valor=" + valor + ", categoria=" + categoria
				+ ", data=" + data + "]";
	}
	
	public double getValorLancamento(){
		return this.valor;
	}
	
	public abstract double getValorTotal();
}
