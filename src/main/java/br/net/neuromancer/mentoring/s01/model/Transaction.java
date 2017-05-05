package br.net.neuromancer.mentoring.s01.model;

import java.util.ArrayList;

/**
 * “Business should never be merely transactional -it should be
 * transformational”
 * 
 * @see Account
 * @see TransactionItem
 */
public class Transaction {

	private int id;
	private String description;

	private TransactionType type;
	private Account account;

	private ArrayList<TransactionItem> items;

	public Transaction(int id, String description, TransactionType type, Account account) {
		super();
		this.id = id;
		this.description = description;
		this.type = type;
		this.account = account;
		
		items = new ArrayList<TransactionItem>();
	}
	
	public String toString(){
		StringBuilder builder = new StringBuilder();
		builder.append("-----------------------------\n");
		builder.append(String.format("    Transaction (%d, %s, %s)\n", id, description, type.toString()));
		builder.append(String.format("    number of installments : %d\n", this.getNumberOfInstallments()));
		builder.append(String.format("    total value : %f\n", this.getTotalValue()));
		builder.append("\n    ITEMS\n");
		
		for (TransactionItem t : items){
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * this is interpreted as a calculated property
	 * 
	 * @return the total amount of all TransactionItems
	 */
	public float getTotalValue() {
		float totalValue = 0;
		
		for(TransactionItem t : items){
			totalValue += t.getValue();
		}
		
		return totalValue;
	}

	/**
	 * this is interpreted as a calculated property
	 * 
	 * @return the size of the TransactionItem list
	 */
	public int getNumberOfInstallments() {
		return items.size();
	}

	public TransactionType getType() {
		return type;
	}

	public void setType(TransactionType type) {
		this.type = type;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
	
	public void addTransactionItem(TransactionItem ti){
		this.items.add(ti);
	}

	public ArrayList<TransactionItem> getItems() {
		return items;
	}

	public void setItems(ArrayList<TransactionItem> items) {
		this.items = items;
	}

}
