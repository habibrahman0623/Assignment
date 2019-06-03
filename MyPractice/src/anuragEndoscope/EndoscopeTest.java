package anuragEndoscope;

public class EndoscopeTest {
	
	public int[][] inputlist;
	public int[][] color;
	public int[][] distance;
	
	public class Node{
		int value,loc_x,loc_y;
		Node previous, next;
		public Node(int value, int i, int j) {
			// TODO Auto-generated constructor stub
			this.value = value;
			loc_x = i;
			loc_y = j;
		}
	}
	
	public class MyQueue {
		

		private Node entryPoint;
		private Node removalPoint;
		
		
		public void enqueue(int value, int i, int j){
			
			Node newNode = new Node(value,i,j);
			if(entryPoint == null){
				entryPoint = newNode;
				removalPoint = newNode;
			}
			else {
				
				newNode.previous = entryPoint;
				newNode.previous.next = newNode;
				entryPoint = newNode;
				
			}
			
		}
		
		public Node dequeue(){
			
			Node node = null;
			
			if(!isEmpty()){
				node = removalPoint;
				removalPoint = removalPoint.next;
				if(removalPoint != null){
					removalPoint.previous = null;
				}
				else {
					entryPoint = null;
					
				}
			}
			
			
			
			return node;
		}
		
		public boolean isEmpty(){
			if(removalPoint == null){
				return true;
			}
			else {
				return false;
			}
		}
	}

	
	public EndoscopeTest(int[][] input) {
		// TODO Auto-generated constructor stub
		
		inputlist = input;
		color = new int[inputlist.length][inputlist[0].length];
		distance = new int[inputlist.length][inputlist[0].length];
		
	}
	
	public int runBFS(int sourceI, int sourceJ, int endoscopeLength){
		MyQueue myQueue = new MyQueue();
		int value = inputlist[sourceI][sourceJ];
		myQueue.enqueue(value, sourceI, sourceJ);
		color[sourceI][sourceJ] = 1;
		distance[sourceI][sourceJ] = 1;
		int numberOfVisitedPipe = 1;
		
		while(!myQueue.isEmpty()){
			
			Node node = myQueue.dequeue();
			int pipeType = node.value;
			int i = node.loc_x;
			int j = node.loc_y;
			if(distance[i][j] < endoscopeLength){
				if(j+1 < inputlist[0].length && inputlist[i][j+1] != 0 && color[i][j+1] == 0){
					if((pipeType == 1 || pipeType == 3 || pipeType == 4 || pipeType == 5) && (inputlist[i][j+1] == 1 || inputlist[i][j+1] == 3 || inputlist[i][j+1] == 6 ||inputlist[i][j+1] == 7)){
						myQueue.enqueue(inputlist[i][j+1], i, j+1);
						color[i][j+1] = 1;
						distance[i][j+1] = distance[i][j] + 1;
						numberOfVisitedPipe++;
					}
				}
				if(j > 0 && inputlist[i][j-1] != 0 && color[i][j-1] == 0){
					if((pipeType == 1 || pipeType == 3 || pipeType == 6 || pipeType == 7) && (inputlist[i][j-1] == 1 || inputlist[i][j-1] == 3 || inputlist[i][j-1] == 4 ||inputlist[i][j-1] == 5)){
						myQueue.enqueue(inputlist[i][j-1], i, j-1);
						color[i][j-1] = 1;
						distance[i][j-1] = distance[i][j] + 1;
						numberOfVisitedPipe++;
					}
				}
				if(i+1 < inputlist.length && inputlist[i+1][j] != 0 && color[i+1][j] == 0){
					if((pipeType == 1 || pipeType == 2 || pipeType == 5 || pipeType == 6) && (inputlist[i+1][j] == 1 || inputlist[i+1][j] == 2 || inputlist[i+1][j] == 4 ||inputlist[i+1][j] == 7)){
						myQueue.enqueue(inputlist[i+1][j], i+1, j);
						color[i+1][j] = 1;
						distance[i+1][j] = distance[i][j] + 1;
						numberOfVisitedPipe++;
					}
				}
				if(i > 0 && inputlist[i-1][j] != 0 && color[i-1][j] == 0){
					if((pipeType == 1 || pipeType == 2 || pipeType == 4 || pipeType == 7) && (inputlist[i-1][j] == 1 || inputlist[i-1][j] == 2 || inputlist[i-1][j] == 5 ||inputlist[i-1][j] == 6)){
						myQueue.enqueue(inputlist[i-1][j], i-1, j);
						color[i-1][j] = 1;
						distance[i-1][j] = distance[i][j] + 1;
						numberOfVisitedPipe++;
					}
				}
			}
			
			else {
				break;
			}
			
		}
		
		return numberOfVisitedPipe;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int [][] graph = {{0,0,5,3,6,},{0,0,2,0,2},{3,3,1,3,7}};
		EndoscopeTest endoscopeTest = new EndoscopeTest(graph);
		System.out.println(endoscopeTest.runBFS(2, 1, 6));

	}

}
