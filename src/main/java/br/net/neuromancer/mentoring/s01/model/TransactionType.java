package br.net.neuromancer.mentoring.s01.model;

/**
 * “I'm not that type of person, she said...”
 *
 * @see Transaction
 * 
 */
public class TransactionType {
	private int id;
	private String description;
	private String supplement;

	public TransactionType(int id, String description, String supplement) {
		super();
		this.id = id;
		this.description = description;
		this.supplement = supplement;
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

	public String getSupplement() {
		return supplement;
	}

	public void setSupplement(String supplement) {
		this.supplement = supplement;
	}

	public String toString() {
		return String.format("TransactionType (%d, %s, %s)", id, description, supplement);
	}
}
