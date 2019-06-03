package anuragEndoscope;

public class MyQueue {
	

	private Node entryPoint;
	private Node removalPoint;
	
	public class Node{
		int value,loc_x,loc_y;
		Node previous, next;
		public Node(int value, int i, int j) {
			// TODO Auto-generated constructor stub
			this.value = value;
			loc_x = i;
			loc_y = j;
		}
	}
	
	
	public void enqueue(int value, int i, int j){
		
		Node newNode = new Node(value,i,j);
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
