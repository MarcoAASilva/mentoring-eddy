package app;
 
 import java.util.Date;
 
 import modelo.Conta;
 import modelo.Banco;
 import modelo.Lancamento;
 import modelo.ItemLancamento;
 import modelo.Categoria;
 import modelo.Usuario;
 
 public class GerenciadorFinanceiro {
 	
 	public static void main(String[] args){
 		System.out.println("Construindo um objeto Grafo baseado nas regras do exercício...\n");
 
		GerenciadorFinanceiro gerenciador = new GerenciadorFinanceiro();
 		gerenciador.build();
 	}
 
 	
 	public void build(){
 		// cria Bancos
 		
 		Banco banco1 = new Banco(0, "Unibanco");
 		Banco banco2 = new Banco(1, "Banespa");
 		
 		
 		// associa Bancos às contas
 		
 		Conta conta1 = new Conta(0, 0, banco1);
 		Conta conta3 = new Conta(2, 2, banco1);
 
 		Conta conta2 = new Conta(1, 1, banco2);
 		Conta conta4 = new Conta(3, 3, banco2);
 
 		
 		// associate Accounts to Banks (other side of the bi-directional attribute)
 		
 		banco1.addConta(conta1);
 		banco1.addConta(conta3);
 		
 		banco2.addConta(conta2);
 		banco2.addConta(conta4);
		
		
 		// cria Usuários
 		Usuario usuario0 = new Usuario(0, "John Snow", "john.snow", "blackcrow");
		Usuario usuario1 = new Usuario(1, "Arya Stark", "arya.stark", "nobody");
		
 		// associa Contas aos Usuários
 		usuario0.addConta(conta1);
 		usuario0.addConta(conta2);
 		
 		usuario1.addConta(conta3);
 		usuario1.addConta(conta4);
 		
 		// cria Categorias
 		Categoria tipo1 = new Categoria(0, "débito", "debitcard");
 		Categoria tipo2 = new Categoria(1, "paypal", "online");
 		
 		// cria o primeiro lançamento
 		
 		Lancamento lancamento0 = new Lancamento(0, "Primeiro Lancamento", tipo1, conta1);
 		
 		ItemLancamento itemLancamento0 = new ItemLancamento(0, new Date(), 10);
 		ItemLancamento itemLancamento1 = new ItemLancamento(1, new Date(), 20);
 		ItemLancamento itemLancamento2 = new ItemLancamento(2, new Date(), 30);
 		
 		lancamento0.addItemLancamento(itemLancamento0);
 		lancamento0.addItemLancamento(itemLancamento1);
 		lancamento0.addItemLancamento(itemLancamento2);
 		
 		// associa Lançamento a uma conta
 		conta1.addLancamento(lancamento0);
 		

 		usuario0.addLancamento(lancamento0);
 		
 		// cria o segundo lançamento
 		
 		Lancamento lancamento1 = new Lancamento(1, "Segundo lançamento", tipo2, conta2);
 		
 		ItemLancamento itemLancamento3 = new ItemLancamento(3, new Date(), 10);
 		ItemLancamento itemLancamento4 = new ItemLancamento(4, new Date(), 20);
 		ItemLancamento itemLancamento5 = new ItemLancamento(5, new Date(), 30);
 		
 		lancamento1.addItemLancamento(itemLancamento3);
 		lancamento1.addItemLancamento(itemLancamento4);
 		lancamento1.addItemLancamento(itemLancamento5);
 		
 		// got to remember that user1 is associated to account2
 
		conta2.addLancamento(lancamento1);
		usuario0.addLancamento(lancamento1);
 
 		// cria o terceiro Lançamento
 		
 		Lancamento lancamento3 = new Lancamento(2, "Terceiro Lançamento", tipo1, conta3);
 		
 		ItemLancamento itemLancamento6 = new ItemLancamento(6, new Date(), 10);
 		ItemLancamento itemLancamento7 = new ItemLancamento(7, new Date(), 20);
 		ItemLancamento itemLancamento8 = new ItemLancamento(8, new Date(), 30);
 		
 		lancamento3.addItemLancamento(itemLancamento6);
 		lancamento3.addItemLancamento(itemLancamento7);
 		lancamento3.addItemLancamento(itemLancamento8);
 		
 		// got to remember that user1 is associated to account2
 
 		conta3.addLancamento(lancamento3);
 		usuario1.addLancamento(lancamento3);
 		
 
 		// cria o quarto lançamento
 		
 		Lancamento lancamento4 = new Lancamento(3, "Quarto Lançamento", tipo2, conta4);
 		
 		ItemLancamento itemLancamento9 = new ItemLancamento(9, new Date(), 10);
 		ItemLancamento itemLancamento10 = new ItemLancamento(10, new Date(), 20);
 		ItemLancamento itemLancamento11 = new ItemLancamento(11, new Date(), 30);
 		
 		lancamento4.addItemLancamento(itemLancamento9);
 		lancamento4.addItemLancamento(itemLancamento10);
 		lancamento4.addItemLancamento(itemLancamento11);
 		
 		// got to remember that user1 is associated to account2
 
 		conta4.addLancamento(lancamento4);
 		usuario1.addLancamento(lancamento4);
 
 		// Imprime os usuários
 		
 		System.out.println("Primeiro Usuário");
 		System.out.println(usuario0.toString());
 		
 		System.out.println("Segundo Usuário");
 		System.out.println(usuario1.toString());
 		
 	}
 	
 }