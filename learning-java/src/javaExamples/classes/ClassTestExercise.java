package javaExamples.classes;

public class ClassTestExercise {

	public static void main(String[] args) {
		// Use the Car keyword to declare Car Class variable
		Car Toyota = new Car();
		;

		Toyota.bLeftHandDrive = true;
		Toyota.iDoors = 4;
		Toyota.iGear = 5;
		Toyota.iHighestSpeed = 200;
		Toyota.iMake = 2014;
		Toyota.iTyres = 4;
		Toyota.sColor = "Black";
		Toyota.sTransmission = "Manual";
		Toyota.sModel = "Camry";

		// Using Car class method
		Toyota.DisplayCharacterstics();
	}
}