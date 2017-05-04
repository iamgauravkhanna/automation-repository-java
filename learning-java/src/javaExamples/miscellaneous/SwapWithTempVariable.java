package javaExamples.miscellaneous;

// Program to swap two numbers

class SwapWithTempVariable {
	public static void main(String args[]) {
		int a, b, temp;
		a = Integer.parseInt("5");
		b = Integer.parseInt("7");

		System.out.println("nBefore Swap:n" + "a=" + a + "tb=" + b);

		temp = a;
		a = b;
		b = temp;

		System.out.println("nAfter Swap:n" + "a=" + a + "tb=" + b);
	}
}