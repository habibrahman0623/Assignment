package tTwo_twentyFive;

import java.util.LinkedList;
import java.util.Queue;

public class Tree <T extends Comparable<T>>{
	
	public TreeNode<T> root;
	public TreeNode<T> current;
	
	public Tree() {
		
		root=null;
	}
	
	public void insertNode(T value){
		if(root==null){
			root=new TreeNode<T>(value);
		}
		else {
			root.insert(value);
		}
	}
	
	public void printTree(TreeNode<T> node,int space){
		if(node==null)
			return;
		printTree(node.rightNode, space+5);
		for(int i=0;i<space;i++)
			System.out.print(" ");
		System.out.print(node.key);
		System.out.println();
		printTree(node.leftNode, space+5);
		
	}
	
	
}	
	
