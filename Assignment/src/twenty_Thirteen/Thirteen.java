package twenty_Thirteen;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Thirteen {
	
	public static void main(String[] args) {
		Set<String>nameList=new TreeSet<String>();
		String name;
		Scanner input=new Scanner(System.in);
		System.out.println("Enter your names");
		for(int i=0;i<10;i++){
			name=input.nextLine();
			nameList.add(name);
		}
		
		System.out.println("Enter the name,which you want to serch");
		Boolean flag=nameList.contains(input.nextLine());
		if(flag)
			System.out.println("This name exist");
		else System.out.println("This name is not exist");
	}

}
