
public class Faculty implements Comparable<Faculty> {
	/**
	 * The name of the Faculty member
	 */
	private String name;
	
	/**
	 * The id number of the Faculty member
	 */
	private int idNum;

	/**
	 * Creates the Faculty class
	 * @param name is the name of the person
	 * @param idNum is the id of the person
	 */
	public Faculty(String name, int idNum) {
		this.name = name;
		this.idNum = idNum;
	}


	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}


	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}


	/**
	 * @return the idNum
	 */
	public int getIdNum() {
		return idNum;
	}


	/**
	 * @param idNum the idNum to set
	 */
	public void setIdNum(int idNum) {
		this.idNum = idNum;
	}


	@Override
	/**
	 * Compares the id to another employee
	 */
	public int compareTo(Faculty o) {
		Double sal1 = new Double(idNum);
		Double sal2 = new Double(o.getIdNum());
		return sal1.compareTo(sal2);
	}
	
	
	@Override
	/**
	 * Outputs the contents of this class
	 */
	public String toString() {
		return "Name = " + name + ", idNum = " + idNum;
	}

	
}
