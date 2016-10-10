package javaExamples.inheritance;

public class ClassB extends ClassA {

	public static void main(String args[]) {

		ClassA obj = new ClassA();

		ClassA.count = 199;

		obj.printCount();

	}

}
