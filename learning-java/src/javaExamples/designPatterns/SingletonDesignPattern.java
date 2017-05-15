package javaExamples.designPatterns;

public class SingletonDesignPattern {

	private static SingletonDesignPattern myObj;

	static {
		myObj = new SingletonDesignPattern();
	}

	private SingletonDesignPattern() {

	}

	public static SingletonDesignPattern getInstance() {
		return myObj;
	}

	public void testMe() {
		System.out.println("Hey.... it is working!!!");
	}

	public static void main(String a[]) {

		//
		SingletonDesignPattern ms = getInstance();

		//
		ms.testMe();
	}
}