
class PrimitiveTypes {
	public static void main(String [] args){
		// Execution begins here...
		/* A java program is a text file consisting 
		 * of a sequence of statements. 
		 * Each statement ends with a semicolon (;)
		 * Execution begins at the first statement after
		 * public static void main(String [] args){
		 * and proceeds down the page.
		*/

		// Expressions - java understands mathematical expressions, 

		System.out.println((2-6)*2.5*10);

		/*
		 * Variables - Named places to hold values.
		 * 	- Each variable has a TYPE describing what 
		 *	  kind of thing the variable can hold. 
		 *	- In order to use a variable, you must first 
		 *	  declare it (tell java the variables name and type). 
		 */

		// Some primitive types in Java 
		byte b; // hold small integers
		int i; // int : can hold an integer  
		int j; 
		long l; // hold large integers
		
		double d; // double : holds a floating point value 
		boolean isHot; // boolean : holds true/false  
		char yourAnswer; // char : holds a single character  

		/* 
		 * Assignment statements 
		 *	Have the form v=expression where v is a variable 
		 * 	and expression evaluates to something with the same
		 *	type as v. 
		 *	Note: an expression can include variables. 
		 */

		// Putting some of this together

		i=23;  // Assign i the value 23
		i=i+1; // Now i is 24
		// i=2.5; // Not allowed!! (why?)
		j=12;
		j=12+i*i-45;
		System.out.print("i=");
		System.out.println(i); // Java knows how to print integers

		System.out.print("j=");
		System.out.println(j);

		d=2.5; // Allowed!! (why?)
		d=d*d;
		System.out.print("d=");
		System.out.println(d); // Java knows how to print doubles

		isHot=true;
		System.out.println(isHot);

		yourAnswer='Y';
		System.out.print("Your answer was:");
		System.out.println(yourAnswer);

		// Strings hold sequences of characters 
		String s; 
		s="Hi there!!";
		System.out.println(s); // Java knows how to print strings
	}
}
