
public class InsertionSort<T extends Comparable<T>> {
	public static <T> void sort(Comparable<T>[] array) {
        Comparable<T> temp;
        for (int i = 1; i < array.length; i++) {
            for(int j = i ; j > 0 ; j--){
                if(array[j].compareTo((T) array[j-1]) < 0){
                    temp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = temp;
                }
            }
        }
	}
}
