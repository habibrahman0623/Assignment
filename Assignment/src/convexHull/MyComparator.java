package convexHull;

import java.util.Comparator;

public class MyComparator implements Comparator<Point> {

	@Override
	public int compare(Point p1, Point p2) {
		// TODO Auto-generated method stub
		if(p1.angle-p2.angle!=0)
			return p1.angle-p2.angle;
		
		return 0;
	}

}
