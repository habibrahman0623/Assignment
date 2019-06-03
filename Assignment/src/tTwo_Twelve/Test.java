package tTwo_Twelve;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
		System.out.println("Enter your infix");
		String str=input.nextLine();
		
		Postfix postfix=new Postfix(str);
		postfix.createInfix();
		postfix.infixToPostfix();
		postfix.printPostfix();
	}

}
 