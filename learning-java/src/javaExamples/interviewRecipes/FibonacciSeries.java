package javaExamples.interviewRecipes;

// Program to print Fibonacci Series

public class FibonacciSeries {

	public static void main(String args[]) {

		// Create Object
		FibonacciSeries fibObj = new FibonacciSeries();

		// Call printFibSeries method
		fibObj.printFibSeries(25);
	}

	public void printFibSeries(int numberOfElements) {

		int a = 0;
		int b = 1;
		int c;

		for (int i = 1; i <= numberOfElements; i++) {

			// Check if we need to print 1st Number only
			if (i == 1)

				System.out.print(a + " ");

			// Check if we need to print 2nd Number only
			else if (i == 2)

				System.out.print(b + " ");

			// Print Nth Number
			else {
				c = a + b;
				System.out.print(c + " ");
				a = b;
				b = c;
			}

		}
	}

}
