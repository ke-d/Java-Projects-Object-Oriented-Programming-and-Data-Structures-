import javax.swing.JFrame;
import javax.swing.JPanel;

public class BankAccountFrame extends JFrame {

	/**
	 * Creates a Bank Account Frame
	 * @param account the BankAccount
	 */
	public BankAccountFrame(JPanel panel) {
		setTitle(panel.getClass().getName());
		setSize(500, 110);
		setResizable(false);
		setLocationRelativeTo(null); 
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.add(panel);
	}

}
