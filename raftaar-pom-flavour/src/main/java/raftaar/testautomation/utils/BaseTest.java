package raftaar.testautomation.utils;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;

public class BaseTest {

	protected static WebDriver driver = null;

	protected BaseTest() {

		System.out.println("BaseTest Parent Constructor Called");
		
		PropertyConfigurator.configure("log4j.properties");

	}

}
