package examples;

import org.testng.Assert;
import org.testng.annotations.Test;

import org.json.simple.JSONObject;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ValidatePostMethod {

	@Test
	public void validatePostMethod1() {

		RestAssured.baseURI = "http://restapi.demoqa.com/customer";

		RequestSpecification request = RestAssured.given();

		JSONObject requestParams = new JSONObject();

		requestParams.put("FirstName", "Gaurav");
		requestParams.put("LastName", "Khanna");
		requestParams.put("UserName", "dummyUser004");
		requestParams.put("Password", "password1");
		requestParams.put("Email", "dummyUser004@fake.com");

		request.body(requestParams.toJSONString());

		Response response = request.post("/register");

		int statusCode = response.getStatusCode();

		System.out.println(response.getBody().asString());

		Assert.assertEquals(statusCode, 201);

		String successCode = response.jsonPath().get("SuccessCode");

		System.out.println("Success Code Value : " + successCode);

		Assert.assertEquals(successCode, "OPERATION_SUCCESS", "Correct Success code was not returned");

	}

}