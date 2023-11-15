
class BooleanExample {
	public static void main(String [] args){
		boolean b;
		/* Operations which return a boolean (true/false)
		 * i==j i<j i<=j i>j i>=j i!=j
		 */ 

		int i, j;
		i=7; j=9;

		// The comparison operator ==
		// i==j is true if i and j have the same VALUE
		// otherwise i == j is false

		b=(i==j); // This sets b to false

		// The comparison operator >
		// i>j is true if the value of i is greater than the value of j
		// otherwise i > j is false

		b=(23 > j); // This sets b to true

		// Other operations include >=, <=

		// Can print out the value of booleans
		System.out.println("b="+b); 
		
		/* Operations on booleans 
		 * !, &&, ||, ^
		 * !b is true if b is false 
		 * !b is false if b is true
		 */

		System.out.println("So !b="+(!b));

		boolean b1,b2;
		b1=true; 
		b2=(99<j);
		System.out.println("b1="+b1);
		System.out.println("b2="+b2);

		// b1 && b2 is true if both b1 and b2 are true
		// b1 && b2 is false otherwise

		System.out.println("b1 && b2="+(b1 && b2)); 
		/* 
		 * NOTE: (b1 && b2) (bracketed in the above expression) 
		 * makes sure that this expression
		 * is evaluated first (before converting to a string)
		 */
		
		// b1 || b2 is true if at least one of b1 or b2 is true
		// b1 || b2 is false otherwise (ie. if both b1 and b2 are false)

		System.out.println("b1 || b2="+(b1 || b2)); 

		/* Finally, we can use the boolean operators &&, ||, ! 
		 * in combination with eachother and with expressions that 
		 * return boolean values.
		 */

		b=(!(12>23))||(b1&&b2&&true);
		// That is, b=(!(false))||(true && false && true)) which is 
		// (true || false) which is true
		System.out.println("Combination example, b="+b); 
	}
}
