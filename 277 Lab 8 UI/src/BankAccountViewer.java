import javax.swing.JFrame;

/**
 * A GUI for manipulating a bank account.
 */
public class BankAccountViewer {
	private static final double INITIAL_BALANCE = 1000;

	public static void main(String[] args) {
		BankAccount account = new BankAccount(INITIAL_BALANCE);

		// construct the frame
		JFrame frame = new BankAccountFrame(account);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}