package org.gtg.raftaar_implementation.pageObjects.webApp.phix.employer;

import org.gtg.raftaar.utils.BasePage;
import org.openqa.selenium.WebDriver;

public class Home extends BasePage {

	public static final String EMPLOYER_URL = "https://phixtest1301.demo.hcinternal.net/employer/";

	public Home(WebDriver driverObj) {

		webDriverObj = driverObj;

	}

	public void openHomePage() {

		openBrowser(Home.EMPLOYER_URL);

	}

}