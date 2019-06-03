package twentyTwo;

import java.util.Stack;

public class Ten {

	Stack<String>stack=new Stack<>();
	public Ten(String str) {
		// TODO Auto-generated constructor stub
		String[] words=str.split(" ");
		for (String string : words) {
			stack.add(string);
		}
		
	}
	public void reversePrint(){
		while(!stack.empty()){
			System.out.println(stack.pop());
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str="my name is habib";
		
		Ten ten=new Ten(str);
		ten.reversePrint();
	}

}
