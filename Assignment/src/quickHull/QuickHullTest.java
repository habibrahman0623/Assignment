package quickHull;

import java.util.ArrayList;
import java.util.List;

public class QuickHullTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Point>list=new ArrayList<Point>();
		
		list.add(new Point(2,2));
		list.add(new Point(1,5));
		list.add(new Point(3,3));
		list.add(new Point(3,5));
		list.add(new Point(4,1));
		list.add(new Point(4,5));
		list.add(new Point(4,8));
		list.add(new Point(5,4));
		list.add(new Point(5,6));
		list.add(new Point(6,3));
		list.add(new Point(8,4));
		list.add(new Point(7,7));
		
		QuickHull qh=new QuickHull(list);
		list=qh.createQuickHull();
	}

}
