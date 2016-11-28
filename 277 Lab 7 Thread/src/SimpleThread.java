
public class SimpleThread implements Runnable {
	/**
	 * Stores the string to print
	 */
	private String str;

	/**
	 * @param str the string to print
	 */
	public SimpleThread(String str) {
		this.str = str;
	}

	/**
	 * Starts the thread
	 */
	public void start() {
		Thread thread = new Thread(this);
		thread.start();
	}

	/**
	 * Implements the Runnable method
	 */
	@Override
	public void run() {
		for(int i = 0; i < 10; i++) {
			System.out.println(i + " " + str);
			try {
				Thread.sleep((int) (Math.random() * 1000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("DONE! " + str);
		
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
	
}
