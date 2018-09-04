package javaExamples.interviewRecipes;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

// Program to find Missing Alphabets in String

public class MissingAlphabetsInString {

	public static void main(String args[]) {

		Scanner scannerObj = new Scanner(System.in);

		System.out.println("Please Enter String");

		String inputString = scannerObj.nextLine();

		scannerObj.close();

		System.out.println("String Entered => " + inputString);

		inputString = inputString.replaceAll(" ", "");

		System.out.println("String After Trimming Space => " + inputString);

		String[] inputStringArray = inputString.split("");

		String[] alphabetArrayObj = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".split("");

		HashSet<String> inputStringSetObj = new HashSet<String>(Arrays.asList(inputStringArray));

		HashSet<String> alphabetSetObj = new HashSet<String>(Arrays.asList(alphabetArrayObj));

		System.out.println("Value of inputStringSet => " + inputStringSetObj);

		System.out.println("Value of alphabetSet => " + alphabetSetObj);

		alphabetSetObj.removeAll(inputStringSetObj);

		System.out.println("Missing Characters => " + alphabetSetObj);

	}

}
