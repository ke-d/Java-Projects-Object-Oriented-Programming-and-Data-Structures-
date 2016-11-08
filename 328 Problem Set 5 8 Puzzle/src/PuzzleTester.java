import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.Stack;

public class PuzzleTester {
//	static Stack<EightPuzzle> stack;
//	static Set<EightPuzzle> totalPuzzlesFound;
	public static void main(String[] args) throws CloneNotSupportedException {
//		stack = new Stack<>();
//		totalPuzzlesFound = new HashSet<>();
		ArrayList<Integer> initial = new ArrayList<>(Arrays.asList(2,8,3,1,6,4,7,0,5));
		ArrayList<Integer> goal = new ArrayList<>(Arrays.asList(1,2,3,8,0,4,7,6,5));
		EightPuzzle puzzle = new EightPuzzle(initial);

		EightPuzzle puzzle2 = new EightPuzzle(goal);
		SolvePuzzle(puzzle, puzzle2);
		System.out.println(puzzle);
	}
	private static void SolvePuzzle(EightPuzzle initial, EightPuzzle goal) throws CloneNotSupportedException {
		Stack<EightPuzzle> stack = new Stack<>();
		Set<EightPuzzle> totalPuzzlesFound = new HashSet<>();
		Random rand = new Random();
		int moves = 0;
		while(!initial.equals(goal)) {
			if(initial.visitedAll()) {
				stack.pop();
				initial = (EightPuzzle) stack.pop().clone();
			}
			moves++;
			int randomMove = rand.nextInt(4);
			switch(randomMove) {
			case 0:
				initial.up();
				break;
			case 1:
				initial.down();
				break;
			case 2:
				initial.left();
				break;
			case 3:
				initial.right();
				break;
			
			}
			if(!totalPuzzlesFound.contains(initial)) {
				stack.push((EightPuzzle) initial.clone());
				totalPuzzlesFound.add((EightPuzzle) initial.clone());
			} 
		}
		System.out.println(moves);	
	}

}
