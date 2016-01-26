package testNG;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Sample {

	@Test(groups = "Car")
	public void BMW() {
		System.out.println("Method : BMW");
	}

	@Test(groups = "Car")
	public void Maruti() {
		System.out.println("Method : Maruti");
	}

	@Test(groups = "Bike")
	public void Bajaj() {
		System.out.println("Method : Bajaj");
	}

	@Test(groups = "Bike")
	public void Hero() {
		System.out.println("Method : Hero");
	}

	@Test(groups = "Colours")
	public void Blue() {
		System.out.println("Method : Blue");
	}

	@Test(groups = "Colours")
	public void Red() {
		System.out.println("Method : Red");
	}

	@Parameters({ "name" })
	@Test
	public void NameTest(String firstName) {
		System.out.println("Name Provided is : " + firstName);
		assert "Gaurav".equals(firstName);
	}

}
