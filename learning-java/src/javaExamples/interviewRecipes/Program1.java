package javaExamples.interviewRecipes;

public class Program1 {

	public static void main(String args[]) {

		int size = 100;

		int[] a = { 1, 3, 5, 67, 7, 4, 73 };

		for (int i = 1; i <= size; i++) {

			if (!(a[i] == i)) {

				System.out.println("Missing Number : " + i);

			}

		}

	}
}