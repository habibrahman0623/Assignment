package convexHull;

import java.util.ArrayList;
import java.util.List;

public class ConvexHullTest {

	public static void main(String[] args) {
		
		List<Point>list=new ArrayList<Point>();
		list.add(new Point(2, 3));
		list.add(new Point(3, 2));
		list.add(new Point(4, 3));
		list.add(new Point(5, 2));
		list.add(new Point(6, 5));
		list.add(new Point(7, 4));
		list.add(new Point(6, 6));
		list.add(new Point(4, 4));
		list.add(new Point(4, 6));
		list.add(new Point(1, 5));
		
		GrahamScan gc=new GrahamScan(list);
		list=gc.createConvexHull();
		for(int i=0;i<list.size();i++){
			System.out.println("("+list.get(i).x_pos+" , "+list.get(i).y_pos+")");
		}
		
	}

}
