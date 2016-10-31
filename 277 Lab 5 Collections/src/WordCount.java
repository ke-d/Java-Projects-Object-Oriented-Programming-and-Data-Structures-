import java.io.File;
import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class WordCount {
	/**
	 * Stores the amount of time a key appears in a file
	 */
	static Map<String, Integer> wordMap = new HashMap<String, Integer> ();
	
	
	public static void main(String[] arg) {
		File file = new File("data.txt");
		Scanner input = null;
		try {
			input = new Scanner(file);	
		} catch (FileNotFoundException e) {
			System.err.println("Your file is not found");
		}
		createMap(wordMap, input);
		displayMap(wordMap);
	}
	
	/**
	 * Creates a map from a file
	 * @param map the map to be stored
	 * @param input the Scanner
	 */
	private static void createMap(Map<String, Integer> map, Scanner input) {
		String[] tokens = null;
		// Read data from the file line by line
		while (input.hasNextLine()) {
			String inputLine = input.nextLine();
			tokens = inputLine.split(" ");
			//Each token stores in the map word
			for (String s : tokens) {
				String lowerCase = s.toLowerCase();
				if (!map.containsKey(lowerCase)) {
					map.put(lowerCase, 1);
				} else {
					int count = map.get(lowerCase).intValue();
					count++;
					map.put(lowerCase, count);
				}
			} 
		}
	}
	
	/**
	 * Displays the map to the console in the order of most appearance to less appearance
	 * @param map
	 */
	private static void displayMap(Map<String, Integer> map) {
		// Get key set
		Set<String> s = map.keySet();
		s.remove("");
		// Make a tree set
		Set<String> ts = new TreeSet<String> (new StringCompare());
		ts.addAll(s);
//		System.out.println(s.toString());
		Iterator<String> iter = ts.iterator();
		while(iter.hasNext()) {
			String str = iter.next();
			System.out.println(str + ": " + wordMap.get(str));
		}
	}
	
	/**
	 * Comparator class that compares how many times a string appears in the parameter to another
	 * @author Kenny Do
	 *
	 */
	static class StringCompare implements Comparator<String> {

		@Override
		/**
		 * Compares how many times a string appears in the parameter to another
		 */
		public int compare(String arg0, String arg1) {
			if(wordMap.get(arg0) > wordMap.get(arg1)) {
				return -1;
			} else if(wordMap.get(arg0) == wordMap.get(arg1)) {
				return arg0.compareTo(arg1);
			} else {
				return 1;
			}
		}
		
	}
}
