import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class BankPanelInnerClass extends JPanel {
	/**
	 * The Label for the amount
	 */
	private JLabel amountLabel;

	/**
	 * The label for the balance
	 */
	private JLabel balanceLabel;

	/**
	 * The text field for the amount that the user inputs
	 */
	private JTextField amount;

	/**
	 * Button for deposit
	 */
	private JButton deposit;

	/**
	 * Button for withdraw
	 */
	private JButton withdraw;

	/**
	 * Stores the BankAccount
	 */
	private BankAccount acc;

	/**
	 * Creates a BankAccount Panel
	 * 
	 * @param acc the BankAccount
	 */
	public BankPanelInnerClass(BankAccount acc) {
		this.acc = acc;
		this.setLayout(new BorderLayout());
		JPanel row1 = new JPanel();
		amountLabel = new JLabel("Amount:");
		amount = new JTextField(20);

		withdraw = new JButton("Withdraw");
		deposit = new JButton("Deposit");

		ActionListener listener = new ButtonHandler();

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

	class ButtonHandler implements ActionListener {
		/**
		 * Event handler for the buttons
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			Object source = e.getSource();
			try {
				if (source == withdraw) {
					acc.withdraw(Double.parseDouble(amount.getText()));
				} else if (source == deposit) {
					acc.deposit(Double.parseDouble(amount.getText()));
				}
				balanceLabel.setText("balance=" + new Double(acc.getBalance()).toString());
			} catch (NumberFormatException e1) {
				balanceLabel.setText("balance=" + new Double(acc.getBalance()).toString() + " - Error");
			}
		}
	}
}
