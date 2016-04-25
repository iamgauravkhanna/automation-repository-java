package javaExamples.loops;

public class For_Loop {
	public static void main(String[] args) {
		// This will print -- 0,1,2,3,4,5
		for (int Increment = 0; Increment <= 5; Increment++) {
			System.out.println("Count is  ==> " + Increment);
		}

		System.out.println("<==== Next Count ====>");
		// This will print -- 5,4,3,2,1,0
		for (int Decrement = 5; Decrement >= 0; Decrement--) {
			System.out.println("Count is ==> " + Decrement);
		}

		System.out.println("<==== Next Count ====>");
		// This will print -- 0,2,4
		for (int Increment = 0; Increment <= 5; Increment += 2) {
			System.out.println("Skip every one another  ==> " + Increment);
		}
	}
}