import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SeperateButtonHandler implements ActionListener {
	/**
	 * Stores the Panel for this handler
	 */
	private BankPanelSeperateClass bP;
	
	/**
	 * Constructor for the Bank Panel
	 * @param bP the Bank Panel
	 */
	public SeperateButtonHandler(BankPanelSeperateClass bP) {
		this.bP = bP;
	}
	
	/**
	 * Event handler for the buttons
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		try {
			if (source == bP.withdraw) {
				bP.acc.withdraw(Double.parseDouble(bP.amount.getText()));
			} else if (source == bP.deposit) {
				bP.acc.deposit(Double.parseDouble(bP.amount.getText()));
			}
			bP.balanceLabel.setText("balance=" + new Double(bP.acc.getBalance()).toString());
		} catch (NumberFormatException e1) {
			bP.balanceLabel.setText("balance=" + new Double(bP.acc.getBalance()).toString() + " - Error");
		}
	}
}

