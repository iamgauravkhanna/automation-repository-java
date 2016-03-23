package testng.testNG;

import org.testng.annotations.Test;

public class IgnoreTest {

	@Test(enabled = true)
	public void IgnoreTest1() {
		System.out.println("Enable Test : True \n");
	}

	@Test(enabled = false)
	public void IgnoreTest2() {
		System.out.println("Enable Test : False");
	}

}
