package javaExamples.interviewRecipes;

public class ReverseNumber {

	public long doInvert(long number) {

		long invert = 0;

		while (number != 0) {

			invert = (invert * 10) + (number % 10);

			number = number / 10;
		}

		return invert;
	}

	public static void main(String args[]) {

		long lnum = 986532;

		ReverseNumber input = new ReverseNumber();

		System.out.println("Input value : " + lnum);

		System.out.println("Inverted value : " + input.doInvert(lnum));
	}
}