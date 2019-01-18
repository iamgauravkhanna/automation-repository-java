package javaExamples.interviewRecipes;

class PrimeNumber {

	public static void main(String[] args) {

		String primeNumbers = "";

		for (int i = 1; i <= 100; i++) {

			int counter = 0;

			for (int num = i; num >= 1; num--) {

				if (i % num == 0) {

					counter = counter + 1;

				}

			}

			if (counter == 2) {

				// Appended the Prime number to the String
				primeNumbers = primeNumbers + i + " ";

			}

		}

		System.out.println("Prime numbers from 1 to 100 are :");

		System.out.println(primeNumbers);

	}

}