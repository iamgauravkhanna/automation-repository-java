package javaExamples.interviewRecipes;

public class ReverseAString2 {

	public static void main(String args[]) {

		String inputString = "Gaurav Kumar Khanna";

		char[] inputStringCharArray = inputString.toCharArray();

		String reverseString = "";

		for (int i = inputStringCharArray.length - 1; i >= 0; i--) {

			reverseString = reverseString + inputStringCharArray[i];

		}

		System.out.println("Reversed String : " + reverseString);

	}

}