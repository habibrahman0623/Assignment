package twenty_Eighteen;

import java.util.Collections;
import java.util.LinkedList;

public class Eighteen {
	LinkedList<Character>list=new  LinkedList<>();
	LinkedList<Character>reverseList=new LinkedList<>();
	
	public Eighteen(LinkedList<Character>list) {
		// TODO Auto-generated constructor stub
		this.list=list;
		Collections.reverse(list);
		reverseList=list;
		
		for (Character character : reverseList) {
			System.out.println(character);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList<Character>linkedList=new LinkedList<>();
		String str="habiburrahman";
		for(int i=0;i<10;i++){
			linkedList.add(str.charAt(i));
		}
		Eighteen eighteen=new Eighteen(linkedList);
		
	}

}
