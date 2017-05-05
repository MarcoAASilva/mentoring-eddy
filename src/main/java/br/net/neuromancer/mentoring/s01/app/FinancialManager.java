package br.net.neuromancer.mentoring.s01.app;

import java.util.Date;

import br.net.neuromancer.mentoring.s01.model.Account;
import br.net.neuromancer.mentoring.s01.model.Bank;
import br.net.neuromancer.mentoring.s01.model.Transaction;
import br.net.neuromancer.mentoring.s01.model.TransactionItem;
import br.net.neuromancer.mentoring.s01.model.TransactionType;
import br.net.neuromancer.mentoring.s01.model.User;

/**
 * “The definition of management is literally "control," but the definition of true leadership is love.”  
 *  
 * @see         Account
 * @see         Bank
 */
public class FinancialManager {
	
	public static void main(String[] args){
		System.out.println("building an object graph based on the rules of the exercise...\n");

		FinancialManager manager = new FinancialManager();
		manager.build();
	}

	/**
	 * builds a pre-determined object graph for the model
	 * 
	 * @see br.net.neuromancer.mentoring.s01.model
	 * 
	 * @link https://en.wikipedia.org/wiki/Object_graph
	 * 
	 */
	
	public void build(){
		// create Banks
		
		Bank bank1 = new Bank(0, "BayernLB");
		Bank bank2 = new Bank(1, "Commerzbank");
		
		
		// associate Banks to Accounts
		
		Account account1 = new Account(0, 0, bank1);
		Account account3 = new Account(2, 2, bank1);

		Account account2 = new Account(1, 1, bank2);
		Account account4 = new Account(3, 3, bank2);

		
		// associate Accounts to Banks (other side of the bi-directional attribute)
		
		bank1.addAccount(account1);
		bank1.addAccount(account3);
		
		bank2.addAccount(account2);
		bank2.addAccount(account4);
		
		
		// create Users
		User user0 = new User(0, "John Snow", "john.snow", "blackcrow");
		User user1 = new User(1, "Arya Stark", "arya.stark", "nobody");
		
		// associate Accounts to Users
		user0.addAccount(account1);
		user0.addAccount(account2);
		
		user1.addAccount(account3);
		user1.addAccount(account4);
		
		// create TransactionTypes
		TransactionType type1 = new TransactionType(0, "debit", "debitcard");
		TransactionType type2 = new TransactionType(1, "paypal", "online");
		
		// create first Transaction
		
		Transaction transaction0 = new Transaction(0, "first transaction", type1, account1);
		
		TransactionItem transactionItem0 = new TransactionItem(0, new Date(), 10);
		TransactionItem transactionItem1 = new TransactionItem(1, new Date(), 20);
		TransactionItem transactionItem2 = new TransactionItem(2, new Date(), 30);
		
		transaction0.addTransactionItem(transactionItem0);
		transaction0.addTransactionItem(transactionItem1);
		transaction0.addTransactionItem(transactionItem2);
		
		// associate Transaction to Account
		account1.addTransaction(transaction0);
		
		// associate Transaction to User
		// poor design, the User is already indirectly associated to Transactions, through the Account
		
		// got to remember that user1 is associated to account1
		
		user0.addTransaction(transaction0);
		
		// create second Transaction
		
		Transaction transaction1 = new Transaction(1, "second transaction", type2, account2);
		
		TransactionItem transactionItem3 = new TransactionItem(3, new Date(), 10);
		TransactionItem transactionItem4 = new TransactionItem(4, new Date(), 20);
		TransactionItem transactionItem5 = new TransactionItem(5, new Date(), 30);
		
		transaction1.addTransactionItem(transactionItem3);
		transaction1.addTransactionItem(transactionItem4);
		transaction1.addTransactionItem(transactionItem5);
		
		// got to remember that user1 is associated to account2

		account2.addTransaction(transaction1);
		user0.addTransaction(transaction1);

		// create third Transaction
		
		Transaction transaction3 = new Transaction(2, "third transaction", type1, account3);
		
		TransactionItem transactionItem6 = new TransactionItem(6, new Date(), 10);
		TransactionItem transactionItem7 = new TransactionItem(7, new Date(), 20);
		TransactionItem transactionItem8 = new TransactionItem(8, new Date(), 30);
		
		transaction3.addTransactionItem(transactionItem6);
		transaction3.addTransactionItem(transactionItem7);
		transaction3.addTransactionItem(transactionItem8);
		
		// got to remember that user1 is associated to account2

		account3.addTransaction(transaction3);
		user1.addTransaction(transaction3);
		

		// create fourth Transaction
		
		Transaction transaction4 = new Transaction(3, "fourth transaction", type2, account4);
		
		TransactionItem transactionItem9 = new TransactionItem(9, new Date(), 10);
		TransactionItem transactionItem10 = new TransactionItem(10, new Date(), 20);
		TransactionItem transactionItem11 = new TransactionItem(11, new Date(), 30);
		
		transaction4.addTransactionItem(transactionItem9);
		transaction4.addTransactionItem(transactionItem10);
		transaction4.addTransactionItem(transactionItem11);
		
		// got to remember that user1 is associated to account2

		account4.addTransaction(transaction4);
		user1.addTransaction(transaction4);

		// print out the users
		
		System.out.println("first user");
		System.out.println(user0.toString());
		
		System.out.println("second user");
		System.out.println(user1.toString());
		
	}
	
}
