package tTwo_twentySeven;

public class List <T>{
	
	Node<T>head;

	public void insertAtFront(T data){
		if(isEmpty()){
			head=new Node<T>(data);
		}
		else {
			head=new Node<T>(data, head);
		}
		
	}
	public void insertAtEnd(T data){
		if(isEmpty()){
			head=new Node<T>(data);
		}
		else {
			Node current=head;
			while(current.nextNode!=null){
				current=current.nextNode;
			}
			current.nextNode=new Node<T>(data);
		}
	}
	
	public T removeFromFront(){
		if(isEmpty()){
			System.out.println("List is empty");
			return null;
		}
		T removeItem=head.data;
		head=head.nextNode;
		
		return removeItem;
		
	}
	
	public Node<T> removeFromEnd(){
		if(isEmpty()){
			System.out.println("List is empty");
			return null;
		}
		
		Node<T>current=head;
		while(true){
			current=current.nextNode;
			if(current.nextNode.nextNode==null)
				break;
		}
		Node<T>removeItem=current.nextNode;
		current.nextNode=null;
		return  removeItem;
	}
	public Boolean isEmpty(){
		if(head==null)
			return true;
		return false;
	}
	
	public void print(){
		Node<T>current=head;
		while(current!=null){
			System.out.println(current.data);
			current=current.nextNode;
		}
	}
}	
