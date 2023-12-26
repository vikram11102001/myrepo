package practiceprograms;

import java.io.*;
import java.util.*;

class AddElementsToHashtable {
	public static void main(String args[])
	{
		// No need to mention the
		// Generic type twice
		Hashtable<String, String> ht1 = new Hashtable<>();

		// Initialization of a Hashtable
		// using Generics
		Hashtable<Integer, String> ht2
			= new Hashtable<Integer, String>();

		// Inserting the Elements
		// using put() method
		ht1.put("CC1", "DINERS CLUB");
		ht1.put("CC2", "RUPAY");
		ht1.put("CC3", "IRCTC");

		ht2.put(4, "four");
		ht2.put(5, "five");
		ht2.put(6, "six");

		// Print mappings to the console
		System.out.println("Mappings of ht1 : " + ht1);
		System.out.println("Mappings of ht2 : " + ht2);
	}
}
