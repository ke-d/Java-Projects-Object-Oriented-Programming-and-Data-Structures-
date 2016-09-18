
public abstract class Heap {
	/**
	 * Stores the heap in an array
	 */
	protected int[] heap;
	
	/**
	 * Stores the current size of the heap
	 */
	private int heapSize;
	
	/**
	 * Creates an empty heap
	 */
	public Heap() {
		heap = new int[10];
		heapSize = 0;
	}
	
	/**
	 * Inserts a element into the heap
	 * @param num is the element inserted
	 */
	public void insert(int num) {
		heapSize++;
		if(heapSize >= heap.length) {
			growHeap();
		}
		heap[heapSize] = num;
		heapifyUp(heapSize);
	}
	
	/**
	 * Remove the root of the heap
	 * @return the root of the heap
	 */
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
	
	/**
	 * Peaks the root of the heap
	 * @return the root of the heap
	 */
	public int peekRoot() {
		return heap[1];
	}
	
	/**
	 * Grows the buffer of the heap
	 */
	private void growHeap() {
		int[] newHeap = new int[heap.length*2];
		for(int i = 1;i < heapSize; i++) {
			newHeap[i] = heap[i];
		}
		heap = newHeap;
		
	}
	
	/**
	 * Moves that element up the heap depending on heap requirements
	 * @param index is the element that is being heapified
	 */
	protected abstract void heapifyUp(int index);
	
	/**
	 * Moves that element down the heap depending on heap requirements
	 * @param index is the element that is being heapified
	 */
	protected abstract void heapifyDown(int index);
	
	/**
	 * Swap the elements of the heap
	 * @param index1 is the first index
	 * @param index2 is the second index
	 */
	protected void swap(int index1, int index2) {
		int temp = heap[index1];
		heap[index1] = heap[index2];
		heap[index2] = temp;
	}
	
	/**
	 * Gets the parent of index
	 * @param index will be used to calculate the parent
	 * @return the parent index
	 */
	protected int parent(int index) {
		return index / 2;
	}
	
	/**
	 * Gets the left child of index
	 * @param index will be used to calculate the left child
	 * @return the left child index
	 */
	protected int left(int index) {
		return 2 * index;
	}
	
	/**
	 * Gets the right child of index
	 * @param index will be used to calculate the right child
	 * @return the right child index
	 */
	protected int right(int index) {
		return (2 * index) + 1;
	}
	
	/**
	 * Returns the heap size
	 * @return the heap size
	 */
	public int getHeapSize() {
		return heapSize;
	}
	
	/**
	 * Displays the heap in a list
	 */
	public String toString() {
		StringBuilder string = new StringBuilder();
		for(int i = 1;i <= heapSize; i++) {
			string.append(heap[i] + "\n");
		}
		return string.toString();
	}
}
