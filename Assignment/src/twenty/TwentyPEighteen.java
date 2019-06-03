package twenty;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class TwentyPEighteen {

	LinkedList<Character>list=new  LinkedList<>();
	LinkedList<Character>reverseList=new LinkedList<>();
	
	public TwentyPEighteen(LinkedList<Character>list) {
		// TODO Auto-generated constructor stub
		this.list=list;
		Collections.reverse(list);
		reverseList=list;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input =new Scanner(System.in);
		LinkedList<Character>linkedList=new LinkedList<>();
		String str="habiburrahman";
		for(int i=0;i<10;i++){
			linkedList.add(str.charAt(i));
		}
		TwentyPEighteen tpe=new TwentyPEighteen(linkedList);
		
	}

}
