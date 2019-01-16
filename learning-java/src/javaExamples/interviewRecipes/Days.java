package javaExamples.interviewRecipes;

import java.time.LocalDate;

// Program to convert given number of days into months and days

class Days {

	public static void main(String args[]) {

/*		int n, m, d;
		n = 360;

		m = n / 30;
		d = n % 30;

		System.out.println(n + " days" + " = " + m + " months " + "and " + d + " days");*/
		
		int day = 30 ;
		
		LocalDate.ofYearDay(day, 0);
		
	}
}