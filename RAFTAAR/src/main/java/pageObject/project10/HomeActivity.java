package pageObject.project10;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import utils.BaseActivity;
import utils.JavaUtils;
import utils.MobilePage;

public class HomeActivity extends BaseActivity {

	public HomeActivity(AndroidDriver<MobileElement> driverObj) {

		androidDriverObj = driverObj;
		
		JavaUtils.takeScreenShot(androidDriverObj);
	}

}