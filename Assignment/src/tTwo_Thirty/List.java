package tTwo_Thirty;

public class List <T>{
	Node<T>head;
	Node<T>tail;
	
	public void insertAtFront(T data){
		if(isEmpty()){
			head=tail=new Node<T>(data);
		}
		else {
			head=new Node<T>(data, head);
		}
		
	}
	public void insertAtEnd(T data){
		if(isEmpty()){
			head=tail=new Node<T>(data);
		}
		else {
			tail=tail.nextNode=new Node<T>(data);
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
	
	public T removeFromEnd(){
		if(isEmpty()){
			System.out.println("List is empty");
			return null;
		}
		T removeItem=tail.data;
		Node<T>current=head;
		while(current.nextNode!=tail){
			current=current.nextNode;
		}
		tail=current;
		return removeItem;
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
