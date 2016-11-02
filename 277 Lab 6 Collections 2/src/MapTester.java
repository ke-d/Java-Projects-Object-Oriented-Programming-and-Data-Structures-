import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class MapTester {
	public enum Menu {
		ADD(1), REMOVE(2), MODIFIY(3), PRINT(4);
		
		private int code;
		 
	    private Menu(int code) {
	        this.code = code;
	    }
	 
	    public int getCode() {
	        return code;
	    }
	}
	static Scanner input;
	public static void main(String[] args) {
		input = new Scanner (System.in);
		Map<Integer, Employee> e = new TreeMap<Integer, Employee> ();
		
		Map<Employee, String> ep = new TreeMap<Employee, String> ();
		
		int in = printMenuAndGetChoice();
		while(in >= 1 || in <= 4) {
			switch (Menu) {
			
			}
		}

	}
	
	public static int printMenuAndGetChoice() {
		System.out.println("1. Add");
		System.out.println("2. Remove");
		System.out.println("3. Modify");
		System.out.println("4. Print");
		int in = input.nextInt();
		return in;
	}

}
