package kruskal;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Graph {
	
	List<Node>nodeList=new ArrayList<Node>();
	
	public void buildGraph(String s1,String s2,Boolean flag1,Boolean flag2){
		
		Node node1=new Node(s1);
		Node node2=new Node(s2);
		if(flag1&&flag2){
			
			node1.list.add(node2);
			node2.list.add(node1);
			nodeList.add(node1);
			nodeList.add(node2);
			
		}
		else if(!flag1&&!flag2){
			for(int i=0;i<nodeList.size();i++){
				if(node1.key==nodeList.get(i).key){
					nodeList.get(i).list.add(node2);
				}
				if(node2.key==nodeList.get(i).key){
					nodeList.get(i).list.add(node1);
				}
			}
		}
		else {
			if(!flag1){
				for(int i=0;i<nodeList.size();i++){
					
					if(node1.key==nodeList.get(i).key){
						nodeList.get(i).list.add(node2);
					}
				}
				node2.list.add(node1);
				nodeList.add(node2);
			}
			else{
				for(int i=0;i<nodeList.size();i++){
					
					if(node2.key==nodeList.get(i).key){
						nodeList.get(i).list.add(node1);
					}
				}
				node1.list.add(node2);
				nodeList.add(node1);
			}
		}
	}
	
}
