package javaExamples.strings;

public class StringTestExercise2 {

	public static void main(String[] args) {
		// Declaring the String Variables
		String sPopularTopic_1 = "Selenium Automation Framework";
		String sPopularTopic_2 = "Basic Java Tutorial";
		String sSpace = " ";

		// Print the value of Concat String
		// String1.concat(String2);
		System.out.println("First Output");
		System.out.println(sPopularTopic_1.concat(sPopularTopic_2));

		// Another way of using String Concat
		// "String1".concat(String2);
		System.out.println("Second Output");
		System.out.println("Selenium Automation Framework".concat(sPopularTopic_2));

		// Another way of using String Concat
		// "String1" + "String2";
		System.out.println("Third Output");
		System.out.println("Selenium Automation Framework" + "Basic Java Tutorial");

		// Another way of using String Concat
		// "String1" + String + "String2";
		System.out.println("Fourth Output");
		System.out.println("Selenium Automation Framework" + sSpace + "Basic Java Tutorial");

	}

}