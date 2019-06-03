package tTwo_TwentyOne;


public class TwentyOne {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Character>list=new List<Character>();
		
		list.insertAtEnd('A');
		list.insertAtEnd('B');
		list.insertAtEnd('C');
		list.insertAtEnd('D');
		list.insertAtEnd('E');
		list.insertAtEnd('F');
		list.insertAtEnd('G');
		list.insertAtEnd('H');
		list.insertAtEnd('I');
		list.insertAtEnd('J');
		
		list.print();
		
		list.search('J', list.head);
		list.search('L', list.head);
		

	}

}
