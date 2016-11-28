import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class BankPanel extends JPanel implements ActionListener {
	private JLabel amountLabel;
	private JLabel balanceLabel;
	private JTextField amount;
	private JButton deposit;
	private JButton withdraw;
	private BankAccount acc;
	public BankPanel(BankAccount acc) {
		this.acc = acc; 
		
		amountLabel = new JLabel("Amount:");
		amount = new JTextField(20); 
		
		withdraw = new JButton("Withdraw");
		deposit = new JButton("Deposit");
		withdraw.addActionListener(this);
		deposit.addActionListener(this);
		
		balanceLabel = new JLabel("balance=" + new Double(acc.getBalance()).toString());
		
		this.add(amountLabel);
		this.add(amount);
		this.add(withdraw);
		this.add(deposit);
		
		this.add(balanceLabel);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		try {
			if(source == withdraw) {
				acc.withdraw(Double.parseDouble(amount.getText()));
			} else if(source == deposit) {
				acc.deposit(Double.parseDouble(amount.getText()));
			}
			balanceLabel.setText("balance=" + new Double(acc.getBalance()).toString());
		} catch (NumberFormatException e1) {
			balanceLabel.setText("balance=" + new Double(acc.getBalance()).toString() + " - You FOO");
		}
	}
	
}
