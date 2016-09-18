
public class FindMedian {
	private Heap maxHeap;
	private Heap minHeap;
	
	public FindMedian() {
		maxHeap = new MaxHeap();
		minHeap = new MinHeap();
	}
	
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
		
		if(maxHeap.getHeapSize()-1 > minHeap.getHeapSize()) {
			minHeap.insert(maxHeap.removeRoot());
		} else if(minHeap.getHeapSize()-1 > maxHeap.getHeapSize()) {
			maxHeap.insert(minHeap.removeRoot());
		}
	}
	
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

	private boolean isEven() {
		return (maxHeap.getHeapSize() + minHeap.getHeapSize()) % 2 == 0;
	}
}
