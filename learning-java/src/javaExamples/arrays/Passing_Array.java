package javaExamples.arrays;

public class Passing_Array {

	public static void main(String[] args) {
		// Declaring an Array
		String[] aMake = { "BMW", "AUDI", "TOYOTA", "SUZUKI", "HONDA" };
		// Calling Print Array method and passing an Array as a parameter
		Print_Array(aMake);

	}

	// This accept Array as an argument of type String
	public static void Print_Array(String[] array) {

		for (int i = 0; i <= array.length - 1; i++) {
			System.out.println("Printing all the values of an Array ==> " + array[i]);
		}
	}

}