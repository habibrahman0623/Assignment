package tTwo_twentySix;

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
	public Node<T> search(T value,Node<T>node){
		
		Node<T> current=node;
		while(current!=null){
			if(current.data==value)
				break;
			else 
				current=current.nextNode;
		}
		return current;
	}
	public void insertAfterANode(T searchValue,T data){
		Node<T> current=search(searchValue, head);
		if(current==tail){
			current.nextNode=new Node<T>(data);
			tail=current.nextNode;
		}
		else {
			Node<T> node=new Node<T>(data);
			node.nextNode=current.nextNode;
			current.nextNode=node;
		}
		
	}
	public void deleteANode(T value){
		Node<T> current=head;
		if(current.data==value);
		else {
			while(current.nextNode!=null){
				if(current.nextNode.data==value){
					break;
				}
				else 
					current=current.nextNode;
			}
		}
		if(current==head){
			if(head!=tail)
				head=current.nextNode;
			else 
				head=tail=null;
		}
		else {
			if(current.nextNode==tail){
				tail=current;
				tail.nextNode=null;
			}	
			else {
				current.nextNode=current.nextNode.nextNode;
			}
		}
	}


}
