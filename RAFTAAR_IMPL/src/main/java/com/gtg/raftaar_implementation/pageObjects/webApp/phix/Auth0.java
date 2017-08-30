package com.gtg.raftaar_implementation.pageObjects.webApp.phix;

import org.gtg.raftaar.utils.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Auth0 extends BasePage {

	public static final By LoginLink = null;

	public static final By USERNAME = By.name("emailId");

	public static final By PASSWORD = By.name("password");

	public static final By LOG_IN = By.xpath("//input[@value='Log In']");

	public Auth0(WebDriver driverObj) {
		
		webDriverObj = driverObj;
		
	}
	
	public void login(){
		
		click(Home.LOGIN_LINK);
		
		setText(USERNAME, "xxxx");

		setText(PASSWORD, "xxxx");

		click(LOG_IN);
		
	}
}