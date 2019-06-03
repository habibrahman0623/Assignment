package prim;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MST {

	List<String>vertexList=new ArrayList<String>();
	List<String>tempVertexList=new ArrayList<String>();
	List<Edge>edgeList=new ArrayList<Edge>();
	List<Edge>tempEdgeList=new ArrayList<Edge>();
	
	public MST(List<String> vertex,List<Edge> edgeList2) {

		this.tempVertexList=vertex;
		this.tempEdgeList=edgeList2;
		Collections.sort(tempEdgeList, new MyComarator());
	}
	public List createMST(){
		
		vertexList.add(tempEdgeList.get(0).Source);
		vertexList.add(tempEdgeList.get(0).Destination);
		tempVertexList.remove(tempEdgeList.get(0).Source);
		tempVertexList.remove(tempEdgeList.get(0).Destination);
		edgeList.add(tempEdgeList.get(0));
		tempEdgeList.remove(0);
		while(tempVertexList.size()!=0){
			Edge tempEdge=minCostEdge();
			vertexList.add(tempEdge.Destination);
			tempVertexList.remove(tempEdge.Destination);
			tempEdgeList.remove(tempEdge);
			edgeList.add(tempEdge);
		}
		
		return edgeList;
	}
	public Edge minCostEdge(){
		
		Collections.sort(tempEdgeList, new MyComarator());
		Edge edge;
		for(int i=0;i<tempEdgeList.size();i++){
			boolean flag=true;
			for(int j=0;j<vertexList.size();j++){
				if(tempEdgeList.get(i).Source==vertexList.get(j)){
					for(int k=0;k<vertexList.size();k++){
						if(tempEdgeList.get(i).Destination==vertexList.get(k)){
							flag=false;
							break;
						}
					}
					if(flag){
						edge=tempEdgeList.get(i);
						return edge;
					}
				}
			}
		}
		return null;
	}
}
