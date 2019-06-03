package tTwo_twentyFour;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Tree <T extends Comparable<T>>{
	
	public TreeNode<T> root;
	public TreeNode<T> current;
	List<TreeNode<T>>list=new ArrayList<TreeNode<T>>();
	
	
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
	
	public void inorderTraverse(){
		inorder(root);
	}
	public void inorder(TreeNode<T> node){
		if(node==null){
			return;
		}
		inorder(node.leftNode);
		System.out.print(node.key+" ");
		inorder(node.rightNode);
	}

	public void levelOrderTraverse(){
		list.add(root);
		while(list.size()>0){
			current=list.remove(0);
			System.out.println(current.key);
			if(current.leftNode!=null){
				list.add(current.leftNode);
				
			}
			if(current.rightNode!=null){
				list.add(current.rightNode);
			}
		}
	}
}	
