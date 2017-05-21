package br.net.neuromancer.mentoring.s02.app;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class SwingFinancialManager {

	private JTextArea output;
	private JScrollPane scrollPane;
	private static JFrame mainFrame;

	private static JDialog dialog;

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
		mainFrame.setContentPane(demo.createContentPane());

		// Display the window.
		mainFrame.setSize(450, 260);
		mainFrame.setVisible(true);

		dialog = new JDialog(mainFrame, "Click a button", true);

		dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		dialog.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				System.out.println("Thwarted user attempt to close window.");
			}
		});

	}

	public JMenuBar createMenuBar() {
		JMenuBar menuBar;
		JMenuItem leaveMenuItem;

		// Create the menu bar.
		menuBar = new JMenuBar();

		// Build the leave menu action
		leaveMenuItem = new JMenuItem("Leave");
		leaveMenuItem.setMnemonic(KeyEvent.VK_L);
		leaveMenuItem.getAccessibleContext().setAccessibleDescription("Leave the app");
		leaveMenuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (mainFrame.isDisplayable()) {
					mainFrame.dispose();
				}

				System.out.println("leaving the SwingFinancialManager app");

				System.exit(0);

			}
		});
		menuBar.add(leaveMenuItem);

		return menuBar;
	}

	public Container createContentPane() {
		// Create the content-pane-to-be.
		JPanel contentPane = new JPanel(new BorderLayout());
		contentPane.setOpaque(true);

		// Create a scrolled text area.
		output = new JTextArea(5, 30);
		output.setEditable(false);
		scrollPane = new JScrollPane(output);

		// Add the text area to the content pane.
		contentPane.add(scrollPane, BorderLayout.CENTER);

		return contentPane;
	}

}
