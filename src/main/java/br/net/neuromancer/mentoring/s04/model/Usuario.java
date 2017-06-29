package br.net.neuromancer.mentoring.s04.model;

import java.util.ArrayList;

public class Usuario {
	private int id;
	private String nome;
	private String nomeUsuario;
	private String senha;
	
	private ArrayList<Conta> listaContas;
	private ArrayList<Lancamento> listaLancamentos;
	
	
	
	public Usuario(int id, String nome, String nomeUsuario, String senha) {
		super();
		this.id = id;
		this.nome = nome;
		this.nomeUsuario = nomeUsuario;
		this.senha = senha;
		
		this.listaContas = new ArrayList<Conta>();
		this.listaLancamentos = new ArrayList<Lancamento>();
		
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
	public String getNomeUsuario() {
		return nomeUsuario;
	}
	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public ArrayList<Conta> getListaContas() {
		return listaContas;
	}
	public void setListaContas(ArrayList<Conta> listaContas) {
		this.listaContas = listaContas;
	}
	public ArrayList<Lancamento> getListaLancamentos() {
		return listaLancamentos;
	}
	public void setListaLancamentos(ArrayList<Lancamento> listaLancamentos) {
		this.listaLancamentos = listaLancamentos;
	}
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nome=" + nome + ", nomeUsuario=" + nomeUsuario + "]";
	}
	

}
