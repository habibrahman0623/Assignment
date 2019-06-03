package bipartite;

public class Bipartite {
	
	int[][] graph;
	int[] color;
	boolean isBipartite = true;
	
	public class Queue{
		
		Integer[] list;
		int numberOfElement;
		
		public Queue(int size) {
			// TODO Auto-generated constructor stub
			
			list = new Integer[size];
		}
		
		public void enQueue(int value){
			if(numberOfElement < list.length){
				list[numberOfElement++] = value;
			}
		}
		
		public Integer deQueue(){
			Integer temp;
			if(numberOfElement > 0){
				temp = list[0];
				for(int i = 0; i < numberOfElement; i++){
					list[i] = list[i+1];
				}
				numberOfElement--;
			}
			
			else {
				temp = null;
			}
			
			return temp;
		}
		
		public boolean isEmplty(){
			if(numberOfElement == 0){
				return true;
			}
			else {
				return false;
			}
		}
		
		
	}
	
	public Bipartite(int[][] inputGraph) {
		// TODO Auto-generated constructor stub
		graph = inputGraph;
		color = new int[graph.length];
	}
	
	public void runBFS(){
		
		int size = graph.length;
		Queue queue = new Queue(size);
		
		for(int i = 0; i < size; i++){
			if(color[i] == 0){
				queue.enQueue(i);
				color[i] = 1;
			}
			
			while(!queue.isEmplty()){
				int u = queue.deQueue();
				for(int j = 0; j < size; j++){
					if(graph[u][j] != 0){
						if(color[j] == 0){
							queue.enQueue(j);
							color[j] = 3 - color[u];
						}
						else if(color[j] == color[u]){
							isBipartite = false;
						}
					}
				}
			}
		}
	}
	
	public void printSameColoredNode(){
		runBFS();
		if(isBipartite){
			int temp = color[0];
			for(int i = 0; i < color.length; i++){
				if(color[i] == temp){
					System.out.println(i);
				}
			}
		}
		else{
			System.out.println(-1);
		}
		
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] graph = {{0,1,1,0,0,0,1},{1,0,0,1,0,0,0},{1,0,0,1,0,0,1},{0,1,1,0,0,0,0},{0,0,0,0,0,0,1},{0,0,0,0,0,0,1},{0,0,0,0,1,1,0}};
		Bipartite bipartite = new Bipartite(graph);
		bipartite.printSameColoredNode();

	}

}
