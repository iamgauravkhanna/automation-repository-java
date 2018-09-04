package javaExamples.interviewRecipes;

/**
 * Program to check if a string is a palindrome or not. Remember a string is a
 * palindrome if it remains unchanged when reversed, for example "dad" is a
 * palindrome as reverse of "dad" is "dad" whereas "program" is not a
 * palindrome.
 * 
 * @author Gaurav.Khanna
 *
 */
public class PalindromeStringExample2 {

	//
	public static void main(String args[]) {

		//
		String inputString = "GEEG";

		//
		int length = inputString.length();

		//
		int i, begin, end, middle;

		//
		begin = 0;

		//
		end = length - 1; // 3

		//
		middle = (begin + end) / 2; // 1

		//
		for (i = begin; i <= middle; i++) {

			//
			if (inputString.charAt(begin) == inputString.charAt(end)) {

				//
				begin++;

				//
				end--;

			} else {

				//
				break;
			}
		}
		if (i == middle + 1) {

			//
			System.out.println("Palindrome");

		} else {

			//
			System.out.println("Not a palindrome");

		}
	}

}