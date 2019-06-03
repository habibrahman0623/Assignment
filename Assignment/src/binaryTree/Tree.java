package binaryTree;

import java.util.ArrayList;
import java.util.List;

public class Tree {
	
	public Node root;
	public Node current;
	public Node parent;
	
	
	public void buildTree(int key)
	{
		
		if(root==null)
		{
			root = new Node(key);
			return;
		}
		current = root;
		while(true)
		{
			
			parent=current;
			if(key<current.key)
			{
				current=current.leftNode;
				if(parent.leftNode==null)
				{
					parent.leftNode=new Node(key);
					return;
				}
			}
			else
			{
				current=current.rightNode;
				if(parent.rightNode==null)
				{
					parent.rightNode=new Node(key);
					return;
							
				}
			}
			
		}
		
		
	}
	
	public Node searching(int key)
	{
		current=root;
		boolean flag=false;
		while(true)
		{
			if(current.key==key)
			{
				
				flag=true;
				break;
			}
			
			if(key<current.key)
			{	
				parent=current;
				current=current.leftNode;
			}	
			
			else
			{
				parent=current;
				current=current.rightNode;
			}
			
			if(current==null)
				break;
			
		}
		if(flag)
			System.out.println("found");
		else System.out.println("not found");
		
		return current;

	}
	
	public Node maxValue(int key)
	{
		current=searching(key);
		while(true)
		{	
			if(current.rightNode==null)
			{	
				System.out.println("The max value of the tree "+current.key);
				return current;
			}	
			else current=current.rightNode;
		}	
	}
	
	public Node minValue(int key)
	{
		current=searching(key);
		while(true)
		{
			if(current.leftNode==null)
			{	
				System.out.println("The min value of the tree "+current.key);
				return current;
			}	
			else current=current.leftNode;

		}
	}
	
	public void delation(int key)
	{
		
		current=searching(key);
		if(current==parent.leftNode)
		{
			if(current.leftNode!=null && current.rightNode!=null)
			{
				if(current.leftNode.rightNode==null)
				{
					parent.leftNode=current.leftNode;
					parent.leftNode.rightNode=current.rightNode;
				}
				else{
					Node max=maxValue(current.leftNode.key);
					current=searching(max.key);
					parent.rightNode=current.leftNode;
					current=searching(key);
					max.leftNode=current.leftNode;
					max.rightNode=current.rightNode;
					parent.leftNode=max;
				}
				
			}
			else
			{
				if(current.leftNode!=null)
					parent.leftNode=current.leftNode;
				else if(current.rightNode!=null)
					parent.leftNode=current.rightNode;
				else
					parent.leftNode=null;
			}
			
		}
		
		
		if(current==parent.rightNode)
		{
			if(current.leftNode!=null && current.rightNode!=null)
			{
				if(current.leftNode.rightNode==null)
				{
					parent.rightNode=current.leftNode;
					parent.rightNode.rightNode=current.rightNode;
				}
				else{
					Node max=maxValue(current.leftNode.key);
					current=searching(max.key);
					parent.rightNode=current.leftNode;
					current=searching(key);
					max.leftNode=current.leftNode;
					max.rightNode=current.rightNode;
					parent.rightNode=max;
				}
				
			}
			else
			{
				if(current.leftNode!=null)
					parent.rightNode=current.leftNode;
				else if(current.rightNode!=null)
					parent.rightNode=current.rightNode;
				else
					parent.rightNode=null;
			}
		}
		
		
		if(current==root)
		{
			if(current.leftNode!=null && current.rightNode!=null)
			{
				if(current.leftNode.rightNode==null)
				{
					
					root.leftNode.rightNode=current.rightNode;
					root=root.leftNode;
				}
				else
				{
					Node max=maxValue(current.leftNode.key);
					current=searching(max.key);
					parent.rightNode=current.leftNode;
					
					current=searching(key);
					max.leftNode=current.leftNode;
					max.rightNode=current.rightNode;
					root=max;
				}
			}
			
			else
			{
				if(root.leftNode==null)
					root=root.rightNode;
				else if(root.rightNode==null)
					root=root.leftNode;
				else
					root=null;
			}
		}
	}
	
	public void inordertraverse()
	{
		
		traversing(root);
		
		
	}
	
	public void traversing(Node node){
		
		if(node==null){
			return;
		}
		traversing(node.leftNode);
		System.out.println(node.key);
		traversing(node.rightNode);
	}
	
}
