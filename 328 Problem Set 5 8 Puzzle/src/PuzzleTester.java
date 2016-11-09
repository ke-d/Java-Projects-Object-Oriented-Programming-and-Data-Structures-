import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.Stack;

public class PuzzleTester {
	public static void main(String[] args) throws CloneNotSupportedException {
		ArrayList<Integer> initial = new ArrayList<>(Arrays.asList(2, 8, 3, 1, 6, 4, 7, 0, 5));
		ArrayList<Integer> goal = new ArrayList<>(Arrays.asList(1, 2, 3, 8, 0, 4, 7, 6, 5));

		EightPuzzle puzzle = new EightPuzzle(initial);
		EightPuzzle puzzleGoal = new EightPuzzle(goal);
		
		SolvePuzzle(puzzle, puzzleGoal);

	}

	private static void SolvePuzzle(EightPuzzle initial, EightPuzzle goal) throws CloneNotSupportedException {
		Stack<EightPuzzle> openSet = new Stack<>();
		Set<EightPuzzle> closedSet = new HashSet<>();
		Map<EightPuzzle, EightPuzzle> parents = new HashMap<>();
		closedSet.add(initial);
		openSet.addAll(initial.getPossibleStates());
		while (!openSet.isEmpty()) {
			EightPuzzle current = openSet.pop();
			closedSet.add(current);
			if (current.equals(goal)) {
				LinkedList<EightPuzzle> statesToReachGoal = new LinkedList<>();
				statesToReachGoal.add(current);
				while (parents.containsKey(current)) {
					statesToReachGoal.offerFirst(parents.get(current));
					current = (EightPuzzle) parents.get(current).clone();
				}
				statesToReachGoal.offerFirst(current);
				int steps = 0;
				for (EightPuzzle road : statesToReachGoal) {
					steps++;
					System.out.println("Step " + steps);
					System.out.println(road);
					System.out.println();
				}
				break;
			} else {
				List<EightPuzzle> states = current.getPossibleStates();
				for (EightPuzzle p : states) {
					if (!closedSet.contains(p)) {
						if (!openSet.contains(p)) {
							openSet.push(p);
							parents.put(p, current);
						}
					}
				}
			}

		}
	}

}
