package myBFS;

public class MyQueue {
	

	private Node entryPoint;
	private Node removalPoint;
	
	public class Node{
		int value;
		Node previous, next;
		public Node(int value) {
			// TODO Auto-generated constructor stub
			this.value = value;
		}
	}
	
	
	public void enqueue(int value){
		
		Node newNode = new Node(value);
		if(entryPoint == null){
			entryPoint = newNode;
			removalPoint = newNode;
		}
		else {
			
			newNode.previous = entryPoint;
			newNode.previous.next = newNode;
			entryPoint = newNode;
			
		}
		
	}
	
	public Integer dequeue(){
		
		Integer value = null;
		
		if(!isEmpty()){
			value = removalPoint.value;
			removalPoint = removalPoint.next;
			if(removalPoint != null){
				removalPoint.previous = null;
			}
			else {
				entryPoint = null;
				
			}
		}
		
		
		
		return value;
	}
	
	public boolean isEmpty(){
		if(removalPoint == null){
			return true;
		}
		else {
			return false;
		}
	}
}
