package modelo;
 
 import java.util.ArrayList;
 import java.util.HashSet;
 import java.util.Set;
 
 public class Usuario {
 
 	private int id;
 	private String nome;
 	private String username;
 	private String password;
 
 	private Set<Conta> contas;
 	private ArrayList<Lancamento> lancamentos;
 
 	public Usuario(int id, String nome, String username, String password) {
 		super();
 		this.id = id;
 		this.nome = nome;
 		this.username = username;
 		this.password = password;
 		
 		this.contas = new HashSet<Conta>();
 		this.lancamentos = new ArrayList<Lancamento>();
 	}
 	
 	public boolean validatePassword(String p){
 		return password.equals(p);
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
 
 	public String getUsername() {
 		return username;
 	}
 
 	public void setUsername(String username) {
 		this.username = username;
 	}
 
 	public String getPassword() {
 		return password;
 	}
 
 	public void setPassword(String password) {
 		this.password = password;
 	}
 
 	public void addConta(Conta acc){
 		contas.add(acc);
 	}
 
 	public Set<Conta> getContas() {
 		return contas;
 	}
 
 	public void setContas(Set<Conta> contas) {
 		this.contas = contas;
 	}
 
 	public void addLancamento(Lancamento t){
 		lancamentos.add(t);
 	}
 	
 	public ArrayList<Lancamento> getLancamentos() {
 		return lancamentos;
 	}
 
 	public void setLancamentos(ArrayList<Lancamento> lancamentos) {
 		this.lancamentos = lancamentos;
 	}
 
 	public String toString(){
 		StringBuilder builder = new StringBuilder();
 		builder.append(String.format("Usuário (%d, %s, %s)\\n", id, nome, username));
 
 		builder.append("\n\n  Contas de Usuário \n");
 		for (Conta a : contas){
 			builder.append(String.format("    %s \n", a.toString()));
 		}
 
 		
 		builder.append("\n\n  Lançamentos do Usuário \n");
 		for (Lancamento t : lancamentos){
 			builder.append(String.format("    %s \n", t.toString()));
 		}
 		
 		return builder.toString();
 	}
 	
 }