import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Lottery {
	
	public static Set<Integer> generateWinningNumbers() {
		Set<Integer> lottery = new TreeSet<>();
		Random r = new Random();
		//Generate numbers
		for(int i = 0; i < 6; i++) {
			int random = r.nextInt(40) + 1;
			while(lottery.contains(random)) {
				random = r.nextInt(40) + 1;
			}
			//Store them in a Treeset
			lottery.add(random);
		}
		return lottery;
	}
	
	public static Set<Integer> getTickets() {
		System.out.println("Type 6 lotto numbers:");
		Set<Integer> lottery = new TreeSet<>();
		//From the user input
		Scanner input = new Scanner(System.in);
		int num = 0;
		while(num < 6) {
			
			int userInput;
			try {
				userInput = input.nextInt();
				while(userInput > 40 || userInput < 1 || lottery.contains(userInput)) {
					if (userInput > 40 || userInput < 1) {
						System.err.println("Input must be between 1 and 40");
					} else if(lottery.contains(userInput)) {
						System.err.println("Duplicate");
					}
					userInput = input.nextInt();
				}
				//Store the input in the treeset
				lottery.add(userInput);
				num++;
			} catch (InputMismatchException e) {
				System.err.print("Not an int");
				input.next();
			}

		}
		input.close();
		return lottery;
	}
}