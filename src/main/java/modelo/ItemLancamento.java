package modelo;

import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;


public class ItemLancamento {

	private int id;
	private Date data;
	private float valor;

	private Lancamento proprietarioLancamento;

	public ItemLancamento(int id, Date data, float valor) {
		super();
		this.id = id;
		this.data = data;
		this.valor = valor;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public Lancamento getProprietarioLancamento() {
		return proprietarioLancamento;
	}

	public void setProprietarioLancamento(Lancamento proprietarioLancamento) {
		this.proprietarioLancamento = proprietarioLancamento;
	}

	public String toString() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MM YYYY");

		return String.format("ItemLancamento (%d, %s, %f)", id,
				formatter.format(data.toInstant().atZone(ZoneId.systemDefault())), valor);
	}
}