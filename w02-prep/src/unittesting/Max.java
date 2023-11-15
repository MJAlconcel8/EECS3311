package unittesting;

public class Max {
	
	/** what is the test strategy
	 * 
	 * @param x positive int
	 * @param y positive int
	 * @return the max of x and y
	 * 
	 * when forming all pairs
	 * in the big rectangle we have 3 positions
	 * 1) below diagonal x > y (3, 1)
	 * 2) above diagonal x < y (5, 8)
	 * 3) on the diagonal x = y (6, 6)
	 * Edge: cases in the boundary
	 * (6, 6)
	 * (5, 6) -> edge case
	 * (6, 7) -> another edge case
	 */
	public static int computeMax(int x, int y) {
		// some mystery code
		return Math.max(x, y);
	}
	
	/**
	 * Q: for condition coverage
	 * 
	 * x < y || a == b && d >= c
	 * naively speaking, its 8=2^3
	 * the answer: design test cases to check when
	 * the VALUE (boolean value) of the combined expression
	 * changes
	 */

}
