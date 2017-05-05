package br.net.neuromancer.mentoring.s01.model;

import java.util.HashSet;
import java.util.Set;

/**
 * “What is the robbing of a bank compared to the founding of a bank?” Bertolt
 * Brecht
 *
 * @see Account
 */
public class Bank {
	private int id;
	private String name;
	private Set<Account> accounts;

	public Bank(int id, String name) {
		super();
		this.id = id;
		this.name = name;
		accounts = new HashSet<Account>();
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

	public void addAccount(Account acc) {
		accounts.add(acc);
	}

	public Set<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(Set<Account> accounts) {
		this.accounts = accounts;
	}

	public String toString() {
		return String.format("Bank (%d, %s) - associated with %d accounts ", id, name, accounts.size());
	}
}
