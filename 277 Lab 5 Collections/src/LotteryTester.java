import java.util.Set;

public class LotteryTester {

	public static void main(String[] args) {
		Set<Integer> winning = Lottery.generateWinningNumbers();
		Set<Integer> ticket = Lottery.getTickets();
		System.out.println("Your ticket was: " + ticket.toString());
		System.out.println("Winning numbers: " + winning.toString());
		winning.retainAll(ticket);
		System.out.println("Match Numbers: " + winning.toString());
		double winnings = 0;
		for(int i = 0; i < winning.size(); i++) {
			winnings += 250;
		}
		System.out.printf("You won $%.2f", winnings);
	}

}