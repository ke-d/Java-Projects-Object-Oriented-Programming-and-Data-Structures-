import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class MapTester {
	/**
	 * Enum of the Menu items
	 * @author Kenny Do
	 *
	 */
	public enum Menu {
		ADD, REMOVE, MODIFY, PRINT, EXIT;
	}
	
	/**
	 * Enum of the Performance evaluations
	 * @author Kenny Do
	 *
	 */
	public enum Performance {
		EXCELLENT, GOOD, SATISFACTORY, IMPROVEMENT;
	}
	
	/**
	 * The scanner input for the user input
	 */
	static Scanner input;
	public static void main(String[] args) {
		input = new Scanner (System.in);
		Map<Integer, Employee> employeeMap = new TreeMap<Integer, Employee> ();
		
		Map<Employee, Performance> performanceMap = new TreeMap<Employee, Performance> ();

		int in = printMenuAndGetChoice();
		while(in >= 1 && in <= 4) {
		in--;
		Menu choice = Menu.values()[in];
			switch (choice) {
			case ADD:
				addEmployee(employeeMap, performanceMap);
				break;
			case REMOVE:
				removeEmployee(employeeMap, performanceMap);
				break;
			case MODIFY:
				modifyEmployee(employeeMap, performanceMap);
				break;
			case PRINT:
				printEmployee(performanceMap);
				break;
			case EXIT:
				break;
			}
			System.out.println();
			in = printMenuAndGetChoice();
		}
		input.close();
	}
	
	/**
	 * Add an employee to the employeeMap and performanceMap
	 * @param employeeMap stores the ID as the key and the employee object
	 * @param performanceMap stores the Employee and the Performance of that employee
	 */
	private static void addEmployee(Map<Integer, Employee> employeeMap, Map<Employee, Performance> performanceMap) {
		int id;
		String lastName;
		String firstName;
		
		System.out.println("Enter ID:");
		id = input.nextInt();

		if (!employeeMap.containsKey(id)) {
			System.out.println("Enter First Name:");
			firstName = input.next();
			System.out.println("Enter Last Name:");
			lastName = input.next();
			Employee em = new Employee(id, lastName, firstName);
			employeeMap.put(id, em);
			Performance perf = getPerformanceFromUser();
			performanceMap.put(em, perf);
			System.out.println("Employee Added");
		} else {
			System.out.println("ID already in map");
		}
	}

	/**
	 * Remove an employee from the employeeMap and performanceMap
	 * @param employeeMap the map to remove from
	 * @param performanceMap the map to remove from
	 */
	private static void removeEmployee(Map<Integer, Employee> employeeMap, Map<Employee, Performance> performanceMap) {
		System.out.println("Enter an ID to remove:");
		int id = input.nextInt();
		if(employeeMap.containsKey(id)) {
			Employee removed = employeeMap.get(id);
			performanceMap.remove(removed);
			employeeMap.remove(id);	
			System.out.println("Employee Removed");
		} else {
			System.out.println("Employee not in Map");
		}
		
	}
	
	/**
	 * Modify an employee from the employeeMap and performanceMap
	 * @param employeeMap the map to modify from
	 * @param performanceMap the map to modify from
	 */
	private static void modifyEmployee(Map<Integer, Employee> employeeMap, Map<Employee, Performance> performanceMap) {
		System.out.println("Enter an ID to modify:");
		int id = input.nextInt();
		if(employeeMap.containsKey(id)) {
			System.out.println(id + " Found");
			Employee modify = employeeMap.get(id);
			Performance perfModify = getPerformanceFromUser();
			performanceMap.put(modify, perfModify);
			System.out.println("Performance changed");
		} else {
			System.out.println("Employee not in Map");
		}
	}

	/**
	 * Display all the employees and their respective performance
	 * @param performanceMap the map to display from
	 */
	private static void printEmployee(Map<Employee, Performance> performanceMap) {
		for(Map.Entry<Employee, Performance> entry : performanceMap.entrySet()) {
			System.out.println(entry.getKey() + ", Performance = " + entry.getValue());
		}
	}
	
	/**
	 * Prints the menu from the Menu enum and gets the choice from the user
	 * @return the int corresponding the the Menu
	 */
	public static int printMenuAndGetChoice() {
		Menu items[] = Menu.values();
		for(int i = 0; i < items.length; i++) {
			System.out.println((i + 1) + ". " + items[i]);
		}
		int in = input.nextInt();
		return in;
	}

	/**
	 * Prints the performance from the Performance enum and gets the input from the user
	 * @return the corresponding Performance enum based on use input
	 */
	private static Performance getPerformanceFromUser() {
		System.out.println("Enter a performance:");
		Performance items[] = Performance.values();
		for(int i = 0; i < items.length; i++) {
			System.out.println((i + 1) + ". " + items[i]);
		}
		int in = input.nextInt();
		in--;
		return items[in];
	}
}
