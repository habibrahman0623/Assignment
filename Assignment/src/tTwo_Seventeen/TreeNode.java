package tTwo_Seventeen;


public class TreeNode <T extends Comparable<T>>{

	public T key;
	public TreeNode leftNode,rightNode;
	
	public TreeNode(T key)
	{
		this.key=key;
		leftNode=null;
		rightNode=null;
	}
	public void insert(T value){
		if(value.compareTo(key)<=0){
			if(leftNode==null){
				leftNode=new TreeNode<T>(value);
			}
			else {
				leftNode.insert(value);
			}
		}
		else {
			if(rightNode==null){
				rightNode=new TreeNode<T>(value);
			}
			else {
				rightNode.insert(value);
			}
		}
	}
}
