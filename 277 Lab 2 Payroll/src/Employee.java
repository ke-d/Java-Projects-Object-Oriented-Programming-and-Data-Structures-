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

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getIDNumber() {
		return IDNumber;
	}

	public void setIDNumber(String iDNumber) {
		IDNumber = iDNumber;
	}

	public char getSex() {
		return sex;
	}

	public void setSex(char sex) {
		this.sex = sex;
	}

	public Calendar getBirthDate() {
		return birthDate;
	}

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
