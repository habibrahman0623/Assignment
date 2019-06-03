package tTwo_Seven;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Seven {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random r=new Random();
		Set<Integer>set=new HashSet<>();
		SortedList sortList=new SortedList();
		while(set.size()!=25){
			set.add(r.nextInt(100));
		}
		for (Integer integer : set) {
			sortList.insertAtFront(integer);
		}
		sortList.sort();
		sortList.print();
		
	}

}
