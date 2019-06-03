package twentyTwo;

public class SortedList {
	Node<Integer>head;
	Node<Integer>tail;
	
	public void insertAtFront(Integer data){
		if(isEmpty()){
			head=tail=new Node<Integer>(data);
		}
		else {
			head=new Node<Integer>(data, head);
		}
		
	}
	public void insertAtEnd(Integer data){
		if(isEmpty()){
			head=tail=new Node<Integer>(data);
		}
		else {
			tail=tail.nextNode=new Node<Integer>(data);
			
		}
	}
	
	public Integer removeFromFront(){
		if(isEmpty()){
			System.out.println("List is empty");
			return null;
		}
		Integer removeItem=head.data;
		head=head.nextNode;
		
		return removeItem;
		
	}
	
	public Integer removeFromEnd(){
		if(isEmpty()){
			System.out.println("List is empty");
			return null;
		}
		Integer removeItem=tail.data;
		Node<Integer>current=head;
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
		Node<Integer>current=head;
		while(current!=null){
			System.out.println(current.data);
			current=current.nextNode;
		}
	}
	public void sort(){
		Node<Integer>current1=head;
		Node<Integer>current2;
		while(current1!=null){
			
			current2=current1.nextNode;
			while(current2!=null){
				if(current1.data>current2.data){
					int temp=current1.data;
					current1.data=current2.data;
					current2.data=temp;
				}
				current2=current2.nextNode;
			}
			current1=current1.nextNode;
		}
	}
	
	public void merge(SortedList list){
		
		this.tail.nextNode=list.head;
		this.tail=list.tail;
		sort();
	}

}
