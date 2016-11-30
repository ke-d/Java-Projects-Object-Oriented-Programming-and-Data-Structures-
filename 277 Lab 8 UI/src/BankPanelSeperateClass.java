import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class BankPanelSeperateClass extends JPanel {
	/**
	 * The Label for the amount
	 */
	public JLabel amountLabel;

	/**
	 * The label for the balance
	 */
	public JLabel balanceLabel;

	/**
	 * The text field for the amount that the user inputs
	 */
	public JTextField amount;

	/**
	 * Button for deposit
	 */
	public JButton deposit;

	/**
	 * Button for withdraw
	 */
	public JButton withdraw;

	/**
	 * Stores the BankAccount
	 */
	public BankAccount acc;

	/**
	 * Creates a BankAccount Panel
	 * 
	 * @param acc the BankAccount
	 */
	public BankPanelSeperateClass(BankAccount acc) {
		this.acc = acc;
		this.setLayout(new BorderLayout());
		JPanel row1 = new JPanel();
		amountLabel = new JLabel("Amount:");
		amount = new JTextField(20);

		withdraw = new JButton("Withdraw");
		deposit = new JButton("Deposit");

		ActionListener listener = new SeperateButtonHandler(this);

		withdraw.addActionListener(listener);
		deposit.addActionListener(listener);

		balanceLabel = new JLabel("balance=" + new Double(acc.getBalance()).toString());

		row1.add(amountLabel);
		row1.add(amount);
		row1.add(withdraw);
		row1.add(deposit);
		JPanel row2 = new JPanel();
		row2.add(balanceLabel);
		this.add(row1, BorderLayout.NORTH);
		this.add(row2, BorderLayout.CENTER);
	}



}
