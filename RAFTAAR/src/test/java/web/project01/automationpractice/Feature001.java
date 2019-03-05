package web.project01.automationpractice;

import org.testng.annotations.Test;

import utils.BaseTest;
import utils.DataDictionary;
import web.project01.pageObject.Home;

/**
 * 
 * Test Scripts using POM Model
 * 
 */
public class Feature001 extends BaseTest {

	Home homePageObj;

	@Test
	public void TC_001() {

		homePageObj = new Home(webDriverObj);
		homePageObj.openHomePage();
		homePageObj.clickContactUs();

		DataDictionary.getInstance().getDataDictionary().put("TC_ID", "001");

	}

	@Test
	public void TC_002() {

		homePageObj = new Home(webDriverObj);
		homePageObj.openHomePage();
		homePageObj.clickContactUs();
		DataDictionary.getInstance().putKey("TC_ID", "002");

	}

	@Test
	public void TC_003() {

		homePageObj = new Home(webDriverObj);
		homePageObj.openHomePage();
		homePageObj.clickContactUs();
		DataDictionary.getInstance().getDataDictionary().put("TC_ID", "003");

	}

}