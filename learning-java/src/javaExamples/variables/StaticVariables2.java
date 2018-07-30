package javaExamples.variables;

public class StaticVariables2 {

	public static void main(String args[]) {

		// accessing static variable without object
		StaticVariables1.salary = 99000.23;
		System.out.println(StaticVariables1.name + "'s average salary: " + StaticVariables1.salary);
	}

}