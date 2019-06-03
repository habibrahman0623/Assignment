package twenty_Sixteen;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;


public class Sixteen {
	public String str;
	List<String>list=new ArrayList<String>();
	Map<String, Integer>map=new HashMap<String, Integer>();
	
	public Sixteen(String str) {
		this.str=str;
		stringStream();
	}
	public void stringStream(){

		String substr=null;
		int k=0;
		for(int i=0;i<str.length();i++){
			if(str.charAt(i)==' '){
				substr=str.substring(k, i);
				k=i+1;
				list.add(substr);
			}
			if(i==str.length()-1&&str.charAt(i)!=' '){
				list.add(str.substring(k, i+1));
			}

		}
	}
	
	public Map<String, Integer> countingDuplicateWord(){
		
		for (String word : list) {
			word=word.toLowerCase();
			if(map.containsKey(word)){
				int count=map.get(word);
				map.put(word, count+1);
			}
			else {
				map.put(word, 1);
			}
		}
		return map;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
		Map<String, Integer>map=new HashMap<String, Integer>();
		Sixteen sixteen=new Sixteen(input.nextLine());
		map=sixteen.countingDuplicateWord();
		Set<String>set=map.keySet();
		TreeSet<String>treeSet=new TreeSet<String>(set);
		for (String string : treeSet) {
			System.out.printf("%-10s%10s\n",string,map.get(string));
		}
		
		
	}


}
