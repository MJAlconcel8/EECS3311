import java.util.HashSet;
import java.util.Set;

public class UsePoint {
	
	public static void main(String[] args) {
		// the object SimplePoint(1,2)
		// lives on the heap
		// p1 lives on the stack and contains
		// the address of the said object
		SimplePoint p1 = new SimplePoint(1,2);
		SimplePoint p2 = new SimplePoint(1,2);
		// p3 and p1 are identical
		// because they point to 
		// the same object
		SimplePoint p3 = p1;
		System.out.println(p1.equals(p2));
		// equals compares address by default
		// because of Object class
		BetterPoint p4 =
				new BetterPoint(1,2);
		BetterPoint p5 = 
				new BetterPoint(1,2);
		System.out.println(p4.equals(p5));
		
		Set<BetterPoint> setPoints = 
				new HashSet<>();
		setPoints.add(p4);
		System.out.println(setPoints.contains(p5));
		System.out.println(p4.hashCode());
		System.out.println(p5.hashCode());
		// p4 sits in the bucket 622488023
	}

}
