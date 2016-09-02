package javaExamples.operators;

public class Logical_Operators {

	public static void main(String[] args) {
		boolean Output_1 = true;
		boolean Output_2 = false;
		System.out.println("Check if both the boolean variables are true : " + (Output_1 && Output_2));
		System.out.println("Check if even one of the boolean varibale is true : " + (Output_1 || Output_2));
		System.out.println("Change the state of the Output_1 to false : " + (!Output_1));

	}

}