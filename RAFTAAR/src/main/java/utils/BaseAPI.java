package utils;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseAPI {

	public void verifyResponseCode(String URL, int responseCode) {

		RestAssured.baseURI = URL;

		RequestSpecification httpRequest = RestAssured.given();

		Response response = httpRequest.request(Method.GET, URL);

		int statusCode = response.getStatusCode();

		System.out.println("Response Code : " + statusCode);

		if (statusCode == responseCode) {

			System.out.println("Response Code is 200 OK");

		} else {

			System.out.println("Oops !! Response Code is not 200 Ok. It's is : " + statusCode);

		}

	}

}