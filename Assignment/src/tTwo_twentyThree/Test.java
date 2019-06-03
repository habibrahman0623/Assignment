package tTwo_twentyThree;

import java.util.Random;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random r=new Random();
		Tree<Integer>tree=new Tree<>();
		for(int i=0;i<10;i++){
			int n=r.nextInt(100);
			tree.insertNode(n);
			System.out.println(n);
		}
		//tree.inorderTraverse();
		
		tree.search(0);
	}

}
