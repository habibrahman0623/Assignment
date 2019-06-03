package binaryTree;

import java.util.Scanner;

public class MainBinary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
		Tree tree=new Tree();
		tree.buildTree(11);
		tree.buildTree(8);
		tree.buildTree(10);
		tree.buildTree(9);
		tree.buildTree(13);
		tree.buildTree(12);
		tree.buildTree(19);
		tree.buildTree(3);
		tree.buildTree(16);
		tree.buildTree(2);
		tree.buildTree(7);
		tree.buildTree(29);
		tree.buildTree(17);
		tree.buildTree(18);
		
		tree.maxValue(3);
		tree.minValue(13);		
	
		tree.delation(11);
		
		System.out.println("Enter the number which you want to search");
		
		tree.searching(input.nextInt());
		tree.inordertraverse();
		
		


	}

}
