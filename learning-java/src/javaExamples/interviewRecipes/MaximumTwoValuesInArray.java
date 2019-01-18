package javaExamples.interviewRecipes;

// Program to Find the first two max values from an array

public class MaximumTwoValuesInArray {

	public void GetTwoMaxValues(int[] arrayObj) {

		int maxOne = 0;

		int maxTwo = 0;

		for (int n : arrayObj) {

			if (maxOne < n) {

				maxTwo = maxOne;

				maxOne = n;

			} else if (maxTwo < n) {

				maxTwo = n;

			}

		}

		System.out.println("Max1 - " + maxOne);

		System.out.println("Max2 - " + maxTwo);

	}

	public static void main(String[] args) {

		int arrayObj[] = { 15, 24, 48, 21, 43, 11, 79, 93, 65, 100, 3, 9, 38 };

		MaximumTwoValuesInArray max = new MaximumTwoValuesInArray();

		max.GetTwoMaxValues(arrayObj);

	}

}