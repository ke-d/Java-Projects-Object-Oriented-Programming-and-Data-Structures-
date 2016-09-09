
public class Faculty extends Employee {
	
	private FacultyLevel level;
	private Education education;
	
	
	public Faculty(String lName,String fName, String IDNum, char gender, int month, int day, int year, FacultyLevel level, String degree, String major, int research) {
		super(lName, fName, IDNum, gender, day, month, year);
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
	public double monthlyEarning() {
		// TODO Auto-generated method stub
		return 0;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder string = new StringBuilder().append(super.toString());
		return string.toString();
	}

}
