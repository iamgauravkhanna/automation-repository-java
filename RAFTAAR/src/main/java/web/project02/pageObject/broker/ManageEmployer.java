package web.project02.pageObject.broker;

import utils.BasePage;
import utils.BaseTest;
import utils.DataDictionary;
import utils.JavaUtil;
import web.project02.pageObject.uiMap.Broker;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ManageEmployer extends BasePage {

	public ManageEmployer(WebDriver driverObj) {

		webDriverObj = driverObj;

	}

	public void clickAddEmployer() {

		// waitForPageLoaded();

		// isClickable(ADD_EMPLOYER);

		isClickable(Broker.MANAGE_EMPLOYERS__ADD_EMPLOYER_BUTTON);

		// click(ADD_EMPLOYER);

		click(Broker.MANAGE_EMPLOYERS__ADD_EMPLOYER_BUTTON);

	}

	public void clickEnterManually() {

		// waitForPageLoaded();

		// click(ENTER_MANUALLY);

		click(Broker.MANAGE_EMPLOYERS_ENTER_MANUALLY_BUTTON);

	}

	public void filterEmployerByEIN() {

		waitForPageLoaded();

		waitFor(Broker.MANAGE_EMPLOYERS__SEARCH_BY, 30);

		click(Broker.MANAGE_EMPLOYERS__SEARCH_BY);

		click(Broker.MANAGE_EMPLOYERS__SEARCH_BY_EIN);

		click(Broker.MANAGE_EMPLOYERS__SEARCH_BY_TEXTBOX);

		setText(Broker.MANAGE_EMPLOYERS__SEARCH_BY_TEXTBOX,
				Long.valueOf(DataDictionary.getInstance().getDataDictionary().get("ein")).toString());

		click(Broker.MANAGE_EMPLOYERS__SEARCH_ICON);

		waitForPageLoaded();

	}

	public void clickOnEmployerName() {

		String xpathExpression = JavaUtil.replaceVariable("//span[text()='${companyname}']");

		click(By.xpath(xpathExpression));

	}

	public void waitForEmployerName() {

		String xpathExpression = JavaUtil.replaceVariable("//span[text()='${companyname}']");

		waitFor(By.xpath(xpathExpression));

	}

}
