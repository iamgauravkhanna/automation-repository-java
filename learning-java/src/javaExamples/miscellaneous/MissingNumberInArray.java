package javaExamples.miscellaneous;

public class MissingNumberInArray {

	// Method to calculate sum of 'n' numbers
	static int sumOfNnumbers(int numberOfElements) {
		int sum = (numberOfElements * (numberOfElements + 1)) / 2;

		return sum;
	}

	// Method to calculate sum of all elements of array
	static int sumOfElements(int[] arrayObj) {
		int sum = 0;

		for (int i = 0; i < arrayObj.length; i++) {
			sum = sum + arrayObj[i];
		}

		return sum;
	}

	public static void main(String[] args) {
		int numberOfElements = 8;

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