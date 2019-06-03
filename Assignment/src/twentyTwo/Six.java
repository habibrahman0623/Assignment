package twentyTwo;

public class Six {
		
	public static  List<Character> concatenateList(List<Character>list1,List<Character>list2){
		
		list1.tail.nextNode=list2.head;
		list1.tail=list2.tail;
		
		return list1;
	}
	
	public static void main(String[] args) {
		
		List<Character>list1=new List<Character>();
		List<Character>list2=new List<Character>();
		
		list1.insertAtEnd('A');
		list1.insertAtEnd('B');
		list1.insertAtEnd('C');
		list1.insertAtEnd('D');
		list1.insertAtEnd('E');
		list2.insertAtEnd('F');
		list2.insertAtEnd('G');
		list2.insertAtEnd('H');
		list2.insertAtEnd('I');
		list2.insertAtEnd('J');
		
		list1=Six.concatenateList(list1, list2);
		
		list1.print();
	}
}
