package project99;

import org.testng.annotations.Test;

import utils.BaseWebServiceClass;

public class WebServicesKeywordsExample extends BaseWebServiceClass {

	@Test
	public void TC001() {

		verifyStatus("http://services.groupkt.com/state/get/USA/all", 200);

	}

}