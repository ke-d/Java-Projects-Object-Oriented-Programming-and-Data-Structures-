
public class PartTime extends Staff {
	private int hoursWorkedPerWeek;

	/**
	 * 
	 */
	public PartTime() {
		super();
		hoursWorkedPerWeek = 0;
	}

	/**
	 * @param lName
	 * @param fName
	 * @param IDNum
	 * @param gender
	 * @param month
	 * @param day
	 * @param year
	 * @param rate
	 * @param hoursWorkedPerWeek
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
	public double monthlyEarning() {
		return getHourlyRate() * getHoursWorkedPerWeek() * 4;
	}
	
	@Override
	public String toString() {
		StringBuilder string = new StringBuilder().append(super.toString() +  "\n");
		//Deletes Full Time and an extra Monthly Salary from the Staff class
		string.delete(string.indexOf("Full Time"), string.length());	
		string.append("Hours Worked Per Month: " + getHoursWorkedPerWeek() * 4);
		string.append("\nMonthly Salary: " + monthlyEarning());
		return string.toString();
	}
}
