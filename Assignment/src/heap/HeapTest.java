package heap;

public class HeapTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Heap heap=new Heap();
		heap.buildHeap(3);
		heap.buildHeap(5);
		heap.buildHeap(8);
		heap.buildHeap(6);
		heap.buildHeap(1);
		heap.buildHeap(4);
		heap.buildHeap(2);
		
		heap.deleteMin();
		heap.deleteMin();
		heap.deleteMin();
		
		
	}

}
