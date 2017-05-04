package javaExamples.miscellaneous;

class PalindromeStringExample1 {

	public static void main(String args[]) {

		String original = "dazad";
		String reverse = "";

		int stringLength = original.length();

		for (int i = stringLength - 1; i >= 0; i--) {
			reverse = reverse + original.charAt(i);
		}

		if (original.equals(reverse)) {
			System.out.println("String " + original + " is Palindrome");
		} else {
			System.out.println("Oops !! String is not Palindrome");
		}

	}

}
