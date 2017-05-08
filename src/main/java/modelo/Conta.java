package modelo;

import java.util.ArrayList;
 
 
 
 public class Conta {
 
 	private int id;
 	private int numero;
 
 	private Banco banco;
 	private ArrayList<Lancamento> lancamentos;
 	
 
 	public Conta(int id, int numero, Banco banco) {
 		super();
		this.id = id;
 		this.numero = numero;
 		this.banco = banco;
 		this.lancamentos = new ArrayList<Lancamento>();
 	}
 	
 	public void addLancamento(Lancamento ti){
 		lancamentos.add(ti);
 	}
 
 	public ArrayList<Lancamento> getLancamentos() {
 		return lancamentos;
 	}
 
 	public void setLancamentos(ArrayList<Lancamento> lancamentos) {
 		this.lancamentos = lancamentos;
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
 	
 	public String toString(){
 		StringBuilder builder = new StringBuilder();
 		builder.append("-----------------------------\n");
 		builder.append(String.format("    Conta (%d, %s) - pertencente a %s \n", id, numero, banco.toString()));
 		builder.append(String.format("\n    Conta de Lançamentos : %d\n\n", lancamentos.size()));
 		
 		for (Lancamento t : lancamentos){
 			builder.append(String.format("    %s\n", t.toString()));
 		}
 		
 		return builder.toString();
 	}
 	
 }