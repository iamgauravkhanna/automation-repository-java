package pageObject.project08;

import org.openqa.selenium.By;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import utils.MobilePage;

public class HomeActivity extends MobilePage {
	
	By seekBar = By.id("io.appium.android.apis:id/seek");

	public HomeActivity(AndroidDriver<AndroidElement> driverObj) {
		
		androidDriverObj = driverObj ; 
	}

	public void clickOption(String optionValue) {

		//clickUsingUIAutomator(optionValue);

	}

	public void clickViews() {

		//clickUsingUIAutomator("Views");

	}

	public void clickSeekBar() {

		//clickUsingUIAutomator("Seek Bar");

	}

	public void dragSeekBarToRight(int percantage) {

		//moveSeekBar(seekBar, percantage);

	}

}
