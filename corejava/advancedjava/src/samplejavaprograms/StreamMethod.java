package samplejavaprograms;

import java.util.*; 
import java.util.stream.*; 

public class StreamMethod { 

	public static void main(String[] args) 
	{ 

		ArrayList<Integer> al = new ArrayList<Integer>(); 
 
		al.add(2); 
		al.add(6); 
		al.add(9); 
		al.add(4); 
		al.add(20); 

		System.out.println("Printing the collection : "
						+ al); 

		System.out.println(); 

		List<Integer> ls = al.stream() .filter(i -> i % 2 == 0) .collect(Collectors.toList()); 

		System.out.println( 
			"Printing the List after stream operation : "
			+ ls); 
	} 
}
