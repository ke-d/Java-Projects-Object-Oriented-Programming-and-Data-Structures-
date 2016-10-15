/**
 * Kenny Do
 * 10/15/16
 * The purpose of this class is to find two numbers that add up to a target sum in an array
 */
import java.util.HashSet;
import java.util.Set;

public class TwoSums {
	/**
	 * Creates a hash set
	 */
	private Set<Integer> hashSet;
	
	/**
	 * Stores the array passed into this class
	 */
	private int array[];
	
	/**
	 * Creates a TwoSums object using an int array
	 * @param arr is the int array
	 */
	TwoSums(int arr[]) {
		hashSet = new HashSet<>();
		array = arr;
		for(int element : arr) {
			hashSet.add(element);
		}
	}
	
	/**
	 * Finds two numbers that adds to the target using the int array 
	 * @param target is the target sum
	 * @return true if it exists else false if no two numbers add up to the array
	 */
	public boolean findTwoSums(int target) {
		for(int element : array) {
			if(hashSet.contains(target - element)) {
				System.out.println("Sum: " + element + " + "  +  (target - element));
				return true;
			}
		}
		System.out.println("Target sum not found: " + target);
		return false;
	}
}
