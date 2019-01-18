package javaExamples.interviewRecipes;

public class OccurenceOfCharacters {

	// 65 - 90 and 97 - 122

	public static void main(String args[]) {

		String inputString = "Gaurav Kumar Khanna";

		// Create an array of size 256 i.e. ASCII_SIZE
		int count[] = new int[52];

		int len = inputString.length();

		// Initialize count array index
		for (int i = 0; i < len; i++) {

			if (inputString.charAt(i) >= 'A' && inputString.charAt(i) <= 'Z') {

				count[inputString.charAt(i) - 'A']++;

			} else if (inputString.charAt(i) >= 'a' && inputString.charAt(i) <= 'z') {

				count[(inputString.charAt(i) - 'a') + 26]++;
			}

		}

		for (int i = 0; i < 52; i++) {

			// System.out.println(i + " == " + count[i]);

			if (count[i] > 0) {

				if (i >= 0 && i < 26) {

					System.out.println("Number of Occurrence of " + (char) (i + 65) + " is:" + count[i]);

				} else if (i > 25 && i < 52) {

					System.out.println("Number of Occurrence of " + (char) (i + 71) + " is:" + count[i]);
				}
			}

			else {

				System.out.println("Missing characters are: ");

				if (i >= 0 && i < 26) {

					System.out.println((char) (i + 65));

				}

				else if (i > 25 && i < 52) {

					System.out.println((char) (i + 71));
				}

			}

		}

	}

}