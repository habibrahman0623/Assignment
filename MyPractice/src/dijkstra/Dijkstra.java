package dijkstra;

public class Dijkstra {
	
	int[][] graph;
	PriorityQueue priorityQueue;
	Node Source;
	Node[] nodeList;
	
	public class Node
	{
		int nodeNumber;
		int distance = Integer.MAX_VALUE;
		Node previous;
	}
	
	public class PriorityQueue{
		
		Node[] myQueue;
		int entryPoint;
		int numberOfElement;
		public PriorityQueue(int size) {
			// TODO Auto-generated constructor stub
			myQueue = new Node[size];
		}
		
		public void enqueue(Node node){
			if(numberOfElement < myQueue.length){
				myQueue[numberOfElement++] = node;
				sort();
			}				
		}
		
		public Node dequeue(){
			Node node;
			if(numberOfElement > 0){
				node = myQueue[0];
				for(int i = 0; i < numberOfElement; i++){
					myQueue[i] = myQueue[i+1];
				}
				numberOfElement--;
			}
			else {
				node = null;
			}
			return node;
		}
		
		
		public void sort(){
			
			for(int i = 0; i < numberOfElement; i++){
				for(int j = 0; j < numberOfElement-1-i; j++){
					if(myQueue[j].distance > myQueue[j+1].distance){
						Node temp = myQueue[j];
						myQueue[j] = myQueue[j+1];
						myQueue[j+1] = temp;
					}
				}
			}
		}
		
		public boolean isEmpty(){
			if(numberOfElement > 0){
				return false;
			}
			else{
				return true;
			}
		}
	}
	
	public Dijkstra(int[][] inputGraph) {
		// TODO Auto-generated constructor stub
		graph = inputGraph;
		priorityQueue = new PriorityQueue(graph.length);
		nodeList = new Node[graph.length];
	}
	
	public void runDijkstra(int source){
		Source = new Node();
		Source.nodeNumber = source;
		Source.distance = 0;
		priorityQueue.enqueue(Source);
		nodeList[source] = Source;
		
		while(!priorityQueue.isEmpty()){
			
			Node node = priorityQueue.dequeue();
			for(int i = 0; i < graph.length; i++){
				int distance = graph[node.nodeNumber][i];
				
				if(distance != 0){
					
					if(nodeList[i] == null){
						Node temp = new Node();
						nodeList[i] = temp;
						nodeList[i].nodeNumber = i;
						nodeList[i].distance = node.distance + distance;						
						nodeList[i].previous = node;
						priorityQueue.enqueue(nodeList[i]);
					}
					else if(nodeList[i].distance > node.distance + distance){
						nodeList[i].distance = node.distance + distance;
						nodeList[i].previous = node;
						priorityQueue.enqueue(nodeList[i]);
					}
				}
			}
		}
	}
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[][] list = {{0,10,0,5,0},{0,0,1,2,0},{0,0,0,0,4},{0,3,9,0,2},{7,0,6,0,0}};
		Dijkstra dijkstra = new Dijkstra(list);
		dijkstra.runDijkstra(0);
		for(int i = 0 ; i < dijkstra.nodeList.length; i++){
			System.out.println(dijkstra.nodeList[i].distance);
		}

	}

}

