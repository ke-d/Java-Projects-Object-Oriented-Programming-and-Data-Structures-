/**
 * 
 * @author Kenny Do
 *	CECS 277
 */
public class Education implements Cloneable {
	/**
	 * Stores the degree
	 */
	private String degree;
	
	/**
	 * Stores the major
	 */
	private String major;
	
	/**
	 * Stores the amount of research done
	 */
	private int research;
	
	/**
	 * Makes a empty Education
	 */
	public Education() {
		degree = null;
		major = null;
		research = 0;
	}

	/**
	 * Makes a education object
	 * @param degree stored in degree
	 * @param major stored in major
	 * @param research stored in research
	 */
	public Education(String degree, String major, int research) {
		super();
		this.degree = degree;
		this.major = major;
		this.research = research;
	}

	/**
	 * @return the degree
	 */
	public String getDegree() {
		return degree;
	}


	/**
	 * @param degree the degree to set
	 */
	public void setDegree(String degree) {
		this.degree = degree;
	}


	/**
	 * @return the major
	 */
	public String getMajor() {
		return major;
	}


	/**
	 * @param major the major to set
	 */
	public void setMajor(String major) {
		this.major = major;
	}


	/**
	 * @return the research
	 */
	public int getResearch() {
		return research;
	}


	/**
	 * @param research the research to set
	 */
	public void setResearch(int research) {
		this.research = research;
	}


	@Override
	/**
	 * Clones the education object
	 */
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
}
