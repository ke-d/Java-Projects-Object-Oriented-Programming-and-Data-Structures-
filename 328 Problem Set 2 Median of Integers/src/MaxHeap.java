
public class MaxHeap extends Heap {

	@Override
	/**
	 * Moves that element up the heap if its parent element is less than it
	 * @param index is the element that is being heapified
	 */
	protected void heapifyUp(int index) {
		int parent = parent(index);
		if(parent >= 1 && heap[parent] < heap[index]) {
			swap(index, parent);
			heapifyUp(parent);
		}
	}

	@Override
	/**
	 * Moves that element down the heap if any of its child elements are bigger than it
	 * @param index is the element that is being heapified
	 */
	protected void heapifyDown(int index) {
		int largest = 0;
		int leftChild = left(index);
		int rightChild = right(index);

		if(leftChild <= getHeapSize() && heap[leftChild] > heap[index]) {
			largest = leftChild;
		} else {
			largest = index;
		}
		if(rightChild <= getHeapSize() && heap[rightChild] > heap[largest]) {
			largest = rightChild;
		}
		if(largest != index) {
			swap(index, largest);
			heapifyDown(largest);
		}
	}

}
