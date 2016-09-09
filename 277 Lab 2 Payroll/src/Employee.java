import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public abstract class Employee {
	private String lastName;
	private String firstName;
	private String IDNumber;
	private char sex;
	private Calendar birthDate;
	

	public Employee() {
		lastName = null;
		firstName = null;
		IDNumber = null;
		sex = '\0';
		birthDate = new GregorianCalendar();
	}
	
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
	 * @param birthDate the birthDate to set
	 */
	public void setBirthDate(Calendar birthDate) {
		this.birthDate = birthDate;
	}

	public abstract double monthlyEarning();

	@Override
	public String toString() {
		StringBuilder string = new StringBuilder();
		string.append("ID Employee Number: " + IDNumber + "\nEmployee Name: " + firstName + " " + lastName + "\nBirthdate: ");
		SimpleDateFormat format1 = new SimpleDateFormat("MMMM dd, yyyy");
		Date date = birthDate.getTime();
		string.append(format1.format(date));
		return string.toString();
	}
}
