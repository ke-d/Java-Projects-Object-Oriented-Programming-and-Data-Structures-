
public class TwoThreadsDemo {

	public static void main(String[] args) {
		new SimpleThread("CECS 277").start();
		new SimpleThread("OOP in Java").start();
	}
	
}
