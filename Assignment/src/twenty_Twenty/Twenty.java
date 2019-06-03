package twenty_Twenty;

import java.util.Scanner;
import java.util.TreeSet;

public class Twenty {
TreeSet<String>treeSet=new TreeSet<>();
	
	public Twenty(String string) {
		// TODO Auto-generated constructor stub
		String[] tokens=string.split(" ");
		for (String token : tokens) {
			token=token.toLowerCase();
			treeSet.add(token);
		}
		for (String token : treeSet) {
			System.out.println(token);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
		Twenty twenty=new Twenty(input.nextLine());
		
		
	}

}
