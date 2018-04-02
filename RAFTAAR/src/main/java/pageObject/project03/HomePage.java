package pageObject.project03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.BasePage;
import utils.LogUtils;

public class HomePage extends BasePage {

	By homeFrontEndText = By.xpath("//*[contains(text(),'Front-End')]");

	By AdminLink = By.xpath("//*[contains(text(),'http://www.phptravels.net/admin')]");

	public HomePage(WebDriver driverObj) {

		webDriverObj = driverObj;

	}

	public void verifyHomeFrontEndPresent() {

		assertPresent(homeFrontEndText);

	}

	public void openBrowser() {
		
		LogUtils.info("Opening Browser");

		openBrowser("http://phptravels.com/demo/");

	}

	public void clickAdminLink() {

		click(AdminLink);

	}

	public void switchToAdminPage() {

		// switchToWindow("Administator Login");

	}

}
