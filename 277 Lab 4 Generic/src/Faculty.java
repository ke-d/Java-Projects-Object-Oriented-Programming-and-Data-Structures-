
public class Faculty implements Comparable<Faculty> {
	/**
	 * The name of the Faculty member
	 */
	private String name;
	
	/**
	 * The salary of the Faculty member
	 */
	private double salary;
	
	/**
	 * Creates an Faculty object
	 * @param name is the name of the Faculty
	 * @param salary is the salary of the Faculty
	 */
	public Faculty(String name, double salary) {
		this.name = name;
		this.salary = salary;
	}

	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}


	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}


	/**
	 * @return the salary
	 */
	public double getSalary() {
		return salary;
	}


	/**
	 * @param salary the salary to set
	 */
	public void setSalary(double salary) {
		this.salary = salary;
	}


	@Override
	/**
	 * Compares the salary to another employee
	 */
	public int compareTo(Faculty o) {
		Double sal1 = new Double(salary);
		Double sal2 = new Double(o.getSalary());
		return sal1.compareTo(sal2);
	}
	
	
	@Override
	/**
	 * Outputs the contents of this class
	 */
	public String toString() {
		return "Faculty [name=" + name + ", salary=" + salary + "]";
	}

	
}
