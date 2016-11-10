import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

/**
 * @author Kenny Do
 * Problem Set 5
 */
public class PuzzleTester {
	public static void main(String[] args) throws CloneNotSupportedException {
		//Initialize the arrays
		ArrayList<Integer> initial = new ArrayList<>(Arrays.asList(2, 8, 3, 1, 6, 4, 7, 0, 5));
		ArrayList<Integer> goal = new ArrayList<>(Arrays.asList(1, 2, 3, 8, 0, 4, 7, 6, 5));

		//Initialize the puzzle and puzzle goal
		EightPuzzle puzzle = new EightPuzzle(initial);
		EightPuzzle puzzleGoal = new EightPuzzle(goal);
		
		//Solves the puzzle WARNING: Might take a while
		SolvePuzzle(puzzle, puzzleGoal);

	}

	/**
	 * Solves the puzzle with a given initial state and a goal state with steps to reach that goal state
	 * @param initial the initial step
	 * @param goal is goal step
	 * @throws CloneNotSupportedException
	 */
	private static void SolvePuzzle(EightPuzzle initial, EightPuzzle goal) throws CloneNotSupportedException {
		//Stores the puzzle states not yet visited and potential future states
		Queue<EightPuzzle> openSet = new ArrayDeque<>();
		//Stores the puzzle states that already have been visited
		Set<EightPuzzle> closedSet = new HashSet<>();
		//Stores the parent state of the key (Makes it easier to trace back the steps)
		Map<EightPuzzle, EightPuzzle> parents = new HashMap<>();
		
		//We already know the initial state so add it to the closedSet
		closedSet.add(initial);
		//Add all potential states from the initial state to the openSet
		openSet.addAll(initial.getPossibleStates());
		
		while (!openSet.isEmpty()) {
			//The state that we are looking at
			EightPuzzle current = openSet.remove();
			
			//Add the state to closedSet because we already visited it
			closedSet.add(current);
			
			if (current.equals(goal)) {
				//A LinkedList to store the states needed to reach the goal
				LinkedList<EightPuzzle> statesToReachGoal = new LinkedList<>();
				statesToReachGoal.add(current);
				//This will go through the Map and add each current's parents to the front of 
				//the Linked List until the while loop reaches the initial state which the key is not in the Map
				while (parents.containsKey(current)) {
					statesToReachGoal.offerFirst(parents.get(current));
					current = (EightPuzzle) parents.get(current).clone();
				}
				statesToReachGoal.offerFirst(current);
				
				//Prints ALL the states to reach the goal state
				int steps = 0;
				for (EightPuzzle road : statesToReachGoal) {
					steps++;
					System.out.println("Step " + steps);
					System.out.println(road);
					System.out.println();
				}
				break;
			} else {
				//Get the next batch of possible states
				List<EightPuzzle> states = current.getPossibleStates();
				for (EightPuzzle p : states) {
					//If the possible state is not in either Set, then push the possible state to the openSet and 
					//put it and its parent in the Map
					if (!closedSet.contains(p) && !openSet.contains(p)) {
						openSet.offer(p);
						parents.put(p, current);
					}
				}
			}

		}
	}

}
