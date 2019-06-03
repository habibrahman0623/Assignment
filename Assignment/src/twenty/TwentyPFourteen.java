package twenty;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class TwentyPFourteen {

	String string;
	Map<Character, Integer>map=new HashMap<>();
	public TwentyPFourteen(String string) {
		// TODO Auto-generated constructor stub
		this.string=string;
	}
	public Map<Character, Integer> countingLetters() {
		char c;
		int num;
		for(int i=0;i<string.length();i++){
			c=string.charAt(i);
			if(!map.containsKey(c)&&c!=' '){
				num=1;
				for(int j=i+1;j<string.length();j++){
					if(c==string.charAt(j))
						num+=1;
				}
				map.put(c, num);
			}
		}
		return map;
	}
	
	public static void main(String[] args) {
		Map<Character, Integer>map=new HashMap<Character, Integer>();
		Scanner input=new Scanner(System.in);
		System.out.println("Enter your string");
		TwentyPFourteen tf=new TwentyPFourteen(input.nextLine());
		map=tf.countingLetters();
		
	}
}
