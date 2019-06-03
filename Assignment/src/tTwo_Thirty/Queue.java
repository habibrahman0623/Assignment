package tTwo_Thirty;

public class Queue<T> extends List<T>{
	
	
	public void enqueue(T data){
		
		insertAtEnd(data);
	}
	public T dequeue(){
		
		return removeFromFront();
	}
	public Boolean isEmpty(){
		
		return super.isEmpty();
	}
	public void print(){
		
		super.print();
	}
	
	public static void main(String[] args) {
		
		Queue<Integer>queue=new Queue<>();
		queue.enqueue(12);
		queue.enqueue(1);
		queue.enqueue(22);
		queue.enqueue(15);
		queue.enqueue(14);
		queue.enqueue(19);
		queue.enqueue(2);
		
		queue.print();
		queue.dequeue();
		queue.dequeue();
		System.out.println();
		queue.print();

	}

}
