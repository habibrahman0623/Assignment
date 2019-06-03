package tTwo_Eight;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Eight {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random r=new Random();
		Set<Integer>set1=new HashSet<>();
		SortedList sortList1=new SortedList();
		while(set1.size()!=15){
			set1.add(r.nextInt(100));
		}
		for (Integer integer : set1) {
			sortList1.insertAtFront(integer);
		}
		
		Set<Integer>set2=new HashSet<>();
		SortedList sortList2=new SortedList();
		while(set2.size()!=5){
			set2.add(r.nextInt(100));
		}
		for (Integer integer : set2) {
			sortList2.insertAtFront(integer);
		}
		
		sortList1.merge(sortList2);
		sortList1.print();
	}
}
