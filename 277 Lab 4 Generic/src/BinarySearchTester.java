import java.util.Scanner;

public class BinarySearchTester {

	public static void main(String[] args) {
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
				break;
			case 3:
				search(bs, in);
				break;
			}
			System.out.println();
			menuInput = menu(in);
		}
		in.close();
	}

	private static void search(BinarySearcher<Faculty> bs, Scanner in) {
		System.out.println("Search for what ID number?");
		int input = in.nextInt();
		System.out.println("Search for Id " + input + ": " + bs.search(new Faculty("", input)));
	}

	private static int menu(Scanner in) {
		System.out.println("1. Display List");
		System.out.println("2. Sort List");
		System.out.println("3. Search List");
		System.out.println("4. Exit");
		int input = in.nextInt();
		return input;
	}

	private static void printArray(Faculty[] fac) {
		for(int i = 0; i < fac.length; i++) {
			System.out.println(fac[i].toString());
		}
	}

}
