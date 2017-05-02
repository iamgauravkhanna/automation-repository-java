package javaExamples.collections;

import java.util.Scanner;

public class HashTableTest

{

	public static void main(String[] args)

	{

		Scanner scan = new Scanner(System.in);

		System.out.println("Hash Table Test\n\n");

		System.out.println("Enter size");

		/** Make object of HashTable **/

		HashTable ht = new HashTable(scan.nextInt());

		char ch;

		/** Perform HashTable operations **/

		do

		{

			System.out.println("\nHash Table Operations\n");

			System.out.println("1. insert ");

			System.out.println("2. remove");

			System.out.println("3. contains");

			System.out.println("4. clear");

			int choice = scan.nextInt();

			switch (choice)

			{

			case 1:

				System.out.println("Enter integer element to insert");

				ht.insert(scan.nextInt());

				break;

			case 2:

				System.out.println("Enter integer element to delete");

				ht.delete(scan.nextInt());

				break;

			case 3:

				System.out.println("Enter integer element to check if present");

				System.out.println("Contains : " + ht.contains(scan.nextInt()));

				break;

			case 4:

				ht.clear();

				System.out.println("Hash Table Cleared\n");

				break;

			default:

				System.out.println("Wrong Entry \n ");

				break;

			}

			/** Display hash table **/

			ht.printTable();

			System.out.println("\nDo you want to continue (Type y or n) \n");

			ch = scan.next().charAt(0);

		} while (ch == 'Y' || ch == 'y');

	}

}