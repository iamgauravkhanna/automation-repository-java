package javaExamples.miscellaneous;

// Program to count Occurrence of Element in an Array

import java.util.Scanner;

public class OccurencesOfElements {

	private static Scanner input, sizeOfArray;

	public static void main(String[] args) {

		input = new Scanner(System.in);

		sizeOfArray = new Scanner(System.in);

		System.out.println("Please enter size of array");

		int size = sizeOfArray.nextInt();

		int[] userInputArrayObj = new int[size];

		int[] elementsCountArrayObj = new int[size + 1];

		// Declare counter variable i
		// and temp variable that will
		// temporarily hold the value
		// at a certain index of userInputArrayObj[] array
		int i, temp = 0;

		System.out.println("Enter the integers between 1 and " + size);

		// Initialize userInputArrayObj[] array with user input
		for (i = 0; i < userInputArrayObj.length; i++) {

			userInputArrayObj[i] = input.nextInt();

		} // end of for loop

		// Value at a given index of userInputArrayObj array
		// will be stored in temp variable
		// temp variable will act as an index value
		// for elementsCountArrayObj array and keep track of number
		// of occurences of each number
		for (i = 0; i < userInputArrayObj.length; i++) {

			temp = userInputArrayObj[i];

			elementsCountArrayObj[temp]++;

		} // end of for loop

		for (i = 1; i < elementsCountArrayObj.length; i++) {

			if (elementsCountArrayObj[i] > 0 && elementsCountArrayObj[i] == 1) {

				System.out.printf("%d occurs %d time\n", i, elementsCountArrayObj[i]);

			} else if (elementsCountArrayObj[i] >= 2) {

				System.out.printf("%d occurs %d times\n", i, elementsCountArrayObj[i]);

			}

		} // end of for loop

	}// end of main

}// end of CountOccurrenceOfNumbers
