package raftaar.testautomation.pageObjects.phpTravels;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import raftaar.testautomation.utils.WebPage;

public class DashBoardPage extends WebPage {

	By quickBookingButton = By.xpath("//button/div[contains(text(),' Quick Booking')]");

	public DashBoardPage(WebDriver driver) {
		super(driver);
	}

	public void validateHomeTiles() {

		super.assertPresent(quickBookingButton);

		super.clickSimple(quickBookingButton);

	}

}
