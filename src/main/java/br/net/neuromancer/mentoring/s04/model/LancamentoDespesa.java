package br.net.neuromancer.mentoring.s04.model;

import java.util.Date;

public class LancamentoDespesa extends Lancamento {
	public LancamentoDespesa(int id, Conta conta, String descricao, float valor, Categoria categoria, Date data) {
		super(id, conta, descricao, valor, categoria, data);

		// não há nada no modelo que impeça a criação de um LancamentoReceita
		// numa categoria diferente de "Despesa"
		//
		assert(categoria.getDescricao().equals("Despesa")||categoria.getDescricao().equals("DespesaParcelada"));
	}

	@Override
	public double getValorTotal() {
		return (-1)*this.getValorLancamento();
	}

}
