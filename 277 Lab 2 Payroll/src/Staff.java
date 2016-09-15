/**
 * 
 * @author Kenny Do
 *	CECS 277
 */
public class Staff extends Employee {
	
	/**
	 * Stores the hourly rate
	 */
	private double hourlyRate;
	
	/**
	 * Creates a empty staff object
	 */
	public Staff() {
		super();
		hourlyRate = 0;
	}
	
	/**
	 * Creates a Staff object
	 * @param lName will be stored in the Employee class
	 * @param fName will be stored in the Employee class
	 * @param IDNum will be stored in the Employee class
	 * @param gender will be stored in the Employee class
	 * @param month will be stored in the Employee class
	 * @param day will be stored in the Employee class
	 * @param year will be stored in the Employee class
	 * @param rate stored in hourlyRate
	 */
	public Staff(String lName, String fName, String IDNum, char gender, int month, int day, int year, double rate) {
		super(lName, fName, IDNum, gender, month, day, year);
		hourlyRate = rate;
	}

	/**
	 * @return the hourlyRate
	 */
	public double getHourlyRate() {
		return hourlyRate;
	}

	/**
	 * @param hourlyRate the hourlyRate to set
	 */
	public void setHourlyRate(double hourlyRate) {
		this.hourlyRate = hourlyRate;
	}

	
	@Override
	/**
	 * Displays the Staff information
	 */
	public String toString() {
		StringBuilder string = new StringBuilder(super.toString());
		string.append("\nFull Time\nMonthly Salary: ");
		string.append(monthlyEarning());
		return string.toString();
	}

	@Override
	/**
	 * Calculates the monthly earning for the Staff employee
	 */
	public double monthlyEarning() {
		return hourlyRate * EmployeeInfo.STAFF_MONTHLY_HOURS_WORKED;
	}

}
