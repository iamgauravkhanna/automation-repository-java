package javaExamples.miscellaneous;

// Program to Reverse a string

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

	public void reverse(String str) {

		int i = str.length();
		StringBuffer strb = new StringBuffer();
		for (int j = i - 1; j >= 0; j--) {
			strb = strb.append(str.charAt(j));
		}
		System.out.println(strb);
	}

	public static void main(String[] args) {

		ReverseString invertStr = new ReverseString();

		System.out.println("Reversed String with StringBuffer class: " + invertStr.invertWithStringBuffer("987654321"));

		System.out.println("");

		System.out.println(
				"Reversed String without StringBuffer class: " + invertStr.invertWithoutStringBuffer("kjihgfedcba"));

		invertStr.reverse("I use selenium webdriver. selenium is a tool for web applications automation");
	}

}
