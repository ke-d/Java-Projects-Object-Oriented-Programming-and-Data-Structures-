
public class MeasurableString extends Measurable {
	/**
	 * Stores the string of the class
	 */
	private String str;
	
	/**
	 * Creates a measurable string
	 * @param str will be stored in str
	 */
	public MeasurableString(String str) {
		this.str = str;
	}
	
	/**
	 * @return the str
	 */
	public String getStr() {
		return str;
	}
	
	/**
	 * @param str the str to set
	 */
	public void setStr(String str) {
		this.str = str;
	}
	
	@Override
	/**
	 * Returns the length of the string
	 */
	public double getMeasure() {
		return str.length();
	}

	@Override
	/**
	 * Returns str as the toString
	 */
	public String toString() {
		return str;
	}

}
