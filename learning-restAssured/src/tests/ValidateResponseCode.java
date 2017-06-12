package tests;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class ValidateResponseCode {

	@Test
	public void validateResponseCode() {

		RestAssured.baseURI = "http://services.groupkt.com/state/get/USA/all";

		if (RestAssured.given().expect().statusCode(200).when().get(RestAssured.baseURI) != null)
			System.out.println("Response Code is 200 OK");

	}

}
