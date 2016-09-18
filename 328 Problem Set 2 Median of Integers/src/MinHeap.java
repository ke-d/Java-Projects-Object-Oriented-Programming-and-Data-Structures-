
public class MinHeap extends Heap {
	@Override
	protected void heapifyUp(int index) {
		int parent = parent(index);
		if(parent >= 1 && heap[parent] > heap[index]) {
			swap(index, parent);
			heapifyUp(parent);
		}
	}

	@Override
	protected void heapifyDown(int index) {
		int smallest = 0;
		int leftChild = left(index);
		int rightChild = right(index);
		if(leftChild <= getHeapSize() && heap[leftChild] < heap[index]) {
			smallest = leftChild;
		} else {
			smallest = index;
		}
		if(rightChild <= getHeapSize() && heap[rightChild] < heap[smallest]) {
			smallest = rightChild;
		}
		if(smallest != index) {
			swap(index, smallest);
			heapifyDown(smallest);
		}
		
	}

}
