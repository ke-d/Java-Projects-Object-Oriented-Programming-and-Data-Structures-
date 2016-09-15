import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.GregorianCalendar;
/**
 * 
 * @author Kenny Do
 *	CECS 277
 */
public abstract class Employee implements Comparable<Employee>, Cloneable {
	
	/**
	 * Stores the last name
	 */
	private String lastName;
	
	/**
	 * Stores the first name
	 */
	private String firstName;
	
	/**
	 * Stores the ID Number
	 */
	private String IDNumber;
	
	/**
	 * Stores the gender
	 */
	private char sex;
	
	/**
	 * Stores the birthdate
	 */
	private Calendar birthDate;
	
	/**
	 * Creates an empty employee
	 */
	public Employee() {
		lastName = null;
		firstName = null;
		IDNumber = null;
		sex = '\0';
		birthDate = new GregorianCalendar();
	}
	
	/**
	 * Makes an Employee object
	 * @param lName stored in lastName
	 * @param fName stored in firstName
	 * @param IDNum stored in IDNumber
	 * @param gender stored in sex
	 * @param month is used for the birth date
	 * @param day is used for the birth date
	 * @param year is used for the birth date
	 */
	public Employee(String lName,String fName, String IDNum, char gender, int month, int day, int year) {
		lastName = lName;
		firstName = fName;
		IDNumber = IDNum;
		sex = gender;
		birthDate = new GregorianCalendar();
		birthDate.set(Calendar.MONTH, month);
		birthDate.set(Calendar.DAY_OF_MONTH, day);
		birthDate.set(Calendar.YEAR, year);
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
	 * @return the iDNumber
	 */
	public String getIDNumber() {
		return IDNumber;
	}

	/**
	 * @param iDNumber the iDNumber to set
	 */
	public void setIDNumber(String iDNumber) {
		IDNumber = iDNumber;
	}

	/**
	 * @return the sex
	 */
	public char getSex() {
		return sex;
	}

	/**
	 * @param sex the sex to set
	 */
	public void setSex(char sex) {
		this.sex = sex;
	}

	/**
	 * @return the birthDate
	 */
	public Calendar getBirthDate() {
		return birthDate;
	}

	/**
	 * Sets the birthdate
	 * @param month is used for the birth date
	 * @param day is used for the birth date
	 * @param year is used for the birth date
	 */
	public void setBirthDate(int month, int day, int year) {
		birthDate = new GregorianCalendar();
		birthDate.set(Calendar.MONTH, month);
		birthDate.set(Calendar.DAY_OF_MONTH, day);
		birthDate.set(Calendar.YEAR, year);
	}

	/**
	 * Calculates the monthly earning using Polymorphism
	 * @return the monthly earning
	 */
	public abstract double monthlyEarning();

	@Override
	/**
	 * Clones the employee object
	 */
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	@Override
	/**
	 * Compares the employee objects by descending ID numbers
	 */
	public int compareTo(Employee employee) {
		int compareQuantity = Integer.parseInt(employee.getIDNumber().trim());
		return compareQuantity - Integer.parseInt(IDNumber.trim());
	}
	
	/**
	 * Returns a comparator object
	 * @return a Comparator Employee Object
	 */
	public static Comparator<Employee> EmployeeNameComparator() {
		return new EmployeeComparator();
	}
	
	
	@Override
	/**
	 * Outputs the class information
	 */
	public String toString() {
		StringBuilder string = new StringBuilder();
		string.append("ID Employee Number: " + IDNumber + "\nEmployee Name: " + firstName + " " + lastName + "\nBirthdate: ");
		SimpleDateFormat format1 = new SimpleDateFormat("MMMM dd, yyyy");
		Date date = birthDate.getTime();
		string.append(format1.format(date));
		return string.toString();
	}
	
	/**
	 * Nested class that implements Comparator
	 */
	static class EmployeeComparator implements Comparator<Employee> {
		@Override
		/**
		 * Compares the employee objects by last name
		 */
		public int compare(Employee employee1, Employee employee2) {
			return employee1.getLastName().compareTo(employee2.getLastName());
		}
	}
}
