package twenty_Seventeen;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.TreeSet;



public class Seventeen {
	List<Integer>linkedList=new LinkedList<>();
	public void inserting(TreeSet<Integer> set){
		
		for (Integer integer : set) {
			linkedList.add(integer);
		}
	}
	
	public void calculation(){
		double sum=0,average;
		for(int i=0;i<linkedList.size();i++){
			sum+=linkedList.get(i);
		}
		average=sum/linkedList.size();
		System.out.println("Total sum "+sum+" & average "+average);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random random=new Random();
		TreeSet<Integer>set=new TreeSet<>();
		while(set.size()!=25){
			set.add(random.nextInt(100));
		}
		Seventeen seventeen=new Seventeen();
		seventeen.inserting(set);
		seventeen.calculation();
		
	}

}
