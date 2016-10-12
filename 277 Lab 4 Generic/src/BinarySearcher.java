/**
 * A class for executing binary searches through an array.
 */
public class BinarySearcher<T extends Comparable<T>> {
	private Comparable<T>[] array;

	/**
	 * Constructs a BinarySearcher.
	 * 
	 * @param anArray a sorted array
	 */
	public BinarySearcher(Comparable<T>[] anArray) {
		array = anArray;
	}

	/**
	 * Finds a value in a sorted array, using the binary search algorithm.
	 * 
	 * @param value the value to search
	 * @return the index at which the value occurs, or -1 if it does not occur
	 *         in the array
	 */
	public int search(T value) {
		int low = 0;
		int high = array.length - 1;
		while (low <= high) {
			int mid = (low + high) / 2;
			int diff = array[mid].compareTo(value);

			if (diff == 0) // a[mid] == v
				return mid;
			else if (diff < 0) // a[mid] < v
				low = mid + 1;
			else
				high = mid - 1;
		}
		return -1;
	}
}