import java.util.*;

public class TaskThread implements Runnable {
	/**
	 * Stores the task number of the task
	 */
	private int taskNumber;
	
	/**
	 * Sets the task number
	 * @param number the task number
	 */
	TaskThread(int number) {
		taskNumber = number;
	}

	/**
	 * Run the task
	 */
	public void run() {
		for (int i = 0; i <= 100; i += 20) {
			// Perform some task ...
			System.out.println("Task number: " + taskNumber + ", percent complete: " + i);
			try {
				Thread.sleep((int) (Math.random() * 1000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} // end for
	}// end main
}// end class