package bfs;

import java.util.ArrayList;
import java.util.List;

public class BFSTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		FileReader filereader = new FileReader("BFSData.txt");
		filereader.openFile();
		List<List<Integer>> data = new ArrayList<>();
		data = filereader.readFile();
		BFS bfs = new BFS(1, data);
		bfs.runBFS();
		bfs.printNode();

	}

}
