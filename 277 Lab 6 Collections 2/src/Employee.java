
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
		final int prime = 31;
		int result = 1;
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + id;
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		return result;
	}


	@Override
	/**
	 * How an employee class is equal to another
	 */
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (id != other.id)
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		return true;
	}


	@Override
	/**
	 * toString of the employee class
	 */
	public String toString() {
		return "id = " + id + ", lastName = " + lastName + ", firstName = " + firstName;
	}
	 

}
