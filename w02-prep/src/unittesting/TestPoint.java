package unittesting;

import static org.junit.Assert.*;
import org.junit.Test;

public class TestPoint {
	
	Point point;

	@Test
	public void testManhattanDist() {
		Point point = new Point(3, 4);
		Point otherPoint = new Point(4, 3);
		int expectedValue = 2;
		int computedValue = point.getManhattanDist(otherPoint);
		assertEquals(expectedValue, computedValue);
	}

}
