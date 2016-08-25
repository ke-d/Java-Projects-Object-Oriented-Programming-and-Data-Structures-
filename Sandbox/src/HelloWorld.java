import java.util.Scanner;

public class HelloWorld {

	public static void main(String[] args) {
		try(Scanner scan = new Scanner(System.in)) {
		int test = scan.nextInt();
		
		System.out.println(test);
		}
	}

}
