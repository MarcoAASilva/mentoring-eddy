package br.net.neuromancer.mentoring.s04.model;

import java.util.Date;

public class LancamentoDespesaParcelada extends LancamentoDespesa {
	private int numeroParcelas;
	
	public LancamentoDespesaParcelada(int id, Conta conta, String descricao, float valor, Categoria categoria, Date data, int numeroParcelas) {
		super(id, conta, descricao, valor, categoria, data);

		// não há nada no modelo que impeça a criação de um LancamentoReceita
		// numa categoria diferente de "DespesaParcelada"
		//
		assert(categoria.getDescricao().equals("DespesaParcelada"));
		
		this.numeroParcelas = numeroParcelas;
	}
	
	public int getNumeroParcelas() {
		return numeroParcelas;
	}

	public void setNumeroParcelas(int numeroParcelas) {
		this.numeroParcelas = numeroParcelas;
	}

	@Override
	public double getValorTotal() {
		return this.getNumeroParcelas() * this.getValorLancamento();
	}

}
