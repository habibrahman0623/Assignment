package twentyTwo;

import java.util.Stack;

public class Eleven {
	String str;
	Stack<Character>stack=new Stack<>();
	public Eleven(String str) {
		// TODO Auto-generated constructor stub
		this.str=str;
		for(int i=0;i<str.length();i++){
			char c=str.charAt(i);
			if(c!=' '&&c!=','&&c!='.'&&c!=';'&&c!=':'&&c!='?'){
				stack.add(c);
			}
		}
	}
	
	public void palindromCheck(){
		Boolean flag=true;
		for(int i=0;i<str.length();i++){
			char c=str.charAt(i);
			if(c!=' '&&c!=','&&c!='.'&&c!=';'&&c!=':'&&c!='?'){
				if(c!=stack.pop()){
					flag=false;
					break;
				}
			}
		}
		if(flag){
			System.out.println("It is a palindrom");
		}
		else System.out.println("It is not a palindrom");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str="A man, a plan, a canal panama";
		Eleven eleven=new Eleven(str.toLowerCase());
		eleven.palindromCheck();
	}

}
