
public class BinarySearchTester {

	public static void main(String[] args) {
		Faculty[] fac = {new Faculty("Bob", 2021),new Faculty("Carl", 1900),new Faculty("Tom", 3421),new Faculty("Karl", 2919),new Faculty("Dezel", 1000)};
		InsertionSort.sort(fac);
		BinarySearcher<Faculty> bs = new BinarySearcher<>(fac);
		for(int i = 0; i < fac.length; i++) {
			System.out.println(fac[i].toString());
		}
		System.out.println(bs.search(new Faculty("", 100)));
	}

}
