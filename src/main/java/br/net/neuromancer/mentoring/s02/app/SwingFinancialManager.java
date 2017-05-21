package br.net.neuromancer.mentoring.s02.app;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import br.net.neuromancer.mentoring.s01.model.Bank;

public class SwingFinancialManager {
	
	private static Bank bank1 = new Bank(0, "First Bank");
	private static Bank bank2 = new Bank(1, "Second Bank");
	
	private static Bank[] banksVector = { bank1, bank2 } ;

	private static JFrame mainFrame;

	final JOptionPane optionPane = new JOptionPane(
		    "Should we leave the exercise?",
		    JOptionPane.QUESTION_MESSAGE,
		    JOptionPane.YES_NO_OPTION);
	

	public static void main(String[] args) {
		// Schedule a job for the event-dispatching thread:
		// creating and showing this application's GUI.
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}

	/**
	 * Create the GUI and show it. For thread safety, this method should be
	 * invoked from the event-dispatching thread.
	 */
	private static void createAndShowGUI() {
		// Create and set up the window.
		mainFrame = new JFrame("SwingFinancialManager");
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Create and set up the content pane.
		SwingFinancialManager demo = new SwingFinancialManager();
		mainFrame.setJMenuBar(demo.createMenuBar());
		mainFrame.setContentPane(demo.createBankPane());

		// Display the window.
		mainFrame.setSize(450, 260);
		mainFrame.setVisible(true);

	}

	public JMenuBar createMenuBar() {
		JMenuBar menuBar;

		// Create the menu bar.
		menuBar = new JMenuBar();
		
		// Bank menu
		JMenu bankMenu = new JMenu("Banks");

		// CRUD - Create
		//
		JMenuItem addBanksItem = new JMenuItem("Add");
		addBanksItem.setMnemonic(KeyEvent.VK_A);
		addBanksItem.getAccessibleContext().setAccessibleDescription("addBanks");

		addBanksItem.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String bankName = (String)JOptionPane.showInputDialog(
				                    mainFrame,
				                    "Type the name of the new bank : ",
				                    "Create Bank (Crud)",
				                    JOptionPane.PLAIN_MESSAGE,
				                    null,
				                    null,
				                    null);
				
				if (bankName!=null){
					addBank(bankName);
				}
				
				mainFrame.getContentPane().removeAll();
				mainFrame.setContentPane(SwingFinancialManager.this.createBankPane());
				mainFrame.validate();
				mainFrame.repaint();
			}
			
		});
		
		bankMenu.add(addBanksItem);

		// CRUD - Retrieve
		//
		JMenuItem showBanksItem = new JMenuItem("Show");
		showBanksItem.setMnemonic(KeyEvent.VK_S);
		showBanksItem.getAccessibleContext().setAccessibleDescription("showBanks");

		showBanksItem.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				mainFrame.getContentPane().removeAll();
				mainFrame.setContentPane(SwingFinancialManager.this.createBankPane());
				mainFrame.validate();
				mainFrame.repaint();
			}
			
		});

		bankMenu.add(showBanksItem);
		
		// CRUD - Delete
		//
		JMenuItem removeBanksItem = new JMenuItem("Remove");
		removeBanksItem.setMnemonic(KeyEvent.VK_R);
		removeBanksItem.getAccessibleContext().setAccessibleDescription("removeBanks");

		removeBanksItem.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				String response = (String)JOptionPane.showInputDialog(
	                    mainFrame,
	                    "Type the id of the bank to be removed: ",
	                    "Remove Bank (Crud)",
	                    JOptionPane.PLAIN_MESSAGE,
	                    null,
	                    null,
	                    null);
				
				try{
					Integer bankId = Integer.parseInt(response);
					removeBank(new Bank(bankId, "whatever"));
					
				}catch(NumberFormatException ne){
				    Object[] options = {"OK"};
				    int n = JOptionPane.showOptionDialog(mainFrame,
				                   "please enter a valid id! ","Invalid",
				                   JOptionPane.PLAIN_MESSAGE,
				                   JOptionPane.QUESTION_MESSAGE,
				                   null,
				                   options,
				                   options[0]);
					
				}
	
				// refresh content pane
				refreshBankView();
			}

			
		});

		bankMenu.add(removeBanksItem);
		
		menuBar.add(bankMenu);

		// Build the leave menu action
		JMenuItem leaveMenuItem;
		
		leaveMenuItem = new JMenuItem("Leave");
		leaveMenuItem.setMnemonic(KeyEvent.VK_L);
		leaveMenuItem.getAccessibleContext().setAccessibleDescription("Leave the app");
		leaveMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (mainFrame.isDisplayable()) {
					
					int n = JOptionPane.showConfirmDialog(
							mainFrame,
						    "Would you like to leave the app?",
						    "An Inane Question",
						    JOptionPane.YES_NO_OPTION);
					
					if (n==JOptionPane.YES_OPTION){
						mainFrame.dispose();
						System.out.println("leaving the SwingFinancialManager app");
						System.exit(0);
						
					}
				}
			}
		});
		menuBar.add(leaveMenuItem);

		return menuBar;
	}
	
	public Container createBankPane(){
		JPanel contentPane = new JPanel(new BorderLayout());
		contentPane.setOpaque(true);
		
		String[] bankColumns = {"Id", "Name"};
		
		Object[][] bankData = new Object[banksVector.length][2];
		
		for (int i=0; i<banksVector.length; i++){
			bankData[i][0]=banksVector[i].getId();
			bankData[i][1]=banksVector[i].getName();
		}
		
		JTable table = new JTable(bankData, bankColumns);
		
        table.setPreferredScrollableViewportSize(new Dimension(500, 70));
        table.setFillsViewportHeight(true);
        
        contentPane.removeAll();
        
        JScrollPane scrollPane = new JScrollPane(table);
        
		contentPane.add(scrollPane, BorderLayout.CENTER);

		return contentPane;
	}

	
	private void addBank(String bankName){
		ArrayList<Bank> a = new ArrayList<>(Arrays.asList(banksVector));
		a.add(new Bank(nextBankSequence(), bankName));
		banksVector = new Bank[a.size()];
		a.toArray(banksVector);
		
	}
	
	private void removeBank(Bank bank){
		ArrayList<Bank> a = new ArrayList<>(Arrays.asList(banksVector));
		a.remove(bank);
		banksVector = new Bank[a.size()];
		a.toArray(banksVector);
	}
	
	private int nextBankSequence(){
		int maxId = -1;
		
		for (Bank b : banksVector){
			if (b.getId()>maxId){
				maxId = b.getId();
			}
		}
		
		return ++maxId;
	}

	private void refreshBankView() {
		mainFrame.getContentPane().removeAll();
		mainFrame.setContentPane(SwingFinancialManager.this.createBankPane());
		mainFrame.validate();
		mainFrame.repaint();
	}

	
}
