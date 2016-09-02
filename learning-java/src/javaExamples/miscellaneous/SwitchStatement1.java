package javaExamples.miscellaneous;

public class SwitchStatement1 {

	public static void main(String a[]) {
		int price = 6;
		switch (price) {
		case 2:
			System.out.println("It is: 2");
		default:
			System.out.println("It is: default");
		case 5:
			System.out.println("It is: 5");
		case 9:
			System.out.println("It is: 9");
		}
	}
}