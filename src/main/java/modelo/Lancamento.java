package modelo;
 
 import java.util.ArrayList;
 
 public class Lancamento {
 
 	private int id;
 	private String descricao;
 
 	private Categoria categoria;
 	private Conta conta;
 	 
 	private ArrayList<ItemLancamento> itens;
 
 	public Lancamento(int id, String descricao, Categoria categoria, Conta conta) {
 		super();
 		this.id = id;
 		this.descricao = descricao;
 		this.categoria = categoria;
 		this.conta = conta;
 		
 		itens = new ArrayList<ItemLancamento>();
 	}
 	
 	public String toString(){
 		StringBuilder builder = new StringBuilder();
 		builder.append("-----------------------------\n");
 		builder.append(String.format("    Lancamento (%d, %s, %s)\n", id, descricao, categoria.toString()));
 		builder.append(String.format("    Número de parcelas : %d\n", this.getNumeroParcelas()));
 		builder.append(String.format("    Valor Total : %f\n", this.getValorTotal()));
 		builder.append("\n    ITENS\n");
 		
 		for (ItemLancamento t : itens){
 			builder.append(String.format("      %s\n", t.toString()));
 		}
 		builder.append("\n");
 
 
 		return builder.toString();
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
 

 	public float getValorTotal() {
 		float valorTotal = 0;
 		
 		for(ItemLancamento t : itens){
 			valorTotal += t.getValor();
 		}
 		
 		return valorTotal;
 	}

 	public int getNumeroParcelas() {
 		return itens.size();
 	}
 	
 	public Categoria getCategoria() {
 		return categoria;
 	}
 
 	public void setCategoria(Categoria categoria) {
 		this.categoria = categoria;
 	}
 
 	public Conta getConta() {
 		return conta;
 	}
 
 	public void setConta(Conta conta) {
 		this.conta = conta;
 	}
 	
 	public void addItemLancamento(ItemLancamento ti){
 		this.itens.add(ti);
 	}
 
 	public ArrayList<ItemLancamento> getItens() {
 		return itens;
 	}
 
 	public void setItens(ArrayList<ItemLancamento> itens) {
 		this.itens = itens;
 	}
 
 }