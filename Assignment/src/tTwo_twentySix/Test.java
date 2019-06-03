package tTwo_twentySix;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<Character>list=new List<>();
		list.insertAtEnd('A');
		list.insertAtEnd('B');
		list.insertAtEnd('C');
		list.insertAtEnd('D');
		list.insertAtEnd('F');
		list.insertAtEnd('G');
		list.insertAtEnd('H');
		list.insertAtEnd('I');
		list.insertAtEnd('J');
		
		list.insertAfterANode('D', 'E');
		list.insertAfterANode('J', 'K');
		list.deleteANode('K');
		
		list.print();
		
		

	}

}
