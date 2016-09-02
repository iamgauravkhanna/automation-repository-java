package javaExamples.loops;

public class Break_Loop {
	public static void main(String[] args) {

		// This will print -- 0,1,2,3,4,5
		for (int Count = 0; Count <= 10; Count++) {
			if (Count == 6) {
				break;
			}
			System.out.println("Count is ==> " + Count);
		}
		System.out.println("You have exited the loop");
	}
}