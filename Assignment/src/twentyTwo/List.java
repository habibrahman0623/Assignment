package twentyTwo;

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
	public List<T> reverse(List<T>list){
		
		List<T>reverseList=new List<T>();
		Node<T>current=list.head;
		while(current!=null){
			reverseList.insertAtFront(current.data);
			current=current.nextNode;
		}
		return reverseList;
	}
	public void reverseUsingRecurrence(Node<T>node){
		if(node==null)
			return;
		reverseUsingRecurrence(node.nextNode);
		System.out.println(node.data);
	}
	public void search(T value,Node<T>node){
		if(node.data==value){
			System.out.println("found");
			return;
		}
		
		if(node.nextNode!=null)
			search(value, node.nextNode);
		else System.out.println("not found");
	}
}
