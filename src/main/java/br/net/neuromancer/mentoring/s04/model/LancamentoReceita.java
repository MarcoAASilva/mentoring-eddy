package br.net.neuromancer.mentoring.s04.model;

import java.util.Date;


public class LancamentoReceita extends Lancamento {

	
	public LancamentoReceita(int id, Conta conta, String descricao, float valor, Categoria categoria, Date data) {
		super(id, conta, descricao, valor, categoria, data);

		// n�o h� nada no modelo que impe�a a cria��o de um LancamentoReceita
		// numa categoria diferente de "Receita"
		//
		assert(categoria.getDescricao().equals("Receita"));
	}

	@Override
	public double getValorTotal() {
		return this.getValorLancamento();
	}
	

}
