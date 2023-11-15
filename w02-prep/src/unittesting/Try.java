package unittesting;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Try {

	public static void main(String[] args) {
		
		List<Integer> divs;
	
		Map<Integer, List<Integer>> divisors =
				new HashMap<>();
		for (int n=2; n < 100; n++) {
			divs = new ArrayList<>();
			for (int k=2; k < n; k++)
				if (n%k==0) 
					divs.add(k);
			divisors.put(n, divs);
		}
		
		System.out.println(divisors);
		
	}

}
