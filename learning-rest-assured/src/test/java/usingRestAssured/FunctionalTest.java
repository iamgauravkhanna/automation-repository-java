package usingRestAssured;

import org.testng.annotations.BeforeClass;

//import org.junit.BeforeClass;
//import org.junit.Test;

import com.jayway.restassured.RestAssured;

public class FunctionalTest {

	@BeforeClass
	public static void setup() {
		String port = System.getProperty("server.port");
		if (port == null) {
			RestAssured.port = Integer.valueOf(8080);
		} else {
			RestAssured.port = Integer.valueOf(port);
		}

		String basePath = System.getProperty("server.base");
		if (basePath == null) {
			basePath = "/external/rest/employee/upload";
		}
		RestAssured.basePath = basePath;

		String baseHost = System.getProperty("server.host");
		if (baseHost == null) {
			baseHost = "http://automation-api.phix-qa08.demo.hcinternal.net";
		}
		RestAssured.baseURI = baseHost;

	}

}
