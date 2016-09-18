
public abstract class Heap {
	protected int[] heap;
	private int heapSize;
	
	public Heap() {
		heap = new int[10];
		heapSize = 0;
	}
	
	public void insert(int num) {
		heapSize++;
		if(heapSize >= heap.length) {
			growHeap();
		}
		heap[heapSize] = num;
		heapifyUp(heapSize);
	}
	
	public int removeRoot() {
		if(heapSize <= 0) {
			throw new ArrayIndexOutOfBoundsException();
		} else {
			int root = heap[1];
			heap[1] = heap[heapSize];
			heapSize--;
			heapifyDown(1);
			return root;
		}
	}
	
	private void growHeap() {
		int[] newHeap = new int[heap.length*2];
		for(int i = 1;i < heapSize; i++) {
			newHeap[i] = heap[i];
		}
		heap = newHeap;
		
	}

	protected abstract void heapifyUp(int index);
	
	protected abstract void heapifyDown(int index);
	
	protected void swap(int index1, int index2) {
		int temp = heap[index1];
		heap[index1] = heap[index2];
		heap[index2] = temp;
	}
	
	protected int parent(int index) {
		return index / 2;
	}

	protected int left(int index) {
		return 2 * index;
	}

	protected int right(int index) {
		return (2 * index) + 1;
	}
	
	public int getHeapSize() {
		return heapSize;
	}

	public void printHeap() {
		for(int i = 1;i <= heapSize; i++) {
			System.out.println(heap[i]);
		}
	}
}
