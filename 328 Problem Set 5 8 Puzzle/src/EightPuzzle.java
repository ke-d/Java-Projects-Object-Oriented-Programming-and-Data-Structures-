import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Kenny Do
 * Problem Set 5
 */
public class EightPuzzle implements Cloneable {
	/**
	 * Stores the puzzle of the class as an array
	 */
	private ArrayList<Integer> puzzle;

	/**
	 * Creates an empty EightPuzzle class
	 */
	public EightPuzzle() {
		puzzle = new ArrayList<>();

	}
	
	/**
	 * Allows the user to store their own EightPuzzle
	 * @param puzzle to be stored
	 */
	public EightPuzzle(ArrayList<Integer> puzzle) {
		setPuzzle(puzzle);
	}

	/**
	 * @return the puzzle
	 */
	public ArrayList<Integer> getPuzzle() {
		return puzzle;
	}

	/**
	 * Check if there exists a up
	 * @return true if up exists
	 */
	public boolean checkUp() {
		int indexZero = findEmpty();
		int indexToSwap = indexZero - 3;
		if (indexToSwap < 0) {
			return false;
		}
		return true;
	}

	/**
	 * Move to slot up
	 * @return if it was successful
	 */
	public boolean up() {
		int indexZero = findEmpty();
		int indexToSwap = indexZero - 3;
		if (indexToSwap < 0) {
			return false;
		}
		swap(indexZero, indexToSwap);
		return true;
	}

	/**
	 * Check if there exists a down
	 * @return true if down exists
	 */
	public boolean checkDown() {
		int indexZero = findEmpty();
		int indexToSwap = indexZero + 3;
		if (indexToSwap >= puzzle.size()) {
			return false;
		}
		return true;
	}

	/**
	 * Move to slot down
	 * @return if it was successful
	 */
	public boolean down() {
		int indexZero = findEmpty();
		int indexToSwap = indexZero + 3;
		if (indexToSwap >= puzzle.size()) {
			return false;
		}
		swap(indexZero, indexToSwap);
		return true;
	}

	/**
	 * Check if there exists a left
	 * @return true if left exists
	 */
	public boolean checkLeft() {
		int indexZero = findEmpty();
		if (indexZero % 3 == 0) {
			return false;
		}
		return true;
	}

	/**
	 * Move to slot left
	 * @return if it was successful
	 */
	public boolean left() {
		int indexZero = findEmpty();
		int indexToSwap = indexZero - 1;
		if (indexZero % 3 == 0) {
			return false;
		}
		swap(indexZero, indexToSwap);
		return true;
	}

	/**
	 * Check if there exists a right
	 * @return true if right exists
	 */
	public boolean checkRight() {
		int indexZero = findEmpty();
		int indexToSwap = indexZero + 1;
		if (indexToSwap % 3 == 0) {
			return false;
		}
		return true;
	}

	/**
	 * Move to slot right
	 * @return if it was successful
	 */
	public boolean right() {
		int indexZero = findEmpty();
		int indexToSwap = indexZero + 1;
		if (indexToSwap % 3 == 0) {
			return false;
		}
		swap(indexZero, indexToSwap);
		return true;
	}

	/**
	 * Returns the EightPuzzle possible states at this current state
	 * @return a List of possible states
	 * @throws CloneNotSupportedException
	 */
	public List<EightPuzzle> getPossibleStates() throws CloneNotSupportedException {
		List<EightPuzzle> states = new LinkedList<>();
		ArrayList<Integer> random = new ArrayList<>(Arrays.asList(0, 1, 2, 3));
		Collections.shuffle(random);
		for (int i = 0; i < random.size(); i++) {
			if (checkUp() && random.get(i) == 0) {
				EightPuzzle clone = (EightPuzzle) this.clone();
				clone.up();
				states.add(clone);
			}
			if (checkDown() && random.get(i) == 1) {
				EightPuzzle clone = (EightPuzzle) this.clone();
				clone.down();
				states.add(clone);
			}
			if (checkRight() && random.get(i) == 2) {
				EightPuzzle clone = (EightPuzzle) this.clone();
				clone.right();
				states.add(clone);
			}
			if (checkLeft() && random.get(i) == 3) {
				EightPuzzle clone = (EightPuzzle) this.clone();
				clone.left();
				states.add(clone);
			}
		}
		return states;
	}

	/**
	 * Swaps the elements of the ArrayList
	 * @param index1 is the first element
	 * @param index2 is the second element
	 */
	public void swap(int index1, int index2) {
		int temp = puzzle.get(index1);
		puzzle.set(index1, puzzle.get(index2));
		puzzle.set(index2, temp);
	}

	/**
	 * @param puzzle2 the puzzle to set
	 */
	public void setPuzzle(ArrayList<Integer> puzzle2) {
		this.puzzle = (ArrayList<Integer>) puzzle2.clone();

	}

	/**
	 * Find the index of where there is an "empty" slot of the array
	 * @return the index of 0 in the array
	 */
	public int findEmpty() {
		return puzzle.indexOf(0);
	}
	
	/**
	 * Prints the puzzle in an 3 by 3
	 */
	@Override
	public String toString() {
		StringBuilder string = new StringBuilder();
		for (int i = 0; i < 9; i++) {
			if (i % 3 == 0 && i != 0) {
				string.append("\n");
			}
			if (puzzle.get(i) > 0) {
				string.append(puzzle.get(i) + " ");
			} else {
				string.append("  ");
			}
		}

		return string.toString();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((puzzle == null) ? 0 : puzzle.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof EightPuzzle)) {
			return false;
		}
		EightPuzzle other = (EightPuzzle) obj;
		if (puzzle == null) {
			if (other.puzzle != null) {
				return false;
			}
		} else if (!puzzle.equals(other.puzzle)) {
			return false;
		}
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#clone()
	 */
	@Override
	public Object clone() throws CloneNotSupportedException {
		EightPuzzle clone = new EightPuzzle((ArrayList<Integer>) puzzle.clone());
		return clone;
	}

}
