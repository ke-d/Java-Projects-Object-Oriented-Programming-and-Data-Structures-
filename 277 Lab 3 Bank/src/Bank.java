import java.util.ArrayList;
import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.NoSuchElementException;

/**
 * A bank contains account numbers and balances of each customer.
 */
public class Bank {
	private ArrayList<BankAccount> accountList;

	/**
	 * Construct a Bank object.
	 */

	/**
	 * Reads a file with account numbers and balances and adds the accounts to the bank.
	 * 
	 * @param filename the name of the file
	 * @throws IOException 
	 */
	public void readFile(String filename) throws IOException {
		// Create File object, a scanner object to read data from the file.
		// call the method read
		File reader = new File(filename);
		Scanner in = new Scanner(reader);

		try {
			read(in);
		} finally {
			in.close();
		}
	}

	/**
	 * Read a file with account numbers and balances and adds the accounts to
	 * the bank.
	 * 
	 * @param in the scanner for reading the input
	 */
	private void read(Scanner in) throws IOException, NoSuchElementException {
		while (in.hasNext()) {
			// Create a BankAccount object
			BankAccount acc = new BankAccount();
			// input data for the BankAccount object
			acc.read(in);
			// Add the BankAccount object to the accountlist
			addAccount(acc);

		}
	}

	/**
	 * Add an account to the bank.
	 * 
	 * @param b the BankAccount reference
	 */
	public void addAccount(BankAccount b) {
		accountList.add(b);
	}

	/**
	 * Gets the account with the highest balance.
	 * 
	 * @return the account with the highest balance
	 */
	public BankAccount getHighestBalance() {
		return new BankAccount();
	}
}