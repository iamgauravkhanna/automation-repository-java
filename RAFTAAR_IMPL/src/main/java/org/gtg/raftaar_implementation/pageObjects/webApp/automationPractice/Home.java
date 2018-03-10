package org.gtg.raftaar_implementation.pageObjects.webApp.automationPractice;

import org.gtg.raftaar.utils.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Home extends BasePage {

	public static final String HOME_URL = "http://automationpractice.com";

	public Home(WebDriver driverObj) {

		webDriverObj = driverObj;

	}

	public void openHomePage() {

		openBrowser(Home.HOME_URL);

	}

	public void clickContactUs() {

		click(By.xpath("//a[text()='Contact us']"));

	}

}