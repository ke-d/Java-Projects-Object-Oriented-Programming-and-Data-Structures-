import java.util.Scanner;

public class BinarySearchTester {

	public static void main(String[] args) {
		boolean isSorted = false;
		Faculty[] fac = {new Faculty("Bob", 2021),new Faculty("Carl", 1900),new Faculty("Tom", 3421),new Faculty("Karl", 2919),new Faculty("Dezel", 1000)};
		BinarySearcher<Faculty> bs = new BinarySearcher<>(fac);
		Scanner in = new Scanner(System.in);
		int menuInput = menu(in);
		while(menuInput != 4) {
			switch(menuInput) {
			case 1:
				printArray(fac);
				break;
			case 2:
				InsertionSort.sort(fac);
				System.out.println("List Sorted");
				isSorted = true;
				break;
			case 3:
				if (isSorted) {
					try {
						System.out.println(fac[search(bs, in)].getName() + " found!");
					} catch (ArrayIndexOutOfBoundsException e) {
						System.out.println("Id Num not found");
					}
				} else {
					System.out.println("List not sorted");
				}
				break;
			}
			System.out.println();
			menuInput = menu(in);
		}
		in.close();
	}

	/**
	 * Searches for the an id num
	 * @param bs the searcher
	 * @param in the scanner
	 * @return the index where the id num exists
	 */
	private static int search(BinarySearcher<Faculty> bs, Scanner in) {
		System.out.println("Search for what ID number?");
		int input = in.nextInt();
		return bs.search(new Faculty("", input));
	}

	/**
	 * Display a menu
	 * @param in the scanner
	 * @return the menu index
	 */
	private static int menu(Scanner in) {
		System.out.println("1. Display List");
		System.out.println("2. Sort List");
		System.out.println("3. Search List");
		System.out.println("4. Exit");
		int input = in.nextInt();
		return input;
	}

	/**
	 * Print the array
	 * @param fac the array to print
	 */
	private static void printArray(Faculty[] fac) {
		for(int i = 0; i < fac.length; i++) {
			System.out.println(fac[i].toString());
		}
	}

}
