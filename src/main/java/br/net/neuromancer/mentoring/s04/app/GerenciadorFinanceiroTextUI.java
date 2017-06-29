package br.net.neuromancer.mentoring.s04.app;

import java.util.ArrayList;
import java.util.Scanner;

import br.net.neuromancer.mentoring.s04.model.Lancamento;
import br.net.neuromancer.mentoring.s04.model.Usuario;

public class GerenciadorFinanceiroTextUI {

	private static GerenciadorFinanceiroDataStore dataStore;

	private boolean deveSair = false;
	private boolean deveVoltarMenuPrincipal = false;
	private boolean deveVoltarMenuUsuarios = false;
	
	private Scanner input = new Scanner(System.in);
	
	private Usuario usuarioSelecionado; 

	public static void main(String[] args) {
		dataStore = new GerenciadorFinanceiroDataStore();
		dataStore.realizaPreCarga();

		// enquanto o usu�rio n�o escolher a op��o de sair, continuar mostrando o menu
		// este padr�o � utilizado para todos menus
		
		GerenciadorFinanceiroTextUI ui = new GerenciadorFinanceiroTextUI();
		
		while (!ui.deveSair) {
			ui.exibirMenuPrincipal();
		}
	}

	public void exibirMenuPrincipal() {
		System.out.println("\n\n");

		System.out.println("-- Gerenciador Financeiro --");
		System.out.println(
				"Selecione a entidade: \n" + "  1) Banco\n" + "  2) Conta\n" + "  3) Usuario \n" + "  4) Sair\n ");

		int selection = input.nextInt();
		input.nextLine();

		switch (selection) {
		case 1:
			this.gerenciarBancos();
			break;
		case 2:
			this.gerenciarContas();
			break;
		case 3:
			this.gerenciarUsuarios();
			break;
		case 4:
			this.sair();
			break;
		default:
			System.out.println("Sele��o inv�lida.");
			break;
		}

	}

	public void exibirMenuBancos() {
		System.out.println("\n\n");

		System.out.println("-- Gerenciar Bancos --");
		System.out.println(
				"Selecione operacao: \n" + "  1) listar\n" + "  2) criar\n" + "  3) remover\n" + "  4) alterar\n " + " 5) voltar ao Menu Principal");

		int selection = input.nextInt();
		input.nextLine();

		switch (selection) {
		case 1:
			this.listarBancos();
			break;
		case 2:
			this.criarBanco();
			break;
		case 3:
			this.removerBanco();
			break;
		case 4:
			this.alterarBanco();
			break;
		case 5:
			this.voltarAoMenuPrincipal();
			break;
		default:
			System.out.println("Sele��o inv�lida.");
			break;
		}

	}

	public void exibirMenuContas() {
		
		System.out.println("\n\n");
		System.out.println("-- Gerenciar Contas --");
		System.out.println("Selecione operacao: \n" + "  1) listar\n" + "  2) criar\n" + "  3) remover\n"
				+ "  4) alterar\n " + " 5) voltar ao Menu Principal\n ");

		int selection = input.nextInt();
		input.nextLine();

		switch (selection) {
		case 1:
			this.listarContas();
			break;
		case 2:
			this.criarConta();
			break;
		case 3:
			this.removerConta();
			break;
		case 4:
			this.alterarConta();
			break;
		case 5:
			this.voltarAoMenuPrincipal();
			break;
		default:
			System.out.println("Sele��o inv�lida.");
			break;
		}
	}

	private void exibirMenuLancamentos() {
		
		System.out.println("\n\n");
		System.out.println(String.format("-- Gerenciar Lancamentos para usu�rio %s --", usuarioSelecionado.toString()));
		System.out.println("  1) listar\n" + "  2) criar\n" + "  3) remover\n"
				+ "  4) alterar\n " + " 5) voltar ao menu Usu�rios\n ");

		int selection = input.nextInt();
		input.nextLine();

		switch (selection) {
		case 1:
			this.listarLancamentos();
			break;
		case 2:
			this.criarLancamentos();
			break;
		case 3:
			this.removerLancamentos();
			break;
		case 4:
			this.alterarLancamentos();
			break;
		case 5:
			this.voltarAoMenuUsuario();
			break;
		default:
			System.out.println("Sele��o inv�lida.");
			break;
		}
	}

	private void exibirMenuUsuarios() {
		System.out.println("\n\n");
		
		System.out.println("-- Gerenciar Usu�rios --");
		System.out.println(
				"Selecione operacao: \n" + "  1) listar\n" + "  2) criar\n" + "  3) remover\n" + "  4) alterar\n "
						+ " 5) gerenciar lan�amentos de usu�rio \n " + " 6) voltar ao menu principal \n ");

		int selection = input.nextInt();
		input.nextLine();

		switch (selection) {
		case 1:
			this.listarUsuarios();
			break;
		case 2:
			this.criarUsuario();
			break;
		case 3:
			this.removerUsuario();
			break;
		case 4:
			this.alterarUsuario();
			break;
		case 5:
			this.gerenciarLancamentos();
			break;
		case 6:
			this.voltarAoMenuPrincipal();
			break;
		default:
			System.out.println("Sele��o inv�lida.");
			break;
		}
	}

	private void exibirMenuCriarLan�amentos() {
		
		System.out.println("\n\n");
		System.out.println(String.format("-- Criar novo lancamento para usu�rio %s --", usuarioSelecionado.toString()));
		System.out.println("  1) receita\n" + "  2) despesa\n" + "  3) despesa parcelada\n");

		int selection = input.nextInt();
		input.nextLine();

		switch (selection) {
		case 1:
			this.criarReceita();
			break;
		case 2:
			this.criarDespesa();
			break;
		case 3:
			this.criarDespesaParcelada();
			break;
		default:
			System.out.println("Sele��o inv�lida.");
			break;
		}
	}

	
	private void criarDespesaParcelada() {
		System.out.println("-- Criar Lan�amento de Despesa Parcelada --");

		System.out.println("Digite o ID da conta\n");
		int idConta = input.nextInt();
		input.nextLine();

		System.out.println("Digite a descri��o\n");
		String descricao = input.next();
		input.nextLine();

		System.out.println("Digite o valor total\n");
		float valor = input.nextFloat();
		input.nextLine();

		System.out.println("Digite o n�mero de parcelas \n");
		int numeroDeParcelas = input.nextInt();
		input.nextLine();

		ArrayList<Lancamento> criados = dataStore.criarLancamentoDespesaParcelada(usuarioSelecionado, idConta, descricao, valor, numeroDeParcelas);
		
		if (criados == null){
			System.out.println("ERRO: n�o foi poss�vel criar lan�amento de despesa parcelada");
			
		}else{
			for (Lancamento parcela : criados){
				System.out.println(parcela.toString() + '\n');
				System.out.println("valor total: " + parcela.getValorTotal()+ '\n');
				
			}
			
		}

	}

	private void criarDespesa() {
		System.out.println("-- Criar Lan�amento de Despesa --");

		System.out.println("Digite o ID da conta\n");
		int idConta = input.nextInt();
		input.nextLine();

		
		System.out.println("Digite a descri��o\n");
		String descricao = input.next();
		input.nextLine();
		
		System.out.println("Digite o valor\n");
		float valor = input.nextFloat();
		input.nextLine();

		Lancamento criado = dataStore.criarLancamentoDespesa(usuarioSelecionado, idConta, descricao, valor);
		
		if (criado == null){
			System.out.println("ERRO: n�o foi poss�vel criar lan�amento de despesa");
		}else{
			System.out.println(criado.toString() + '\n');
			System.out.println("valor total: " + criado.getValorTotal()+ '\n');
		}
		
	}

	private void criarReceita() {
		System.out.println("-- Criar Lan�amento de Receita --");

		System.out.println("Digite o ID da conta\n");
		int idConta = input.nextInt();
		input.nextLine();

		
		System.out.println("Digite a descri��o\n");
		String descricao = input.next();
		input.nextLine();
		
		System.out.println("Digite o valor\n");
		float valor = input.nextFloat();
		input.nextLine();

		Lancamento criado = dataStore.criarLancamentoReceita(usuarioSelecionado, idConta, descricao, valor);
		
		if (criado == null){
			System.out.println("ERRO: n�o foi poss�vel criar lan�amento");
		}else{
			System.out.println(criado.toString() + '\n');
			System.out.println("valor total: " + criado.getValorTotal()+ '\n');
		}

	}

	private void voltarAoMenuUsuario() {
		deveVoltarMenuUsuarios = true;
		
	}

	private void gerenciarBancos() {
		deveVoltarMenuPrincipal = false;

		while (!deveVoltarMenuPrincipal) {
			exibirMenuBancos();
		}

	}

	private void gerenciarUsuarios() {
		deveVoltarMenuPrincipal = false;

		while (!deveVoltarMenuPrincipal) {
			exibirMenuUsuarios();

		}

	}

	private void gerenciarContas() {
		deveVoltarMenuPrincipal = false;

		while (!deveVoltarMenuPrincipal) {
			exibirMenuContas();
		}

	}

	private void gerenciarLancamentos() {
		/**
		 * antes de prosseguir, deve identificar o usu�rio
		 * 
		 */
		System.out.println("\n");
		System.out.println("-- Digite o ID do usu�rio que deve ser gerenciado --");
		
		int idUsuario = input.nextInt();
		input.nextLine();

		usuarioSelecionado = dataStore.getUsuarioForId(idUsuario);
		
		if (usuarioSelecionado==null){
			deveVoltarMenuUsuarios = true;
			System.out.println(String.format("-- ERRO: Usu�rio com id %d n�o encontrado  --", idUsuario));
			
		}else{
			deveVoltarMenuUsuarios = false;
			
		}
		
		while (!deveVoltarMenuUsuarios) {
			exibirMenuLancamentos();
		}

	}


	private void voltarAoMenuPrincipal() {
		this.deveVoltarMenuPrincipal = true;
	}

	private void sair() {
		System.out.println("-- obrigado por utilizar o Gerenciador Financeiro --");
		deveSair = true;
	}

	private void alterarConta() {
		System.out.println("-- Alterar Conta --");
		System.out.println("-- n�o implementado --");
	}

	private void removerConta() {
		System.out.println("-- Remover Conta --");
		System.out.println("-- n�o implementado --");
	}

	private void criarConta() {
		System.out.println("-- Criar Conta --");
		System.out.println("-- n�o implementado --");
	}

	private void listarContas() {
		System.out.println("-- Listar Conta --");
		System.out.println("-- n�o implementado --");
	}

	private void alterarBanco() {
		System.out.println("-- Alterar Banco --");
		System.out.println("-- n�o implementado --");
	}

	private void removerBanco() {
		System.out.println("-- Remover Banco --");
		System.out.println("-- n�o implementado --");
	}

	private void criarBanco() {
		System.out.println("-- Criar Banco --");
		System.out.println("-- n�o implementado --");
	}

	private void listarBancos() {
		System.out.println("-- Listar Bancos --");
		System.out.println("-- n�o implementado --");
	}

	private void alterarLancamentos() {
		System.out.println("-- Alterar Lan�amento --");
		System.out.println("-- n�o implementado --");
	}

	private void removerLancamentos() {
		System.out.println("-- Remover Lan�amento --");
		System.out.println("-- n�o implementado --");
		
	}

	private void criarLancamentos() {
		exibirMenuCriarLan�amentos();
	}

	private void listarLancamentos() {
		System.out.println("\n\n");
		for (Lancamento l : usuarioSelecionado.getListaLancamentos()){
			System.out.println(String.format("%s - valor total : %f", l.toString() , l.getValorTotal()));
		}
	}

	private void alterarUsuario() {
		System.out.println("-- Alterar Usu�rio --");
		System.out.println("-- n�o implementado --");
	}

	private void removerUsuario() {
		System.out.println("-- Remover Usu�rio --");
		System.out.println("-- n�o implementado --");
	}

	private void criarUsuario() {
		System.out.println("-- Criar Usu�rio --");
		System.out.println("-- n�o implementado --");
	}

	private void listarUsuarios() {
		System.out.println("-- Usu�rios -- \n");
		
		for (Usuario u : dataStore.getListaUsuario()){
			System.out.println(u.toString() + "\n");
		}
		
		
		
		
	}

}
