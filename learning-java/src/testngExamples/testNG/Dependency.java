package testngExamples.testNG;

import org.testng.annotations.Test;

public class Dependency {

	@Test
	public void Alpha() {

		System.out.println("Method : Alpha");
	}

	@Test(dependsOnMethods = { "Alpha" })
	public void Beta() {

		System.out.println("Method : Beta");
	}

	@Test(dependsOnMethods = { "Beta" })
	public void Gamma() {

		System.out.println("Method : Gamma");
	}

}
