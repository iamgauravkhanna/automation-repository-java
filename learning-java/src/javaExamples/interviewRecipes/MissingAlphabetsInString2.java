package javaExamples.interviewRecipes;

import java.util.Arrays;
import java.util.Scanner;

//Program to find Missing Alphabets in String

public class MissingAlphabetsInString2 {

	private static Scanner scannerObj;

	public static void main(String args[]) {

		String finalString = "";

		boolean[] alphabetPresent = new boolean[26];

		Arrays.fill(alphabetPresent, Boolean.FALSE);

		scannerObj = new Scanner(System.in);

		System.out.println("Please provide sentence");

		String inputString = scannerObj.nextLine();

		inputString = inputString.replace(" ", "");

		inputString = inputString.toLowerCase();

		char[] charArray = inputString.toCharArray();

		for (int i = 0; i < charArray.length; i++) {

			if (charArray[i] >= 'a' & charArray[i] <= 'z') {

				int position = charArray[i] - 'a';

				alphabetPresent[position] = Boolean.TRUE;

			}

		}

		for (int a = 0; a < alphabetPresent.length; a++) {

			if (alphabetPresent[a] == Boolean.FALSE) {

				finalString = finalString + (char) (a + 'a');
			}

		}

		if (finalString.length() > 0) {

			System.out.println("Characters Missing : " + finalString);

		}

		else {

			System.out.println("There are no missing characters. String is Pangram");

		}

	}

}