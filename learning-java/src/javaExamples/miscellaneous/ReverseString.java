package javaExamples.miscellaneous;

public class ReverseString {

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

	public static void main(String[] args) {

		ReverseString invertStr = new ReverseString();

		System.out.println("Reversed String with StringBuffer class: " + invertStr.invertWithStringBuffer("987654321"));

		System.out.println("");

		System.out.println(
				"Reversed String without StringBuffer class: " + invertStr.invertWithoutStringBuffer("kjihgfedcba"));
	}

}
