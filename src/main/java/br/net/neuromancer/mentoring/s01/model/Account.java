package br.net.neuromancer.mentoring.s01.model;

import java.util.ArrayList;

/**
 * “Accounts?  We don't need no accounts..” 
 *  
 * @see         Bank
 */
public class Account {

	private int id;
	private int number;

	private Bank bank;
	private ArrayList<Transaction> transactions;
	

	public Account(int id, int number, Bank bank) {
		super();
		this.id = id;
		this.number = number;
		this.bank = bank;
		this.transactions = new ArrayList<Transaction>();
	}
	
	public void addTransaction(Transaction ti){
		transactions.add(ti);
	}

	public ArrayList<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(ArrayList<Transaction> transactions) {
		this.transactions = transactions;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public Bank getBank() {
		return bank;
	}

	public void setBank(Bank bank) {
		this.bank = bank;
	}
	
	public String toString(){
		StringBuilder builder = new StringBuilder();
		builder.append("-----------------------------\n");
		builder.append(String.format("    Account (%d, %d) - owned by %s \n", id, number, bank.toString()));
		builder.append(String.format("\n    Transactions count : %d\n\n", transactions.size()));
		
		for (Transaction t : transactions){
			builder.append(String.format("    %s\n", t.toString()));
		}
		
		return builder.toString();
	}
	
}
