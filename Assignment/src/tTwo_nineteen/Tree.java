package tTwo_nineteen;

public class Tree <T extends Comparable<T>>{
	
	public TreeNode<T> root;
	
	public Tree() {
		// TODO Auto-generated constructor stub
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
	
	public int getDepth(TreeNode<T> node){
		if(node==null)
			return 0;
		int leftHeight=getDepth(node.leftNode);
		int rightHeight=getDepth(node.rightNode);
		
		if(leftHeight>rightHeight)
			return 	leftHeight+1;
		else 
			return rightHeight+1;
		
	}
}
