package exceptions;

public class Simple {
	
	
	/**
	 * 
	 * @param a natural number
	 * @param b natural number
	 * @return reminder of a divided by b
	 * @throws UnluckyNumber 
	 */
	static int rem(int a, int b) throws UnluckyNumber {
		if (a == 13 || b == 13) 
			throw new UnluckyNumber("Yikes! 13 is unlucky!");
		if (a < 0 || b < 0)
			throw new NotNaturalNumber("Yikes! Negative number");
		if (b==0) 
			throw new ArithmeticException("Yikes! Dvision by zero!");
	    while (a>=b)
	    	a = a - b;
	    return a;   
	}

	public static void main(String[] args) throws UnluckyNumber {
		
		int r = 0;
		
		try {
			r = rem(42, 12);
		} catch (UnluckyNumber e) {
			
			//e.printStackTrace();
			System.out.println("this is the catch block");
			
		} finally {
			// some cleanup
			System.out.println("this piece always runs");
		}
		
		System.out.println(r);
		
		
		// TODO Auto-generated method stub

	}

}
