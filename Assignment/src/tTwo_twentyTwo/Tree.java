package tTwo_twentyTwo;

public class Tree <T extends Comparable<T>>{
	
	public TreeNode<T> root;
	public TreeNode<T> current;
	public TreeNode<T> parent;
	
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
	
	public void preorderTraverse(){
		preorder(root);
	}
	public void preorder(TreeNode<T> node){
		if(node==null)
			return;
		System.out.print(node.key+" ");
		preorder(node.leftNode);
		preorder(node.rightNode);
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
	public void postorderTraverse(){
		postorder(root);
	}
	public void postorder(TreeNode<T> node){
		if(node==null)
			return;
		postorder(node.leftNode);
		postorder(node.rightNode);
		System.out.print(node.key+" ");
	}
	
	public TreeNode<T> search(Comparable key){
		current=root;
		while(current!=null){
			
			if(current.key==key){
				break;
			}
			if(key.compareTo(current.key)<0){
				parent=current;
				current=current.leftNode;
			}
			else {
				parent=current;
				current=current.rightNode;
			}
		}
		
		return current;
	}
	public TreeNode<T> maxValue(Comparable key)
	{
		current=search(key);
		while(true)
		{	
			if(current.rightNode==null)
			{	
				break;
			}	
			else current=current.rightNode;
		}
		return current;
	}
	

	
	public void delation(T key){
		current=search(key);
		if(current==null)
			return;
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
					TreeNode<T> max=maxValue(current.leftNode.key);
					current=search(max.key);
					parent.rightNode=current.leftNode;
					current=search(key);
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
					TreeNode<T> max=maxValue(current.leftNode.key);
					current=search(max.key);
					parent.rightNode=current.leftNode;
					current=search(key);
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
					TreeNode<T> max=maxValue(current.leftNode.key);
					current=search(max.key);
					parent.rightNode=current.leftNode;
					
					current=search(key);
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
}
