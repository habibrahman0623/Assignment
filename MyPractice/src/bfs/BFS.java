package bfs;

import java.util.ArrayList;
import java.util.List;


public class BFS {
	
	//private Node Source;
	private List<List<Integer>> Graph;
	private List<Node> queue;
	private List<Node> nodelist;
	
	public BFS(int source, List<List<Integer>> graph) {
		// TODO Auto-generated constructor stub
		//Source = new Node(source);
		Graph = new ArrayList<>();
		queue = new ArrayList<>();
		nodelist = new ArrayList<>();
		this.Graph = graph;
		for(int i = 0; i < Graph.size(); i++){
			
			nodelist.add(new Node(i));
		}
		nodelist.get(source).setColor(1);
		nodelist.get(source).setDistence(0);
		queue.add(nodelist.get(source));
	}
	
	public void runBFS(){
		
		
		int numberOfNode = Graph.size();
		
		for(int i = 0; i < numberOfNode; i++){
			
			queue.get(i).setColor(1);
			int nodeKey = queue.get(i).getKey();
			for(int j = 0; j < numberOfNode; j++){
				
				if(Graph.get(nodeKey).get(j) == 1){
					if(nodelist.get(j).getColor() == 0){
						nodelist.get(j).setAncestor(queue.get(i));
						nodelist.get(j).setColor(1);
						nodelist.get(j).setDistence(queue.get(i).getDistence() + 1);
						queue.add(nodelist.get(j));
					}
				}
			}
			queue.get(i).setColor(2);
		}
		
			
		
	}
	
	public void printNode(){
		
		for (Node node : nodelist) {
			
			System.out.println(node.getKey() + " " + node.getDistence());
		}
	}
	
	

}
