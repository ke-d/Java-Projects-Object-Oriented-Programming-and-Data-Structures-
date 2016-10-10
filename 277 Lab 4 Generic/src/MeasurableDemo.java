import java.util.ArrayList;

public class MeasurableDemo {
	public static void main(String[] args) {
		ArrayList<MeasurableString> words = new ArrayList<MeasurableString>();
		words.add(new MeasurableString("Mary"));
		words.add(new MeasurableString("had"));
		words.add(new MeasurableString("a"));
		words.add(new MeasurableString("little"));
		words.add(new MeasurableString("lamb"));
		System.out.println("Largest word: " + Measurable.largest(words));
		System.out.println("Expected: little");
	}
}
