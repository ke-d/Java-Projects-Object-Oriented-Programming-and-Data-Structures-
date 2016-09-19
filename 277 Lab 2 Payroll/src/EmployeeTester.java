import java.util.Arrays;
/**
 * 
 * @author Kenny Do
 *	CECS 277
 */
public class EmployeeTester {

	public static void main(String[] args) {
		Staff Allen = new Staff ("Allen", "Paita", "123", 'M', 1,23,1959, 50.0);
		Staff Zapata = new Staff ("Zapata", "Steven", "456", 'F', 6,12,1964, 35.0);
		Staff Rios = new Staff ("Rios", "Enrique", "789", 'M', 5,2,1970, 40.0);
		
		Faculty Johnson = new Faculty ("Johnson", "Anne", "243", 'F', 3,27,1962, FacultyLevel.FU,"Ph.D","Engineering",3);
		Faculty Bouris = new Faculty ("Bouris", "William", "791", 'F', 2,14,1975, FacultyLevel.AO,"Ph.D","English",1);
		Faculty Andrade = new Faculty ("Andrade", "Christopher", "623", 'F', 4,22,1980, FacultyLevel.AS,"MS","Physical Education",0);
		
		PartTime Guzman = new PartTime ("Guzman", "Augusto", "455", 'F', 7,10,1977, 35.0,30);
		PartTime Depirro = new PartTime ("Depirro", "Martin", "678", 'F', 8,15,1987, 30.0,15);
		PartTime Aldaco = new PartTime ("Aldaco", "Marque", "945", 'M', 10,24,1988, 20.0,35);
		
		Employee[] CSULB = {Allen, Zapata, Rios, Johnson, Bouris, Andrade, Guzman, Depirro, Aldaco};
		
		System.out.println("Part A: Employee information using the method toString");
		for(Employee e : CSULB) {
			System.out.println(e);
			System.out.println();
		}
		
		System.out.println("Part B: Total monthly salary for all the part-time staff");
		double monthlySalaryPartTime = 0;
		for(Employee e : CSULB) {
			if(e instanceof PartTime) {
				monthlySalaryPartTime += e.monthlyEarning();
			}
		}
		System.out.println("$" + String.format("%.2f", monthlySalaryPartTime));
		System.out.println();
		
		double monthlySalaryEmployees = 0;
		System.out.println("Part C: Total monthly salary for all employees");
		for(Employee e : CSULB) {
			monthlySalaryEmployees += e.monthlyEarning();

		}
		System.out.println("$" + String.format("%.2f", monthlySalaryEmployees));
		System.out.println();
		
		System.out.println("Part D: Display all employee information descending by employee id using interface Comparable");
		Arrays.sort(CSULB);
		for(Employee e : CSULB) {
			System.out.println(e);
			System.out.println();
		}
		System.out.println();
		
		System.out.println("Part E: Display all employee information ascending by last name using interface Comparer");
		Arrays.sort(CSULB, Employee.EmployeeNameComparator());
		
		for(Employee e : CSULB) {
			System.out.println(e);
			System.out.println();
		}
		
		System.out.println("Part F: Duplicate a faculty object using clone. Verify the duplication");
		Faculty clone = null;
		try {
			clone = (Faculty) CSULB[2].clone();
		} catch (CloneNotSupportedException e1) {
			System.out.println("Clone not supported");
		}
		clone.setEducation(new Education("Ph.D", "Computer Science", 10));
		clone.setFirstName("Chris");
		clone.setIDNumber("2452");
		clone.setBirthDate(4, 14, 1970);
		clone.setLevel(FacultyLevel.FU);
		System.out.println("Clone: ");
		System.out.println(clone);
		System.out.println(clone.getEducation());
		System.out.println();
		
		System.out.println("Original: ");
		Faculty original = (Faculty) CSULB[2];
		System.out.println(original);
		System.out.println(original.getEducation());
	}

}
