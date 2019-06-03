package quickHull;

import java.util.ArrayList;
import java.util.List;

public class QuickHull {
	
	List<Point>pointList=new ArrayList<Point>();
	List<Point>quickHull=new ArrayList<Point>();
	
	public QuickHull(List<Point>list) {
		// TODO Auto-generated constructor stub
		
		pointList=list;
	}
	
	public void extremePoint(){
		Point min=pointList.get(0),max=pointList.get(0);
		for(int i=0;i<pointList.size();i++){
			if(pointList.get(i).x_pos<min.x_pos){
				min=pointList.get(i);
			}
			if(pointList.get(i).x_pos>max.x_pos){
				
				max=pointList.get(i);
			}
		}
		quickHull.add(min);
		pointList.remove(min);
		quickHull.add(max);
		pointList.remove(max);
	}
	
	public List<Point> createQuickHull(){
		
		extremePoint();
		List<Point>left=new ArrayList<Point>();
		List<Point>right=new ArrayList<Point>();
		
		for(int i=0;i<pointList.size();i++){
			if(determineLocation(quickHull.get(0), quickHull.get(1), pointList.get(i))==1){
				left.add(pointList.get(i));
				
			}
			else {
				right.add(pointList.get(i));
			}
		}
		recursivePart(quickHull.get(0), quickHull.get(1), left);
		recursivePart(quickHull.get(1), quickHull.get(0), right);
		
		return quickHull;
		
	}
	
	public int determineLocation(Point a,Point b,Point c){
		
		int temp=(b.x_pos-a.x_pos)*(c.y_pos-a.y_pos)-(b.y_pos-a.y_pos)*(c.x_pos-a.x_pos);
		if(temp>0)
			return 1;
		else return -1;
	}
	
	public void recursivePart(Point a,Point b,List<Point>list){
		
		int index=0;
		if(list.size()==0)
			return;
		if(list.size()==1){
			quickHull.add(list.get(0));
			return;
		}	
		for(int i=1;i<list.size();i++){
			
			int max=distance(a, b, list.get(0));
			index=0;
			if(max<distance(a, b, list.get(i))){
				max=distance(a, b, list.get(i));
				index=i;
			}
		}
		Point p= list.remove(index);
		quickHull.add(p);
		List<Point>leftAP=new ArrayList<Point>();
		List<Point>leftPB=new ArrayList<Point>();
		for(int i=0;i<list.size();i++){
			
			if(determineLocation(a, p, list.get(i))==1){
				leftAP.add(list.get(i));
			}
			if(determineLocation(p, b, list.get(i))==1){
				leftPB.add(list.get(i));
			}
		}
		
		recursivePart(a, p, leftAP);
		recursivePart(p, b, leftPB);
		
		
	}
	
	public int distance(Point a,Point b,Point c){
		
		return Math.abs((c.x_pos-a.x_pos)*(b.y_pos-a.y_pos)-(c.y_pos-a.y_pos)*(b.x_pos-a.x_pos));
	}
	
}
