package heap;

public class Node {

	public int key;
	public Node leftNode;
	public Node rightNode;
	public Node parent;
	public Node(int key) {
		// TODO Auto-generated constructor stub
		this.key=key;
		leftNode=null;
		rightNode=null;
	}
}
