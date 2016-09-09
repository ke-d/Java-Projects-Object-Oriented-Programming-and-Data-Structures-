
public class Staff extends Employee {
	
	private double hourlyRate;
	

	public Staff() {
		super();
		hourlyRate = 0;
	}

	public Staff(String lName, String fName, String IDNum, char gender, int day, int month, int year, double rate) {
//		super(lName, fName, IDNum, gender, day, month, year);
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder string = new StringBuilder(super.toString());
		string.append("\nFull Time\nMonthly Salary: ");
		string.append(monthlyEarning());
		return string.toString();
	}

	@Override
	public double monthlyEarning() {
		return hourlyRate * EmployeeInfo.STAFF_MONTHLY_HOURS_WORKED;
		
	}

}
