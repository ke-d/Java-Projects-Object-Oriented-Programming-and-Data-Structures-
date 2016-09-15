
public class Education implements Cloneable {
	private String degree;
	private String major;
	private int research;
	
	
	public Education() {
		degree = null;
		major = null;
		research = 0;
	}


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
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
}
