package comparable;

/**
 * 
 * @author ilirdema
 *
 *
 *  consider points (1,2) and (1,3), we say (1,3)>(1,2)
 *  consider points (1,2) and (2,4), we say (2,4)>(1,2)
 *
 */



public class Point implements Comparable<Point> {
	
	private int x,y;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}



	public void setX(int x) {
		this.x = x;
	}



	public int getY() {
		return y;
	}



	public void setY(int y) {
		this.y = y;
	}

	@Override
	public boolean equals(Object other) {
		if (this == other)
			return true;
		if (!(other instanceof Point))
            return false;
		Point bp = (Point)other;
		return (this.x == bp.x) && (this.y == bp.y);
	}
	
	@Override
	public int hashCode() {
		return 17*Integer.valueOf(this.x).hashCode()+
				23*Integer.valueOf(this.y).hashCode();
	}

	@Override
	public int compareTo(Point other) {
		// TODO Auto-generated method stub
		if (this.equals(other))
			return 0;
		if ((this.x < other.x) || 
				(this.x == other.getX() && this.y < other.getY()))
			return -1; // means <
		return 1; // means >
	}
	
	

}
