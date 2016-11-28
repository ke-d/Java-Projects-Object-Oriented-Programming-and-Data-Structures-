import javax.swing.JFrame;
import javax.swing.JPanel;

public class BankAccountFrame extends JFrame {

	public BankAccountFrame(BankAccount account) {
		setTitle("The Bank of Banks");
		setSize(500, 150);
		JPanel panel = new BankPanel(account);
		this.add(panel);
	}

}
