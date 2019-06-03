package tTwo_thirteen;

import java.util.Scanner;
import java.util.Stack;

public class PostfixEvaluator {
	
	String postfix;
	
	public PostfixEvaluator(String str) {
		// TODO Auto-generated constructor stub
		postfix=str;
	}
	public double evaluation(){
		double result=0;
		Stack<Double>stack=new Stack<>();
		for(int i=0;i<postfix.length();i++){
			if(postfix.charAt(i)<='9'&&postfix.charAt(i)>='0'){
				stack.push((postfix.charAt(i)-'0')/1.0);
			}
			else if(postfix.charAt(i)!=' '){
				double b=stack.pop();
				double a=stack.pop();
				
				switch (postfix.charAt(i)) {
				case '+':
					result=a+b;
					stack.push(result);
					break;
				case '-':
					result=a-b;
					stack.push(result);
					break;
	
				case '*':
					result=a*b;
					stack.push(result);
					break;
				case '/':
					result=a/b;
					stack.push(result);
					break;
				case '%':
					result=a%b;
					stack.push(result);
					break;
				case '^':
					result=Math.pow(a, b);
					stack.push(result);
					break;
				
				default:
					break;
				}
			}
	
		}
		
		
		return result;
	}
	
	public static void main(String[] args) {
		
		Scanner input=new Scanner(System.in);
		System.out.println("Enter your postfix");
		String str=input.nextLine();
		PostfixEvaluator pe=new PostfixEvaluator(str);
		System.out.println("The result of postfix is "+pe.evaluation());
	}
}
