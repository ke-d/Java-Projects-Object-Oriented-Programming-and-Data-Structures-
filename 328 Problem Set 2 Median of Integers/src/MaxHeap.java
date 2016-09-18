
public class MaxHeap extends Heap {

	@Override
	protected void heapifyUp(int index) {
		int parent = parent(index);
		if(parent >= 1 && heap[parent] < heap[index]) {
			swap(index, parent);
			heapifyUp(parent);
		}
	}

	@Override
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
