package practice;

import java.util.ArrayList;
import java.util.List;

public class Practice {
	
	public static void main(String[] args) {
		
		// List<Integer> things = new ArrayList<>();
		
		// things is a list of random Objects
		List things = new ArrayList();
		// autoboxing
		things.add(42);
		//System.out.println(42.getClass());
		System.out.println(things.get(0).getClass());
		things.add(42.2);
		System.out.println(things.get(1).getClass());
		int x = (int)42.2;
		double y = 42;
		

		
		
		
		
	}

}
