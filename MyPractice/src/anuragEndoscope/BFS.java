package anuragEndoscope;

import myBFS.MyQueue;

public class BFS {
	public int[][] inputMatrix;
	public int[] color;
	public int[] distance;
	public int[] previous;
	public BFS(int[][] inputGraph) {
		// TODO Auto-generated constructor stub
		inputMatrix = inputGraph;
		int length = inputGraph.length;
		color = new int[length];
		distance = new int[length];
		previous = new int[length];
		
	}
	public void runBFS(int source){
		 MyQueue myQueue =  new MyQueue();
		 myQueue.enqueue(source);
		 
		 while(!myQueue.isEmpty()){
			 int uIndex = myQueue.dequeue();
			 color[uIndex] = 1;
			 distance[uIndex] = 0;
			 int length = inputMatrix[uIndex].length;
			 for(int  i = 0; i < length; i++){
				 if(inputMatrix[uIndex][i] != 0){
					 if(color[i] == 0){
						 color[i] = 1;
						 distance[i] = distance[uIndex] + 1;
						 previous[i] = uIndex;
						 myQueue.enqueue(i);
					 }
					 if(color[i] == 1 && previous[i] != uIndex){ // for undirected graph
						 System.out.println("Cycle detected on: "+ i+ "&"+ uIndex);
					 }
				 }
			 }
			 color[uIndex] = 2;
		 }
		
		
	}


}
