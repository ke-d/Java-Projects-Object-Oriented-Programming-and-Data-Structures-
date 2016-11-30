import javax.swing.JFrame;

/**
 * A GUI for manipulating a bank account.
 */
public class BankAccountViewer {
	private static final double INITIAL_BALANCE = 1000;

	public static void main(String[] args) {
		BankAccount account = new BankAccount(INITIAL_BALANCE);

		// construct the frames
		JFrame frame1 = new BankAccountFrame(new BankPanelInPanel(account));
		JFrame frame2 = new BankAccountFrame(new BankPanelSeperateClass(account));
		JFrame frame3 = new BankAccountFrame(new BankPanelInnerClass(account));
		JFrame frame4 = new BankAccountFrame(new BankPanelAnonymous(account));
	}
}