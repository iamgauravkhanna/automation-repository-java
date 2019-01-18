package javaExamples.interviewRecipes;

// Program to Reverse a string

public class ReverseAString {

	public String invertWithStringBuffer(String str) {

		StringBuffer buffer = new StringBuffer(str);
		buffer.reverse();
		return buffer.toString();
	}

	public String invertWithoutStringBuffer(String str) {

		int length = str.length();
		String original = str;
		String invert = "";
		for (int i = length - 1; i >= 0; i--) {
			invert = invert + original.charAt(i);
		}
		return invert;
	}

	public String reverse(String str) {

		int i = str.length();
		StringBuffer strb = new StringBuffer();
		for (int j = i - 1; j >= 0; j--) {
			strb.append(str.charAt(j));
		}

		return strb.toString();
	}

	public static void main(String[] args) {

		ReverseAString invertStr = new ReverseAString();

		System.out.println("Reversed String with StringBuffer class => "
				+ invertStr.invertWithStringBuffer("Gaurav Kumar Khanna"));

		System.out.println("Reversed String without StringBuffer class => "
				+ invertStr.invertWithoutStringBuffer("Gaurav Kumar Khanna"));

	}

}