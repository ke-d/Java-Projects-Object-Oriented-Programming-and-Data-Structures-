
public class MeasurableString extends Measurable {
	private String str;
	
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
	public double getMeasure() {
		return str.length();
	}

	@Override
	public String toString() {
		return str;
	}

}
