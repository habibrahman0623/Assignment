package tTwo_twentyFive;

public class Test {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tree<Integer> tree=new Tree<>();
		tree.insertNode(20);
		tree.insertNode(22);
		tree.insertNode(12);
		tree.insertNode(25);
		tree.insertNode(13);
		tree.insertNode(21);
		tree.insertNode(11);
		tree.insertNode(30);
		tree.insertNode(5);
		tree.insertNode(40);
		tree.insertNode(28);
		tree.insertNode(10);
		tree.insertNode(4);
		
		tree.printTree(tree.root, 0);
	}

}
