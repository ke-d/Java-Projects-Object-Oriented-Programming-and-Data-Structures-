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
		
//		System.out.println(Guzman);
		
		for(Employee e : CSULB) {
			System.out.println(e);
			System.out.println();
		}
		
		for(Employee e : CSULB) {
			if(e instanceof PartTime) {
				System.out.println(e.monthlyEarning());
			}
		}
		System.out.println();
		
		for(Employee e : CSULB) {
			System.out.println(e.monthlyEarning());
		}
		System.out.println();
		
	}

}
