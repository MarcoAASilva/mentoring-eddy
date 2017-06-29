package br.net.neuromancer.mentoring.s04.app;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import br.net.neuromancer.mentoring.s04.model.Banco;
import br.net.neuromancer.mentoring.s04.model.Categoria;
import br.net.neuromancer.mentoring.s04.model.Conta;
import br.net.neuromancer.mentoring.s04.model.Lancamento;
import br.net.neuromancer.mentoring.s04.model.LancamentoDespesa;
import br.net.neuromancer.mentoring.s04.model.LancamentoDespesaParcelada;
import br.net.neuromancer.mentoring.s04.model.LancamentoReceita;
import br.net.neuromancer.mentoring.s04.model.Usuario;

/**
 * A classe DataStore é responsável por armazenar os dados
 * 
 * "it mocks persistence"
 * 
 * ou melhor, atua como repositório de entidades (como um banco de dados)
 * 
 * @author Dreamcaster
 *
 */

public class GerenciadorFinanceiroDataStore {
	ArrayList<Banco> listaBancos;
	
	ArrayList<Conta> listaContas;
	
	ArrayList<Usuario> listaUsuarios;
	
	ArrayList<Categoria> listaCategorias;

	public GerenciadorFinanceiroDataStore() {
		super();
		
		listaBancos = new ArrayList<Banco>();
		listaContas = new ArrayList<Conta>();
		listaUsuarios = new ArrayList<Usuario>();
		listaCategorias = new ArrayList<Categoria>();
	}
	
	// deve ser chamado antes da UI entrar em ação para realizar uma pré-carga de dados
	//
	public void realizaPreCarga(){
		criarBancosPreCarga();
		criarUsuariosPreCarga();
		criarContasPreCarga();
		criarCategoriasPreCarga();
		
		associarUsuariosAContasELancamentos();
	}
	
	// categorias seriam muito melhor representadas por enumerations
	//
	private void criarCategoriasPreCarga() {
		listaCategorias.add(new Categoria(0, "Receita", ""));
		listaCategorias.add(new Categoria(1, "Despesa", ""));
		listaCategorias.add(new Categoria(2, "DespesaParcelada", ""));
		
	}
	
	public ArrayList<Banco> getListaBancos() {
		return listaBancos;
	}

	public ArrayList<Conta> getListaConta() {
		return listaContas;
	}

	public ArrayList<Usuario> getListaUsuario() {
		return listaUsuarios;
	}
	
	public Usuario getUsuarioForId(int id){
		for (Usuario u : listaUsuarios){
			if (u.getId()==id){
				return u;
			}
		}
		
		return null;
	}
	
	public Conta getContaForId(int id){
		for (Conta c : listaContas){
			if (c.getId()==id){
				return c;
			}
		}
		
		return null;
	}
	

	

	private void criarUsuariosPreCarga() {
		listaUsuarios.add( new Usuario(0, "Eddy", "eddy", "telecom123") );
		listaUsuarios.add( new Usuario(1, "Vedder", "vedder", "telecom123") );
	}

	private void criarContasPreCarga() {
		listaContas.add( new Conta(0, 0, listaBancos.get(0) ));
		listaContas.add( new Conta(1, 1, listaBancos.get(1) ));
	}

	private void criarBancosPreCarga() {
		listaBancos.add(new Banco(0, "Santander"));
		listaBancos.add(new Banco(1, "Credit Suisse"));
	}


	
	// o modelo proposto dá espaço pra muita ambiguidade
	// Lancamentos e Contas não deveriam estar associadas diretamente ao Usuario
	// cabe à interface validar que um lançamento não seja adicionado para uma conta que não pertence ao usuário
	//
	private void associarUsuariosAContasELancamentos() {
		// criando algumas lançamentos para o usuário 0
		//
		
		Usuario eddy = listaUsuarios.get(0);
		
		eddy.getListaContas().add(listaContas.get(0));
		
		LancamentoReceita rec1 = new LancamentoReceita(0, listaContas.get(0), "primeira receita", 10000.0f, listaCategorias.get(0), new Date());

		eddy.getListaLancamentos().add(rec1);
		
		LancamentoDespesa des1 = new LancamentoDespesa(1, listaContas.get(0), "primeira compra", 500.0f, listaCategorias.get(1), new Date());
		
		eddy.getListaLancamentos().add(des1);
		
		Calendar cal = Calendar.getInstance(); 

		LancamentoDespesa desPar1 = new LancamentoDespesaParcelada(2, listaContas.get(0), "primeira despesa parcelada 1/3", 500.0f, listaCategorias.get(1), cal.getTime(), 3);

		eddy.getListaLancamentos().add(desPar1);

		cal.add(Calendar.MONTH, 1);

		LancamentoDespesa desPar2 = new LancamentoDespesaParcelada(3, listaContas.get(0), "primeira despesa parcelada 2/3", 500.0f, listaCategorias.get(1), cal.getTime(), 3);

		eddy.getListaLancamentos().add(desPar2);

		cal.add(Calendar.MONTH, 1);
		
		LancamentoDespesa desPar3 = new LancamentoDespesaParcelada(4, listaContas.get(0), "primeira despesa parcelada 3/3", 500.0f, listaCategorias.get(1), cal.getTime(), 3);

		eddy.getListaLancamentos().add(desPar3);

		
		// criando lançamentos para segundo usuário
		
		Usuario vedder = listaUsuarios.get(1);
		
		vedder.getListaContas().add(listaContas.get(1));
		
		LancamentoReceita rec2 = new LancamentoReceita(5, listaContas.get(1), "primeira receita", 10000.0f, listaCategorias.get(0), new Date());

		vedder.getListaLancamentos().add(rec2);
		
		LancamentoDespesa des2 = new LancamentoDespesa(6, listaContas.get(1), "primeira compra", 500.0f, listaCategorias.get(1), new Date());
		
		vedder.getListaLancamentos().add(des2);
		
		cal = Calendar.getInstance(); 

		LancamentoDespesa desPar4 = new LancamentoDespesaParcelada(7, listaContas.get(1), "primeira despesa parcelada 1/2", 500.0f, listaCategorias.get(2), cal.getTime(), 2);

		vedder.getListaLancamentos().add(desPar4);

		cal.add(Calendar.MONTH, 1);

		LancamentoDespesa desPar5 = new LancamentoDespesaParcelada(8, listaContas.get(1), "primeira despesa parcelada 2/2", 500.0f, listaCategorias.get(2), cal.getTime(), 2);

		vedder.getListaLancamentos().add(desPar5);
		
	}

	public Lancamento criarLancamentoReceita(Usuario usuarioCreditado, int idConta, String descricao, float valor) {
		Conta contaCreditada = null;
		
		for (Conta c : usuarioCreditado.getListaContas()){
			if (c.getId()==idConta){
				contaCreditada = c;
				break;
			}
		}
		
		if (contaCreditada==null){
			System.out.println(String.format("conta com id %d não pertence ao usuário %s", idConta, usuarioCreditado));
			return null;
		}
		
		LancamentoReceita novoLancamento = new LancamentoReceita(getMaxLancamentoId(), contaCreditada, descricao, valor, listaCategorias.get(0), new Date());
		
		usuarioCreditado.getListaLancamentos().add(novoLancamento);
		
		return novoLancamento;
		
	}

	public Lancamento criarLancamentoDespesa(Usuario usuarioDebitado, int idConta, String descricao, float valor) {
		Conta contaDebitada = null;
		
		for (Conta c : usuarioDebitado.getListaContas()){
			if (c.getId()==idConta){
				contaDebitada = c;
				break;
			}
		}
		
		if (contaDebitada==null){
			System.out.println(String.format("conta com id %d não pertence ao usuário %s", idConta, usuarioDebitado));
			return null;
		}
		
		LancamentoDespesa novoLancamento = new LancamentoDespesa(getMaxLancamentoId(), contaDebitada, descricao, valor, listaCategorias.get(1), new Date());
		
		usuarioDebitado.getListaLancamentos().add(novoLancamento);
		
		return novoLancamento;
		
	}

	private int getMaxLancamentoId(){
		int maxId = 0;
		
		for (Usuario u : listaUsuarios){
			for (Lancamento l : u.getListaLancamentos()){
				if (maxId<l.getId()){
					maxId = l.getId();
				}
			}
		}
		
		return ++maxId;
	}

	public ArrayList<Lancamento> criarLancamentoDespesaParcelada(Usuario usuarioDebitado, int idConta, String descricao,
			float valor, int numeroDeParcelas) {
		Conta contaDebitada = null;
		
		for (Conta c : usuarioDebitado.getListaContas()){
			if (c.getId()==idConta){
				contaDebitada = c;
				break;
			}
		}
		
		if (contaDebitada==null){
			System.out.println(String.format("conta com id %d não pertence ao usuário %s", idConta, usuarioDebitado));
			return null;
		}
		
		if (numeroDeParcelas<=0){
			System.out.println(String.format("numero de parcelas %d precisa ser maior do que zero", numeroDeParcelas));
			return null;
			
		}
		
		ArrayList<Lancamento> parcelas = new ArrayList<Lancamento>();
		
		Calendar cal = Calendar.getInstance();
		
		Integer maxLancamentoId = getMaxLancamentoId();
		
		for (int i=0; i<numeroDeParcelas; i++){
			LancamentoDespesaParcelada novoLancamento = new LancamentoDespesaParcelada(maxLancamentoId+i, contaDebitada, descricao + " " + (i+1) + "/" + numeroDeParcelas, valor / numeroDeParcelas, listaCategorias.get(2), cal.getTime(), numeroDeParcelas);
			parcelas.add(novoLancamento);
			cal.add(Calendar.MONTH, 1);
		}
		
		
		usuarioDebitado.getListaLancamentos().addAll(parcelas);
		
		return parcelas;
	}
	
}
