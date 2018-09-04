package javaExamples.interviewRecipes;

import java.util.Scanner;

public class PerfectNumber {

	private static Scanner s;

	public static void main(String[] args) {

		int n, sum = 0;

		s = new Scanner(System.in);

		System.out.print("Enter any integer you want to check:");

		n = s.nextInt();

		for (int i = 1; i < n; i++) {

			if (n % i == 0) {

				sum = sum + i;

			}

		}

		if (sum == n) {

			System.out.println("Given number is Perfect");

		} else {

			System.out.println("Given number is not Perfect");

		}

	}

}