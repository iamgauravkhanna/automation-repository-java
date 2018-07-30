package javaExamples.variables;

public class InstanceVariables2 {

	public static void main(String args[]) {

		// first object
		InstanceVariables1 obj1 = new InstanceVariables1();
		obj1.engMarks = 50;
		obj1.mathsMarks = 80;
		obj1.phyMarks = 90;

		// second object
		InstanceVariables1 obj2 = new InstanceVariables1();
		obj2.engMarks = 80;
		obj2.mathsMarks = 60;
		obj2.phyMarks = 85;

		// displaying marks for first object
		System.out.println("Marks for first object:");
		System.out.println(obj1.engMarks);
		System.out.println(obj1.mathsMarks);
		System.out.println(obj1.phyMarks);

		System.out.println();

		// displaying marks for second object
		System.out.println("Marks for second object:");
		System.out.println(obj2.engMarks);
		System.out.println(obj2.mathsMarks);
		System.out.println(obj2.phyMarks);
	}

}