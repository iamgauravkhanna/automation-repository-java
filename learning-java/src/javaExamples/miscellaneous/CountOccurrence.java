package javaExamples.miscellaneous;

import java.util.Scanner;

// Program to count occurence of element in array

public class CountOccurrence

{

	private static Scanner s;

	public static void main(String[] args)

	{

		int n, x, count = 0, i = 0;

		s = new Scanner(System.in);

		System.out.print("Enter no. of elements you want in array:");

		n = s.nextInt();

		int a[] = new int[n];

		System.out.println("Enter all the elements:");

		for (i = 0; i < n; i++)

		{

			a[i] = s.nextInt();

		}

		System.out.print("Enter the element of which you want to count number of occurrences:");

		x = s.nextInt();

		for (i = 0; i < n; i++)

		{

			if (a[i] == x)

			{

				count++;

			}

		}

		System.out.println("Number of Occurrence of the Element:" + count);

	}

}