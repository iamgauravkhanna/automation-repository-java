package pageObject.project08;

import org.openqa.selenium.By;

import io.appium.java_client.android.AndroidDriver;
import utils.MobilePage;

public class MainActivity extends MobilePage {
	
	By seekBar = By.id("io.appium.android.apis:id/seek");

	public MainActivity(AndroidDriver<?> androidDriverObj) {
		super(androidDriverObj);
	}

	public void clickOption(String optionValue) {

		clickUsingUIAutomator(optionValue);

	}

	public void clickViews() {

		clickUsingUIAutomator("Views");

	}

	public void clickSeekBar() {

		clickUsingUIAutomator("Seek Bar");

	}

	public void dragSeekBarToRight(int percantage) {

		moveSeekBar(seekBar, percantage);

	}

}