package prim;

import java.util.ArrayList;
import java.util.List;

public class MSTtest {

	public static void main(String[] args) {
		
		List<String>vertex=new ArrayList<String>();
		List<Edge>edgeList=new ArrayList<Edge>();
		vertex.add("a");
		vertex.add("b");
		vertex.add("c");
		vertex.add("d");
		/*vertex.add("e");
		vertex.add("f");
		vertex.add("g");
		*/
		edgeList.add(new Edge("a", "b", 2));
		edgeList.add(new Edge("b", "a", 2));
		edgeList.add(new Edge("a", "c", 4));
		edgeList.add(new Edge("c", "a", 4));
		edgeList.add(new Edge("b", "c", 1));
		edgeList.add(new Edge("c", "b", 1));
		edgeList.add(new Edge("b", "d", 2));
		edgeList.add(new Edge("d", "b", 2));
		edgeList.add(new Edge("c", "d", 3));
		edgeList.add(new Edge("d", "c", 3));
		
		MST mst=new MST(vertex, edgeList);
		edgeList=mst.createMST();
		
		
		for(int i=0;i<edgeList.size();i++){
			
			System.out.println(edgeList.get(i).Source+"--->"+edgeList.get(i).Destination);
		}
		
		
	}
	

}
