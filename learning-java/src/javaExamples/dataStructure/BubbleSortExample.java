package javaExamples.dataStructure;

public class BubbleSortExample {

	private static void bubbleSort(int[] input) {

		int i;

		for (int j = 0; j < input.length - 1; j++) {

			int flag = 0;

			for (i = 0; i < input.length - 1; i++) {

				if (input[i] > input[i + 1]) {

					int swap = input[i];

					input[i] = input[i + 1];

					input[i + 1] = swap;

					flag++;

				}

			}

			if (flag == 0) {

				System.out.println("");
				System.out.println("Exiting Loop at Round Number => " + j + " , " + i);
				break;
			}

		}

		System.out.println("");

		System.out.println("After Sort");

		printArray(input);

	}

	private static void printArray(int[] input) {

		for (int k = 0; k < input.length; k++) {

			System.out.print(input[k] + " ");

		}

	}

	public static void main(String[] args) {

		int[] input = { 4, 9, 2, 11, 6, 23, 12, 34, 0, 1 };

		System.out.println("Before Sort");

		printArray(input);

		bubbleSort(input);

	}

}
