package pageObject.project09;

import org.openqa.selenium.By;

import io.appium.java_client.android.AndroidDriver;
import utils.MobilePage;

public class HomeActivity extends MobilePage {

	AndroidDriver<?> androidDriverObj;

	private static By Digit2 = By.name("2");
	private static By Digit4 = By.name("4");
	private static By SymbolPlus = By.name("+");
	private static By SymbolEqualsTo = By.name("=");
	private static By Result = By.className("android.widget.EditText");

	public HomeActivity(AndroidDriver<?> driver) {

		super(driver);
	}

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
