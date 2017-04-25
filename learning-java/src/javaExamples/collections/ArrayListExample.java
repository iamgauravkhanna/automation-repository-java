package javaExamples.collections;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListExample {

	public static void main(String args[]) {

		// Declare ArrayList Object
		ArrayList<String> al1 = new ArrayList<String>();
		ArrayList<String> al2 = new ArrayList<String>();

		// Adding objects in ArrayList1 using add method
		al1.add("Jerry");
		al1.add("James");
		al1.add("Jessi");

		// Adding objects in ArrayList2 using addAll method
		al2.addAll(al1);

		// Using Iterator method to print values of ArrayList1
		Iterator<String> it1 = al1.iterator();
		while (it1.hasNext()) {
			System.out.println("Element >> " + it1.next());
		}

		// Removing object from ArrayList1 using remove method
		al1.remove("Jessi");
		System.out.println("\nRemoving element\n");

		// Using Iterator method to print values of ArrayList1
		Iterator<String> it2 = al1.iterator();
		while (it2.hasNext()) {

			System.out.println("Element >> " + it2.next());
		}

		// Declare ArrayList Object
		ArrayList<String> al3 = new ArrayList<String>();

		// Size of ArrayList before retaining element
		System.out.println("Size of ArrayList before retaining element " + al2.size());

		// Adding objects in ArrayList2 using addAll method
		al3.addAll(al2);

		// Retaining elements
		al2.retainAll(al1);

		// Size of ArrayList before retaining element
		System.out.println("Size of ArrayList after retaining elements " + al2.size());

		System.out.println("\nElement Retained\n");

		// Using Iterator method to print values of ArrayList
		Iterator<String> it3 = al2.iterator();
		while (it3.hasNext()) {
			System.out.println("Element >>" + it3.next());
		}
	}
}
