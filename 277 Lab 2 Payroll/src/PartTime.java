/**
 * 
 * @author Kenny Do
 *	CECS 277
 */
public class PartTime extends Staff {
	private int hoursWorkedPerWeek;

	/**
	 * Creates an Empty Part Time object
	 */
	public PartTime() {
		super();
		hoursWorkedPerWeek = 0;
	}

	/**
	 * Creates a Part Time Object
	 * @param lName will be stored in the Employee class
	 * @param fName will be stored in the Employee class
	 * @param IDNum will be stored in the Employee class
	 * @param gender will be stored in the Employee class
	 * @param month will be stored in the Employee class
	 * @param day will be stored in the Employee class
	 * @param year will be stored in the Employee class
	 * @param rate will be stored in the Staff class
	 * @param hoursWorkedPerWeek stored in hoursWorkedPerWeek
	 */
	public PartTime(String lName, String fName, String IDNum, char gender, int month, int day, int year, double rate,
			int hoursWorkedPerWeek) {
		super(lName, fName, IDNum, gender, month, day, year, rate);
		this.hoursWorkedPerWeek = hoursWorkedPerWeek;
	}


	/**
	 * @return the hoursWorkedPerWeek
	 */
	public int getHoursWorkedPerWeek() {
		return hoursWorkedPerWeek;
	}



	/**
	 * @param hoursWorkedPerWeek the hoursWorkedPerWeek to set
	 */
	public void setHoursWorkedPerWeek(int hoursWorkedPerWeek) {
		this.hoursWorkedPerWeek = hoursWorkedPerWeek;
	}



	@Override
	/**
	 * Calculates the monthly earning for Part Time employees
	 */
	public double monthlyEarning() {
		return getHourlyRate() * getHoursWorkedPerWeek() * 4;
	}
	
	@Override
	/**
	 * Displays the Part Time information
	 */
	public String toString() {
		StringBuilder string = new StringBuilder().append(super.toString() +  "\n");
		//Deletes Full Time and an extra Monthly Salary from the Staff class
		string.delete(string.indexOf("Full Time"), string.length());	
		string.append("Hours Worked Per Month: " + getHoursWorkedPerWeek() * 4);
		string.append("\nMonthly Earnings: $" + String.format("%.2f", monthlyEarning()));
		return string.toString();
	}
}
