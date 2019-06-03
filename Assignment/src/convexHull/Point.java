package convexHull;


public class Point {

	public int x_pos;
	public int y_pos;
	public int angle;
	
	public Point(int x,int y) {
		// TODO Auto-generated constructor stub
		x_pos=x;
		y_pos=y;
	}
	public void angel(Point point){
		
		this.angle=(int)Math.toDegrees(Math.atan2(y_pos-point.y_pos, x_pos-point.x_pos));
	}
}
