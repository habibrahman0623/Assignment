package tTwo_twentyThree;

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
	
	public void search(T key){
		current=root;
		Boolean flag=false;
		while(current!=null){
			
			if(current.key==key){
				flag=true;
				break;
			}
			if(key.compareTo(current.key)<0){
				current=current.leftNode;
			}
			else {
				current=current.rightNode;
			}
		}
		if(flag)
			System.out.println("Found");
		else 
			System.out.println("Not found");
	}
}
