package javaExamples.interviewRecipes;

import java.util.StringTokenizer;

public class RemoveExtraSpaces {

	public static void main(String args[]) {

		String inputString = "Try    to    remove   extra   spaces.";

		StringTokenizer subString = new StringTokenizer(inputString, " ");

		StringBuffer stringBufferObj = new StringBuffer();

		while (subString.hasMoreElements()) {

			stringBufferObj.append(subString.nextElement()).append(" ");

		}

		System.out.println("Actual string: " + inputString);

		System.out.println("Processed string: " + stringBufferObj.toString().trim());
	}
}