import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class BasicCollections {
	
	public static void main(String[] args) {
		
		List<String> myList = new ArrayList<>();
		myList.add("A");
		myList.add("B");
		myList.add("C");
		myList.add("A");
		myList.add("D");
		
		System.out.println("iterating over an ArrayList");
		Iterator<String> it1 = myList.iterator();
		while (it1.hasNext()) {
			System.out.println(it1.next());
		}
		System.out.println(myList.get(1));
		
		
		Set<String> mySet = new HashSet<>();
		mySet.add("B");
		mySet.add("C");
		mySet.add("A");
		mySet.add("C");
		System.out.println("mySet: "+mySet.toString());
		
		System.out.println("Does myList contain all strings in mySet? " + 
					myList.containsAll(mySet));
		
		
		List<String> myLinkedList = new LinkedList<>();
		myLinkedList.addAll(mySet);
		myLinkedList.addAll(myList);
		System.out.println(myLinkedList);
		
		Map<String, Integer> myMap = new HashMap<String, Integer>();
		myMap.put("A", 1);
		myMap.put("B", 1);
		myMap.put("C", 4);
		myMap.put("A", 4);
		System.out.println(myMap);
		
	}

}
