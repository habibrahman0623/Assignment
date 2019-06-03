package kruskal;

import java.util.ArrayList;
import java.util.List;

public class KruskalTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Edge>edgeList=new ArrayList<Edge>();
		edgeList.add(new Edge("a", "b",7 ));
		edgeList.add(new Edge("a", "d", 5));
		edgeList.add(new Edge("b", "d", 9));
		edgeList.add(new Edge("b", "c",8 ));
		edgeList.add(new Edge("b", "e", 7));
		edgeList.add(new Edge("c", "e", 5));
		edgeList.add(new Edge("d", "e",15 ));
		edgeList.add(new Edge("d", "f", 6));
		edgeList.add(new Edge("e", "f", 8));
		edgeList.add(new Edge("e", "g",9 ));
		edgeList.add(new Edge("f", "g", 11));
		Kruskal k=new Kruskal(edgeList);
		edgeList=k.createMST();
		
		for (Edge edge : edgeList) {
			System.out.println(edge.Source+"------->"+edge.Destination);
		}
	}

}
