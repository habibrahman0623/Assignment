package twentyTwo;

import java.util.Random;

public class Twenty {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random r=new Random();
		List<Integer>list=new List<>();
		for(int i=0;i<5;i++){
			list.insertAtEnd(r.nextInt(100));
		}
		list.print();
		list.reverseUsingRecurrence(list.head);
	}

}
