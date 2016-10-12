
public class Faculty implements Comparable<Faculty> {
	private String name;
	private double salary;
	public Faculty(String name, double salary) {
		this.name = name;
		this.salary = salary;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	@Override
	public int compareTo(Faculty o) {
		Double sal1 = new Double(salary);
		Double sal2 = new Double(o.getSalary());
		return sal1.compareTo(sal2);
	}
	
	@Override
	public String toString() {
		return "Faculty [name=" + name + ", salary=" + salary + "]";
	}

	
}
