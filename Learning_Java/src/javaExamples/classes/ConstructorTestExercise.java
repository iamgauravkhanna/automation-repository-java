package javaExamples.classes;

public class ConstructorTestExercise {

	public static void main(String[] args) {
		// Use the Car keyword to declare Car Class variable
		// Passing values to the constructor
		Car Toyota = new Car("Camry", 2014, true);

		Toyota.iDoors = 4;
		Toyota.iGear = 5;
		Toyota.iHighestSpeed = 200;
		Toyota.iTyres = 4;
		Toyota.sColor = "Black";
		Toyota.sTransmission = "Manual";

		// Using Car class method
		Toyota.DisplayCharacterstics();

	}

}
