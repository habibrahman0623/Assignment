package convexHull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GrahamScan {

	List<Point>pointList=new ArrayList<Point>();
	List<Point>convexHull=new ArrayList<Point>();
	
	public GrahamScan(List<Point>list) {
		// TODO Auto-generated constructor stub
		pointList=list;
		lowestY();
		sortByAngel();
	}
	
	public void lowestY(){
		
		Point minPoint=pointList.get(0);
		for(int i=1;i<pointList.size();i++){
			if(pointList.get(i).y_pos<=minPoint.y_pos){
				
				if(pointList.get(i).y_pos==minPoint.y_pos){
					
					if(pointList.get(i).x_pos<minPoint.x_pos)
						minPoint=pointList.get(i);
				}
				else
					minPoint=pointList.get(i);
			}
		}
		
		pointList.remove(minPoint);
		convexHull.add(minPoint);	
	}
	
	public List<Point> createConvexHull(){
		
		int x1,x2,x3,y1,y2,y3;
		Point p;
		while(pointList.size()!=0){
			x3=pointList.get(0).x_pos;
			y3=pointList.get(0).y_pos;
			p=pointList.remove(0);
			x2=convexHull.get(convexHull.size()-1).x_pos;
			y2=convexHull.get(convexHull.size()-1).y_pos;
			x1=convexHull.get(convexHull.size()-2).x_pos;
			y1=convexHull.get(convexHull.size()-2).y_pos;
			if(((x2-x1)*(y3-y1)-(y2-y1)*(x3-x1))>0){
				convexHull.add(p);
			}
			else{
				convexHull.remove(convexHull.size()-1);
				convexHull.add(p);
			}
		}
		return convexHull;
	}
	public void sortByAngel(){
		
		for(int i=0;i<pointList.size();i++){
			pointList.get(i).angel(convexHull.get(0));
		}
		Collections.sort(pointList, new MyComparator());
		convexHull.add(pointList.remove(0));
		convexHull.add(pointList.remove(0));
	}
}
