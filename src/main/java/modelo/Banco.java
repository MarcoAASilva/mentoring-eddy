package modelo;
 
 import java.util.HashSet;
 import java.util.Set;
 
 public class Banco {
 	private int id;
 	private String nome;
 	private Set<Conta> contas;
 
 	public Banco(int id, String nome) {
 		super();
 		this.id = id;
 		this.nome = nome;
 		contas = new HashSet<Conta>();
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
 
 	public void addConta(Conta acc) {
 		contas.add(acc);
 	}
 
 	public Set<Conta> getContas() {
 		return contas;
 	}
 
 	public void setContas(Set<Conta> contas) {
 		this.contas = contas;
 	}
 
 	public String toString() {
 		return String.format("Banco (%d, %s) - associado com %d contas ", id, nome, contas.size());
 	}
 }