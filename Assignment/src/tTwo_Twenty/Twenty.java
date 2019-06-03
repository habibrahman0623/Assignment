package tTwo_Twenty;

import java.util.Random;

public class Twenty {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random r=new Random();
		List<Integer>list=new List<>();
		for(int i=0;i<10;i++){
			list.insertAtEnd(r.nextInt(100));
		}
		list.print();
		System.out.println();
		list.reverseUsingRecurrence(list.head);
	}

}
