package br.net.neuromancer.mentoring.s01.model;

import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * “Every experience, good or bad, is a pricelss collector's item”
 * 
 * @see Transaction
 */
public class TransactionItem {

	private int id;
	private Date date;
	private float value;

	private Transaction ownerTransaction;

	public TransactionItem(int id, Date date, float value) {
		super();
		this.id = id;
		this.date = date;
		this.value = value;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public float getValue() {
		return value;
	}

	public void setValue(float value) {
		this.value = value;
	}

	public Transaction getOwnerTransaction() {
		return ownerTransaction;
	}

	public void setOwnerTransaction(Transaction ownerTransaction) {
		this.ownerTransaction = ownerTransaction;
	}

	public String toString() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-YYYY");

		return String.format("TransactionItem (%d, %s, %f)", id,
				formatter.format(date.toInstant().atZone(ZoneId.systemDefault())), value);
	}

}
