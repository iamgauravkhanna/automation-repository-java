package javaExamples.interviewRecipes;

/**
 * If ‘n’ is the positive number and ‘a’ is an array of integers of length n-1
 * containing elements from 1 to n. Then find the missing number in ‘a’ in the
 * range from 1 to n. Occurrence of each element is only once. i.e ‘a’ does not
 * contain duplicates.
 *
 */
public class MissingNumbersInArray {

	// Method to calculate sum of 'n' numbers
	static int sumOfNnumbers(int numberOfElements) {

		//
		int sum = (numberOfElements * (numberOfElements + 1)) / 2;

		//
		return sum;
	}

	// Method to calculate sum of all elements of array
	static int sumOfElements(int[] arrayObj) {

		//
		int sum = 0;

		//
		for (int i = 0; i < arrayObj.length; i++) {

			//
			sum = sum + arrayObj[i];

		}

		//
		return sum;
	}

	// Main Method
	public static void main(String[] args) {

		//
		int numberOfElements = 8;

		//
		int[] arrayObj = { 1, 4, 2, 3, 7, 8, 6 };

		// Step 1
		int sumOfNnumbers = sumOfNnumbers(numberOfElements);

		// Step 2
		int sumOfElements = sumOfElements(arrayObj);

		// Step 3
		int missingNumber = sumOfNnumbers - sumOfElements;

		System.out.println("Missing Number is = " + missingNumber);
	}
}