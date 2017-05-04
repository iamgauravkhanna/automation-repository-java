package javaExamples.miscellaneous;

// Program to swap two numbers without using temp variable

class SwapWithoutTempVariable {
	public static void main(String args[]) {
		int a, b;
		a = 4;
		b = 7;

		System.out.println("Before Swap : " + "a = " + a + " and b = " + b);

		a = a + b;
		b = a - b;
		a = a - b;

		System.out.println("After Swap : " + "a = " + a + " and b = " + b);
	}
}