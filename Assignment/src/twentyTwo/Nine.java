package twentyTwo;

public class Nine {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Character>list1=new List<Character>();
		
		list1.insertAtEnd('A');
		list1.insertAtEnd('B');
		list1.insertAtEnd('C');
		list1.insertAtEnd('D');
		list1.insertAtEnd('E');
		list1.insertAtEnd('F');
		list1.insertAtEnd('G');
		list1.insertAtEnd('H');
		list1.insertAtEnd('I');
		list1.insertAtEnd('J');
		
		list1=list1.reverse(list1);
		list1.print();

	}

}
