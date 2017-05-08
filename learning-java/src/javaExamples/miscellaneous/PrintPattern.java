package javaExamples.miscellaneous;

// Program to print patterns

public class PrintPattern {

	public void printPattern1() {

		for (int i = 1; i <= 10; i++) {

			for (int j = 1; j <= i; j++) {

				System.out.print("*");

			}

			System.out.println("");
		}

	}

	public void printPattern2() {

		int p = 1;

		for (int i = 1; i <= 5; i++) {

			for (int j = 1; j <= p; j++) {

				System.out.print("*");

			}

			System.out.println("");

			p = p + 2;
		}

	}

	public void printPattern3() {

		for (int i = 1; i <= 10; i++) {

			for (int j = 1; j <= i; j++) {

				System.out.print(j);

			}

			System.out.println("");
		}

	}

	public void printPattern4() {

		int p = 1;

		for (int i = 1; i <= 5; i++) {

			for (int j = 1; j <= p; j++) {

				System.out.print(j);

			}

			System.out.println("");

			p = p + 2;
		}

	}

	public void printPattern5() {

		char start = 'a' - 1;

		for (int i = 1; i <= 5; i++) {

			for (int j = 1; j <= i; j++) {

				System.out.print((char) (start + j));

			}

			System.out.println("");

		}

	}

	public void printPattern6() {

		int p = 1;

		char start = 'a' - 1;

		for (int i = 1; i <= 5; i++) {

			for (int j = 1; j <= p; j++) {

				System.out.print((char) (start + j));

			}

			System.out.println("");

			p = p + 2;
		}

	}

	public static void main(String args[]) {

		//
		PrintPattern obj = new PrintPattern();

		//
		obj.printPattern1();

		//
		obj.printPattern2();

		//
		obj.printPattern3();

		//
		obj.printPattern4();

		//
		obj.printPattern5();

		//
		obj.printPattern6();

	}
}
