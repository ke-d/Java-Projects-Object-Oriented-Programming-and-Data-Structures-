
public class FindMedian {
	/**
	 * Stores the smaller half of the list
	 */
	private Heap maxHeap;
	
	/**
	 * Stores the larger half of the list
	 */
	private Heap minHeap;
	
	/**
	 * Creates an empty list of elements
	 */
	public FindMedian() {
		maxHeap = new MaxHeap();
		minHeap = new MinHeap();
	}
	
	/**
	 * Inserts a number into the list
	 * @param num is the number being inserted
	 */
	public void insertNumber(int num) {
		if(maxHeap.getHeapSize() + minHeap.getHeapSize() == 0) {
			maxHeap.insert(num);
		} else {
			if(num < maxHeap.peekRoot()) {
				maxHeap.insert(num);
			} else {
				minHeap.insert(num);
			}
		}
		checkSizeRequirements();
	}
	
	/**
	 * If one of the heaps are bigger by 2, then move the root of that heap and insert it into the other 
	 */
	private void checkSizeRequirements() {
		if(maxHeap.getHeapSize()-1 > minHeap.getHeapSize()) {
			minHeap.insert(maxHeap.removeRoot());
		} else if(minHeap.getHeapSize()-1 > maxHeap.getHeapSize()) {
			maxHeap.insert(minHeap.removeRoot());
		}
	}
	
	/**
	 * Return the median depending whether the list is even or odd
	 * @return the median
	 */
	public double getMedian() {
		double median = 0;
		if(isEven()) {
			median = (double) (maxHeap.peekRoot() + minHeap.peekRoot()) / 2; 
		} else {
			if(maxHeap.getHeapSize() > minHeap.getHeapSize()) {
				median = maxHeap.peekRoot();
			} else if(minHeap.getHeapSize() > maxHeap.getHeapSize()) {
				median = minHeap.peekRoot();
			}
		}
		return median;
	}
	
	/**
	 * Tests whether is
	 * @return true if even, false if odd
	 */
	private boolean isEven() {
		return (maxHeap.getHeapSize() + minHeap.getHeapSize()) % 2 == 0;
	}
}
