package tTwo_Seventeen;

import java.util.Scanner;


public class Seventeen {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
		System.out.println("Enter your string");
		String str=input.nextLine();
		String[] words=str.split(" ");
		Tree<String>tree=new Tree<>();
		
		for (String string : words) {
			tree.insertNode(string);
		}
		tree.inorderTraverse();
		System.out.println();
		tree.preorderTraverse();
		System.out.println();
		tree.postorderTraverse();
	}

}
