package javaExamples.miscellaneous;

public class ThirdLargestNumber {

	static int a; // Largest
	static int b; //2nd Largest
	static int c; //3rd Largest
	static int arrayObj[] = { 5, 3, 7, 4, 35, 6, 33, 45, 65 };

	public static void main(String args[]) {

		for (int n : arrayObj) {

			if (a < n) {
				c = b;
				b = a;
				a = n;
			} else if (b < n) {
				c = b;
				b = n;
			} else if (c < n) {
				c = n;
			}
		}

		System.out.println("Third Largest Number :" + c);

	}

}
