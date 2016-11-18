import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TaskThreadRunner {

	public static void main(String[] args) {
		ExecutorService es = Executors.newFixedThreadPool(2);
		es.execute(new TaskThread(0));
		es.execute(new TaskThread(1));
		es.execute(new TaskThread(2));
		es.execute(new TaskThread(3));
		es.shutdown();
	}

}
