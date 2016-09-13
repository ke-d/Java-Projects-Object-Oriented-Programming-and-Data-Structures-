
public class EmployeeTester {

	public static void main(String[] args) {
		Staff test1 = new Staff ("Do", "Kenny", "1234", 'M', 1,9,1997, 20);
		PartTime test2 = new PartTime ("Do", "Kenny", "1234", 'M', 1,9,1997, 20.0,10);
		Faculty test = new Faculty ("Do", "Kenny", "1234", 'M', 1,9,1997, FacultyLevel.FU,"MS","Computer Science",10);
		System.out.println(test2);
	}

}
