package utils;

import io.restassured.RestAssured;

public class BaseWebServiceClass {

	public void verifyStatus(String BaseURI, int statusCode) {

		RestAssured.baseURI = BaseURI;

		if (RestAssured.given().expect().statusCode(statusCode).when().get(RestAssured.baseURI) != null) {

			System.out.println("Response Code is " + statusCode);
		} else {

			try {
				throw new Exception("Response Code " + statusCode + " not found");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

}