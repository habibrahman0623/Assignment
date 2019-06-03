package tTwo_TwentyOne;


public class Node <T> {
	
	T data;
	Node<T>nextNode; 
	
	public Node(T object) {
		// TODO Auto-generated constructor stub
		data=object;
	}
	public Node(T data,Node<T>node) {
		// TODO Auto-generated constructor stub
		this.data=data;
		nextNode=node;
	}
}
