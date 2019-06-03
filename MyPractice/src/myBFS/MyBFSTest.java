package myBFS;

public class MyBFSTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*MyQueue myQueue = new MyQueue();
		myQueue.enqueue(10);
		myQueue.enqueue(8);
		myQueue.enqueue(2);
		myQueue.enqueue(16);
		myQueue.enqueue(18);
		myQueue.enqueue(62);
		
		//int value = myQueue.dequeue();
		System.out.println(myQueue.dequeue());
		//System.out.println(myQueue.dequeue());
		myQueue.enqueue(16);
		System.out.println(myQueue.dequeue());*/
		
		int[][] graph = {{0,0,0,0,0,0,0,0,1,0},{0,0,1,1,0,0,0,1,0,1},{0,1,0,0,1,0,0,0,1,0},{0,1,0,0,1,1,0,0,0,0},{0,0,1,1,0,0,0,0,0,0},{0,0,0,1,0,0,1,0,0,0},{0,0,0,0,0,1,0,1,0,0},{0,1,0,0,0,0,1,0,0,0},{1,0,1,0,0,0,0,0,0,1},{0,1,0,0,0,0,0,0,1,0}};
		BFS bfs = new BFS(graph);
		bfs.runBFS(1);
		

	}

}
