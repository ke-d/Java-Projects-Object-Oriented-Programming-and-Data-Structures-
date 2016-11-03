import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class MapTester {
	public enum Menu {
		ADD, REMOVE, MODIFY, PRINT, EXIT;
	}
	
	public enum Performance {
		EXCELLENT, GOOD, SATISFACTORY, IMPROVEMENT;
	}
	
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

	}
	
	private static void addEmployee(Map<Integer, Employee> employeeMap, Map<Employee, Performance> performanceMap) {
		int id;
		String lastName;
		String firstName;
		
		System.out.println("Enter ID:");
		id = input.nextInt();
		System.out.println("Enter First Name:");
		firstName = input.next();
		System.out.println("Enter Last Name:");
		lastName = input.next();
		
		Employee em = new Employee(id, lastName, firstName);
		employeeMap.put(id, em);
		Performance perf = getPerformanceFromUser();
		performanceMap.put(em, perf);
	}


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
	
	private static void modifyEmployee(Map<Integer, Employee> employeeMap, Map<Employee, Performance> performanceMap) {
		System.out.println("Enter an ID to remove:");
		int id = input.nextInt();
		if(employeeMap.containsKey(id)) {
			Employee modify = employeeMap.get(id);
			Performance perfModify = getPerformanceFromUser();
			performanceMap.put(modify, perfModify);
		} else {
			System.out.println("Employee not in Map");
		}
	}

	private static void printEmployee(Map<Employee, Performance> performanceMap) {
		System.out.println(performanceMap.toString());
		
	}

	public static int printMenuAndGetChoice() {
		Menu items[] = Menu.values();
		for(int i = 0; i < items.length; i++) {
			System.out.println((i + 1) + ". " + items[i]);
		}
		int in = input.nextInt();
		return in;
	}

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
