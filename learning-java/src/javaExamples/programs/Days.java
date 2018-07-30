package javaExamples.programs;

// Program to convert given number of days into months and days

class Days {

	public static void main(String args[]) {

		int n, m, d;
		n = 365;

		m = n / 30;
		d = n % 30;

		System.out.println(n + " days" + " = " + m + " months " + "and " + d + " days");
	}
}