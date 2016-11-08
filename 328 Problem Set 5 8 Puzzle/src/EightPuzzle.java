import java.util.ArrayList;

public class EightPuzzle implements Cloneable {
	private ArrayList<Integer> puzzle;
	private ArrayList<Boolean> visited;
	public EightPuzzle() {
		puzzle = new ArrayList<>();
		visited = new ArrayList<>();
		for(int i = 0; i < 9;i++) {
			visited.add(false);
		}
		setVisited();
	}
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
	 * @param visited the visited to set
	 */
	private void setVisited(ArrayList<Boolean> visited) {
		this.visited = visited;
	}
	public boolean up() {
		int indexZero = findEmpty();
		int indexToSwap = indexZero - 3;
		if(indexToSwap < 0) {
			return false;
		}
		swap(indexZero, indexToSwap);	
		setVisited();
		return true;
	}
	
	public boolean down() {
		int indexZero = findEmpty();
		int indexToSwap = indexZero + 3;
		if(indexToSwap >= puzzle.size()) {
			return false;
		}
		swap(indexZero, indexToSwap);		
		setVisited();
		return true;
	}
	
	public boolean left() {
		int indexZero = findEmpty();
		int indexToSwap = indexZero - 1;
		if(indexZero % 3 == 0) {
			return false;
		}
		swap(indexZero, indexToSwap);
		setVisited();
		return true;
	}
	
	public boolean right() {
		int indexZero = findEmpty();
		int indexToSwap = indexZero + 1;
		if(indexToSwap % 3 == 0) {
			return false;
		}
		swap(indexZero, indexToSwap);	
		setVisited();
		return true;
	}
	
	public boolean visitedAll() {
		return !visited.contains(false);
	}
	
	private void setVisited() {
		visited.set(findEmpty(), true);
	}
	
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
		visited = new ArrayList<>();
		for(int i = 0; i < 9;i++) {
			visited.add(false);
		}
		setVisited();
	}
	
	public int findEmpty() {
		return puzzle.indexOf(0);
	}
	

	@Override
	public String toString() {
		StringBuilder string = new StringBuilder();
		for(int i = 0; i < 9; i++) {
			if(i % 3 == 0 && i != 0) {
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
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((puzzle == null) ? 0 : puzzle.hashCode());
		return result;
	}
	/* (non-Javadoc)
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
	/* (non-Javadoc)
	 * @see java.lang.Object#clone()
	 */
	@Override
	public Object clone() throws CloneNotSupportedException {
		EightPuzzle clone = new EightPuzzle((ArrayList<Integer>) puzzle.clone());
		clone.setVisited((ArrayList<Boolean>) visited.clone());
		return clone;
	}
	


	
}
