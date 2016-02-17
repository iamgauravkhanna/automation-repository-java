package java.examples.set;

class FirstProgram {

	/*
	 * class keyword is used to declare a class in java.
	 * public keyword is an access modifier which represents visibility, it means it is visible to all.
	 * static is a keyword, if we declare any method as static, it is known as static method. The core advantage of static method is that there is no need to create object to invoke the static method. 
	 * The main method is executed by the JVM, so it doesn't require to create object to invoke the main method. So it saves memory.
	 *	void is the return type of the method, it means it doesn't return any value.
	 *	main represents startup of the program.
	 *String[] args is used for command line argument. We will learn it later.S
	 *System.out.println() is used print statement. We will learn about the internal working of System.out.println statement later.*/

	public static void main(String args[]) {
		
		System.out.println("First Java Program");
		
	}
}