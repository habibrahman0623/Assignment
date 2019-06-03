package kruskal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Kruskal {

	List<Edge>edgeList=new ArrayList<Edge>();
	List<Edge>mstEdgeList=new ArrayList<Edge>();
	Graph graph=new Graph();
	
	public Kruskal(List<Edge> edgeList) {
		// TODO Auto-generated constructor stub
		this.edgeList=edgeList;
		Collections.sort(this.edgeList, new MyComarator());
	}
	public List<Edge> createMST(){
		boolean flag1,flag2;
		for(int i=0;i<edgeList.size();i++){
			flag1=true;
			flag2=true;
			for(int j=0;j<mstEdgeList.size();j++){
				if(edgeList.get(i).Source==mstEdgeList.get(j).Source||edgeList.get(i).Source==mstEdgeList.get(j).Destination){
					flag1=false;
				}
				if(edgeList.get(i).Destination==mstEdgeList.get(j).Source||edgeList.get(i).Destination==mstEdgeList.get(j).Destination){
					flag2=false;
				}
			}
			if(flag1||flag2){
				mstEdgeList.add(edgeList.get(i));
				graph.buildGraph(edgeList.get(i).Source, edgeList.get(i).Destination, flag1, flag2);
			}
			else {
				if(checkCycle(mstEdgeList, edgeList.get(i))){
					mstEdgeList.add(edgeList.get(i));
				}
			}
			
		}
		
		return mstEdgeList;
	}
	
	public Boolean checkCycle(List<Edge> list,Edge tempEdge){
		
		for(int i=0;i<list.size();i++){
			if(tempEdge.Source==list.get(i).Source||tempEdge.Source==list.get(i).Destination){
				return false;
			}	
		}
		return true;
	}
}
