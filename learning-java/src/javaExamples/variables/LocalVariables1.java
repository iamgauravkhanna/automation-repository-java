package javaExamples.variables;

public class LocalVariables1 {

	public void StudentAge() {

		// local variable age
		int age = 0;

		age = age + 5;

		System.out.println("Student age is : " + age);
	}

	public static void main(String args[]) {

		LocalVariables1 obj = new LocalVariables1();

		obj.StudentAge();

	}

}