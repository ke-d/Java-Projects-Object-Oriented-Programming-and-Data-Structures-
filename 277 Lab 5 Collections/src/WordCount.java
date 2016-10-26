import java.io.File;
import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class WordCount {
	static Map<String, Integer> wordMap = new HashMap<String, Integer> ();
	public static void main(String[] arg) {
		createMap(wordMap);
		displayMap(wordMap);
	}

	private static void createMap(Map<String, Integer> map) {
		// Read data from the file line by line
		File file = new File("data.txt");
		Scanner input = null;
		String[] tokens = null;
		try {
			input = new Scanner(file);
			
		} catch (FileNotFoundException e) {
			System.err.println("Your file is not found");
		}
		while (input.hasNextLine()) {
			String inputLine = input.nextLine();
			tokens = inputLine.split(" ");
			//Each token stores in the map word
			for (String s : tokens) {
				if (!map.containsKey(s)) {
					map.put(s, 1);
				} else {
					int count = map.get(s).intValue();
					count++;
					map.put(s, count);
				}
			} 
		}
	}

	private static void displayMap(Map<String, Integer> map) {
		// Get key set
		Set<String> s = map.keySet();
		// Make a tree set
		Set<String> ts = new TreeSet<String> (new StringCompare());
		ts.addAll(s);
		System.out.println(map.toString());
		System.out.println(ts.toString());
	}
	
	static class StringCompare implements Comparator<String> {

		@Override
		public int compare(String arg0, String arg1) {
			if(wordMap.get(arg0) > wordMap.get(arg1)) {
				return -1;
			} else {
				return 1;
			}
		}
		
	}
}
