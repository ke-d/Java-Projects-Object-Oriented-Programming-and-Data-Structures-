/**
 * 
 * @author Kenny Do
 *	CECS 277
 */
public class Faculty extends Employee {
	
	/**
	 * Stores the Faculty Level
	 */
	private FacultyLevel level;
	
	/**
	 * Stores the degree, major, and research done
	 */
	private Education education;
	
	/**
	 * Creates an empty faculty
	 */
	public Faculty() {
		super();
		level = null;
		education = null;
	}
	
	/**
	 * Creates a Faculty object
	 * @param lName will be stored in the Employee class
	 * @param fName will be stored in the Employee class
	 * @param IDNum will be stored in the Employee class
	 * @param gender will be stored in the Employee class
	 * @param month will be stored in the Employee class
	 * @param day will be stored in the Employee class
	 * @param year will be stored in the Employee class
	 * @param level stored in level
	 * @param degree will be stored in the Education class
	 * @param major will be stored in the Education class
	 * @param research will be stored in the Education class
	 */
	public Faculty(String lName,String fName, String IDNum, char gender, int month, int day, int year, FacultyLevel level, String degree, String major, int research) {
		super(lName, fName, IDNum, gender, month, day, year);
		this.level = level;
		education = new Education(degree, major, research);
	}


	/**
	 * @return the level
	 */
	public FacultyLevel getLevel() {
		return level;
	}


	/**
	 * @param level the level to set
	 */
	public void setLevel(FacultyLevel level) {
		this.level = level;
	}


	/**
	 * @return the education
	 */
	public Education getEducation() {
		return education;
	}


	/**
	 * @param education the education to set
	 */
	public void setEducation(Education education) {
		this.education = education;
	}


	@Override
	/**
	 * Calculates the monthly earning for the Faculty employees
	 */
	public double monthlyEarning() {
		double earnings = EmployeeInfo.FACULTY_MONTHLY_SALARY;
		switch(level) {
		case AO:
			earnings *= 1.2;
			break;
		case FU:
			earnings *= 1.4;
			break;
		default:
			break;
		}
		return earnings;
	}


	
	@Override
	/**
	 * Clones the Faculty object
	 */
	protected Object clone() throws CloneNotSupportedException {
		Faculty clone = (Faculty) super.clone();
		clone.setEducation((Education)education.clone());
		return clone;
	}

	@Override
	/**
	 * Outputs the Faculty information
	 */
	public String toString() {
		StringBuilder string = new StringBuilder().append(super.toString() +  "\n");
		switch(level) {
		case AS:
			string.append("Assistant Professor");
			break;
		case AO:
			string.append("Associate Professor");
			break;
		case FU:
			string.append("Full Professor");
			break;
		default:
			string.append("NA");
		}
		string.append("\n");
		string.append("Monthly Earnings: " + monthlyEarning());
		return string.toString();
	}

}
