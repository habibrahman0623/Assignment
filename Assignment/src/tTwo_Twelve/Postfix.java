package tTwo_Twelve;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Postfix {
	
	String inputString;
	List<Node>infix=new ArrayList<Node>();
	List<Node>postfix=new ArrayList<Node>();
	String temp;
	
	public Postfix(String string) {
	
		inputString=string;
		temp=inputString;
		//createInfix();
	}
	
	public void createInfix(){
		List<Double>numbers=replaceSymbol();
		for(int i=0;i<inputString.length();i++){
			if(temp.charAt(i)==' '){
				if(i!=0){
					if(temp.charAt(i-1)!=' '){
						
						Node node1 = new Node();
						Node node2=new Node();
						node1.number=numbers.remove(0);
						node1.flag=true;
						infix.add(node1);
						node2.operator=inputString.charAt(i);
						node2.flag=false;
						infix.add(node2);
					}
					else {
						Node node=new Node();
						node.operator=inputString.charAt(i);
						node.flag=false;
						infix.add(node);
					}
				}
				else {
					Node node=new Node();
					node.operator=inputString.charAt(i);
					node.flag=false;
					infix.add(node);
				}
			}
			
		}
		if(numbers.size()!=0){
			Node node=new Node();
			node.number=numbers.remove(0);
			node.flag=true;
			infix.add(node);
		}
		
	}
	
	public List<Double> replaceSymbol(){
		
		List<Double>list=new ArrayList<Double>();
		char[] symbol={'(',')','+','-','*','/','%','^'};
		for(int i=0;i<8;i++){
			temp=temp.replace(symbol[i], ' ');
		}
		
		String [] str=temp.split(" ");
		for (String string : str) {
			if(string.length()!=0)
				list.add(Double.parseDouble(string));
		}
			
		return list;
	}
	
	public boolean lowerPrecedence(char infixChar ,char stackChar){
		if((infixChar=='%'||infixChar=='^')&&(stackChar=='*'||stackChar=='/'||stackChar=='+'||stackChar=='-'))
			return true;
		else if((infixChar=='*'||infixChar=='/')&&(stackChar=='+'||stackChar=='-'))
			return true;
		else
			return false;
	}
	public void infixToPostfix(){
		
		Stack<Node>stack=new Stack<>();
		Node node1=new Node();
		Node node2=new Node();
		node1.operator='(';
		node1.flag=false;
		stack.push(node1);
		node2.operator=')';
		node2.flag=false;
		infix.add(node2);
		
		for(int i=0;i<infix.size();i++){
			
			if(infix.get(i).flag){
				postfix.add(infix.get(i));
			}
			else {
				if(infix.get(i).operator=='('){
					stack.push(infix.get(i));
				}
				else if(infix.get(i).operator==')'){
					while(true){
						Node tempNode=stack.peek();
						if(tempNode.operator=='('){
							stack.pop();
							break;
						}
						else {
							postfix.add(tempNode);
							stack.pop();
						}
					}
				}
				
				else {
					while(true){
						Node tempNode=stack.peek();
						if(lowerPrecedence(infix.get(i).operator, tempNode.operator)||tempNode.operator=='(')
							break;
						postfix.add(tempNode);
						stack.pop();
					}
					stack.push(infix.get(i));
				}
			}
			
		}
	}
	
	public void printPostfix(){
		for(int i=0;i<postfix.size();i++){
			if(postfix.get(i).flag)
				System.out.print(postfix.get(i).number+" ");
			else 
				System.out.print(postfix.get(i).operator+" ");
		}
	}
}