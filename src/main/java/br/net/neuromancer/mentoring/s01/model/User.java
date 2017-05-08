package br.net.neuromancer.mentoring.s01.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * “Relax, its only ONES and ZEROS !”
 * 
 * @see Account
 * @see Transaction
 */
public class User {

	private int id;
	private String name;
	private String username;
	private String password;

	private Set<Account> accounts;
	private ArrayList<Transaction> transactions;

	public User(int id, String name, String username, String password) {
		super();
		this.id = id;
		this.name = name;
		this.username = username;
		this.password = password;
		
		this.accounts = new HashSet<Account>();
		this.transactions = new ArrayList<Transaction>();
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public void addAccount(Account acc){
		accounts.add(acc);
	}

	public Set<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(Set<Account> accounts) {
		this.accounts = accounts;
	}

	public void addTransaction(Transaction t){
		transactions.add(t);
	}
	
	public ArrayList<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(ArrayList<Transaction> transactions) {
		this.transactions = transactions;
	}

	public String toString(){
		StringBuilder builder = new StringBuilder();
		builder.append(String.format("User (%d, %s, %s)\n", id, name, username));  //not a good idea to output passwords

		builder.append("\n\n  USER ACCOUNTS \n");
		for (Account a : accounts){
			builder.append(String.format("    %s \n", a.toString()));
		}

		
		builder.append("\n\n  USER TRANSACTIONS \n");
		for (Transaction t : transactions){
			builder.append(String.format("    %s \n", t.toString()));
		}
		
		return builder.toString();
	}
	
}
