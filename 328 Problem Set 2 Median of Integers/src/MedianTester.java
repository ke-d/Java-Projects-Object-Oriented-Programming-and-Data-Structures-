import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MedianTester {

	public static void main(String[] args) throws FileNotFoundException {
		File data1 = new File("Problem_Set 02_dataset_01.txt");
		File data2 = new File("Problem_Set 02_dataset_02.txt");
		Scanner scan = new Scanner(data1);
		FindMedian dataSet1 = new FindMedian();
		FindMedian dataSet2 = new FindMedian();
		while(scan.hasNextLine()) {
			dataSet1.insertNumber(Integer.parseInt(scan.nextLine().trim()));
		}
		System.out.println("Median of Dataset1: " + dataSet1.getMedian());
		scan.close();
		
		scan = new Scanner(data2);
		while(scan.hasNextLine()) {
			dataSet2.insertNumber(Integer.parseInt(scan.nextLine().trim()));
		}
		System.out.println("Median of Dataset2: " + dataSet2.getMedian());
		
		
		scan.close();
	}

}
