package twenty;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class TwentyPThirteen {

	List<String>nameList=new ArrayList<String>();
	Set<String>set;
	public TwentyPThirteen(List<String>list) {
		// TODO Auto-generated constructor stub
		nameList=list;
		set=new TreeSet<>(nameList);
	}
	
	public Boolean searchName(String name){
		Boolean flag;
		flag=nameList.contains(name);
		return flag;
	}
	
	public static void main(String[] args) {
		List<String>nameList=new ArrayList<String>();
		String name;
		Scanner input=new Scanner(System.in);
		for(int i=0;i<10;i++){
			name=input.nextLine();
			nameList.add(name);
		}
		TwentyPThirteen t=new TwentyPThirteen(nameList);
		System.out.println("Enter the name,which you want to serch");
		Boolean flag=t.searchName(input.nextLine());
		if(flag)
			System.out.println("This name exist");
		else System.out.println("This name is not exist");
	}
}
