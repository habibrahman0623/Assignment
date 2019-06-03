package twentyTwo;

import java.util.Random;

public class Sixteen {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random r=new Random();
		Tree<Integer>tree=new Tree<>();
		for(int i=0;i<20;i++){
			tree.insertNode(r.nextInt(100));
		}
		tree.inorderTraverse();
		tree.postorderTraverse();
	}

}
