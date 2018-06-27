package pageObject.project10;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import utils.JavaUtils;
import utils.MobilePage;

public class HomeActivity extends MobilePage {

	public HomeActivity(AndroidDriver<MobileElement> driverObj) {

		androidDriverObj = driverObj;
		
		JavaUtils.takeScreenShot(androidDriverObj);
	}

}