
public class Employee implements Comparable <Employee>{
	/**
	 * ID of the employee
	 */
	private int id;
	
	/**
	 * The last name of the employee
	 */
	private String lastName;
	
	/**
	 * The first name of the employee
	 */
	private String firstName;

	/**
	 * @param id the id
	 * @param lastName the last name
	 * @param firstName the first name
	 */
	public Employee(int id, String lastName, String firstName) {
		this.id = id;
		this.lastName = lastName;
		this.firstName = firstName;
	}
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	/**
	 * Compares to another employee
	 */
	public int compareTo(Employee arg0) {
		if(lastName.equals(arg0.getLastName())) {
			if(firstName.equals(arg0.getFirstName())) {
				return id - arg0.getId();
			}
			return firstName.compareTo(arg0.getFirstName());
		}
		return lastName.compareTo(arg0.getLastName());
	}


	@Override
	/**
	 * Hash code for the employee class
	 */
	public int hashCode() {
		final int HASH_MULTIPLIER = 29;
		int h = HASH_MULTIPLIER * firstName.hashCode() + lastName.hashCode();
		h = HASH_MULTIPLIER * h + ((Integer)id).hashCode();
		return h;
	}


	@Override
	/**
	 * How an employee class is equal to another
	 */
	public boolean equals(Object obj) {
		if(obj instanceof Employee) {
			Employee emp = (Employee)obj;
			if(firstName.equals(emp.getFirstName()) && lastName.equals(emp.getLastName()) && id == emp.getId()) {
				return true;
			}
		}
		return false;
	}


	@Override
	/**
	 * toString of the employee class
	 */
	public String toString() {
		return "id = " + id + ", lastName = " + lastName + ", firstName = " + firstName;
	}
	 

}
