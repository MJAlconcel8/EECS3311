package unittesting;

public class Point {
	
	private int xcoord, ycoord;
	
	public Point(int xcoord, int ycoord) {
		this.xcoord = xcoord;
		this.ycoord = ycoord;
	}

	public int getManhattanDist(Point other) {
		return Math.abs(this.xcoord - other.xcoord)+
				Math.abs(this.ycoord - other.ycoord);
	}
}
