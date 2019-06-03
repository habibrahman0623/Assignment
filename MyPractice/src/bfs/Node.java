package bfs;

import java.util.List;

public class Node {
	
	private Integer Key;
	private Node Ancestor;
	private List<Node> descendent;
	private int distence;
	private int color;
	public Node(Integer key) {
		// TODO Auto-generated constructor stub
		Key = key;
	}
	
	public int getKey(){
		
		return Key;
	}
	
	public Node getAncestor() {
		return Ancestor;
	}
	public void setAncestor(Node ancestor) {
		Ancestor = ancestor;
	}
	public List<Node> getDesendent() {
		return descendent;
	}
	public void setDesendent(List<Node> desendent) {
		descendent = desendent;
	}
	public int getDistence() {
		return distence;
	}
	public void setDistence(int distence) {
		this.distence = distence;
	}
	public int getColor() {
		return color;
	}
	public void setColor(int color) {
		this.color = color;
	}
	
	
	
	

}
