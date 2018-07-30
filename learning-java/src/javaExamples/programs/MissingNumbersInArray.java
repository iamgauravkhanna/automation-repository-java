package javaExamples.programs;

/**
 * Program to find Missing numbers between 1 to n
 * 
 * @author Gaurav.Khanna
 *
 */
public class MissingNumbersInArray {

	//
	static int arrayObj[] = { 1, 4, 7, 13, 22 };

	//
	public static void main(String args[]) {

		//
		int j = 0;

		//
		System.out.println("Missing Number : ");

		//
		for (int i = 1; i <= 50; i++) {

			//
			if (j < arrayObj.length && arrayObj[j] == i) {

				//
				j++;

			} else {

				//
				System.out.println(i + " ");
			}

		}

	}

}
