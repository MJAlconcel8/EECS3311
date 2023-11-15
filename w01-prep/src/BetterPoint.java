
public class BetterPoint {
	
	private int x,y;
	public BetterPoint(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) 
			return true;// else LSP is violated
		if (!(o instanceof BetterPoint))
			return false;
		BetterPoint p = (BetterPoint)o;
		return (this.x == p.x && this.y==p.y);
	}
	
	@Override
	public int hashCode() {
		return 17*this.x+31*this.y;
	}
	
	
	@Override
	public String toString()
	{
		return "("+this.x+","+this.y+")";
	}

}
