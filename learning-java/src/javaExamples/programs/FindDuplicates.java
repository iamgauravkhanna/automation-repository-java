package javaExamples.programs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// Program to find duplicate elements in an array and print them

public class FindDuplicates {

	public static void main(String[] args) {

		ArrayList<String> list = new ArrayList<String>();

		// Form a list of numbers from 0-9.
		for (int i = 0; i < 19; i++) {
			list.add(String.valueOf(i));
		}

		// Insert a new set of numbers from 0-5.
		for (int i = 0; i < 10; i += 2) {
			list.add(String.valueOf(i));
		}

		System.out.println("Input list : " + list);
		System.out.println("\nFiltered duplicates : " + processList(list));
	}

	public static Set<String> processList(List<String> listContainingDuplicates) {

		final Set<String> resultSet = new HashSet<String>();
		final Set<String> tempSet = new HashSet<String>();

		for (String yourInt : listContainingDuplicates) {
			if (!tempSet.add(yourInt)) {
				resultSet.add(yourInt);
			}
		}
		return resultSet;
	}
}