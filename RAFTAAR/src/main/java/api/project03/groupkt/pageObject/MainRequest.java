package api.project03.groupkt.pageObject;

import utils.BaseAPI;

public class MainRequest extends BaseAPI {

	// http://www.groupkt.com/post/c9b0ccb9/restful-webservices-to-get-and-search-countries.htm

	public void verify200ResponseCode() {

		verifyResponseCode("http://services.groupkt.co/", 200);

	}

}