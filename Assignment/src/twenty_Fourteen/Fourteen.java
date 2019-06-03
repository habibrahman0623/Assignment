package twenty_Fourteen;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Fourteen {
	String string;
	Map<Character, Integer>map=new HashMap<>();
	public Fourteen(String string) {
		// TODO Auto-generated constructor stub
		this.string=string;
	}
	public Map<Character, Integer> countingLetters() {
		char c;
		int num;
		for(int i=0;i<string.length();i++){
			c=string.charAt(i);
			if((map.containsKey(c))&&c!=' '){
				num=map.get(c);
				num+=1;
				map.put(c, num);
			}
			else if(c!=' ') map.put(c, 1);
		}
		return map;
	}
	
	public static void main(String[] args) {
		Map<Character, Integer>map=new HashMap<Character, Integer>();
		Scanner input=new Scanner(System.in);
		System.out.println("Enter your string");
		Fourteen fourteen=new Fourteen(input.nextLine());
		map=fourteen.countingLetters();
		
		Set<Character>set=new TreeSet<Character>(map.keySet());
		for (Character character : set) {
			System.out.println(character+"  "+map.get(character));
		}
		
	}

}
