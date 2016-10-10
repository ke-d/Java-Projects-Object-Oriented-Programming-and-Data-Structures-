import java.util.ArrayList;

public abstract class Measurable {
	public abstract double getMeasure();
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
