package pageObject.project03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.BasePage;

public class DashBoardPage extends BasePage {

	By quickBookingButton = By.xpath("//button/div[contains(text(),' Quick Booking')]");

	public DashBoardPage(WebDriver driverObj) {

		webDriverObj = driverObj;

	}

	public void validateHomeTiles() {

		assertPresent(quickBookingButton);

		click(quickBookingButton);

	}

}