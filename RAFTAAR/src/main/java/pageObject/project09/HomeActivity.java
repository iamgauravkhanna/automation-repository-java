package pageObject.project09;

import org.openqa.selenium.By;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import utils.MobilePage;

public class HomeActivity extends MobilePage {

	public HomeActivity(AndroidDriver<MobileElement> driver) {

		androidDriverObj = driver;
	}

	private static By Digit2 = By.id("digit_2");
	private static By Digit4 = By.id("digit_4");
	private static By SymbolPlus = By.id("op_add");
	private static By SymbolEqualsTo = By.id("eq");
	private static By Result = By.id("result");

	public void clickDigit2() {

		clickSimple(Digit2);

	}

	public void clickDigit4() {

		clickSimple(Digit4);

	}

	public void clickSymbolPlus() {

		clickSimple(SymbolPlus);

	}

	public void clickEqualsTo() {

		clickSimple(SymbolEqualsTo);

	}

	public void printResult() {

		System.out.println("Result is : " + getText(Result));

	}

}
