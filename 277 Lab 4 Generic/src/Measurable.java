import java.util.ArrayList;

public abstract class Measurable {
	/**
	 * Returns a measurable double of the class
	 * @return a double of the "measure" of the class
	 */
	public abstract double getMeasure();
	
	/**
	 * Return the largest of the "measurable" objects
	 * @param objects the arraylist
	 * @return the largest "measurable" object
	 */
	public static <T extends Measurable, U extends T> T largest(ArrayList<U> objects) {
		//Note: U extends T
		int largestIndex = 0;
		for(int i = 0; i < objects.size(); i++) {
			if(objects.get(i).getMeasure() > objects.get(largestIndex).getMeasure()) {
				largestIndex = i;
			}
		}
		return objects.get(largestIndex);
	}
}
