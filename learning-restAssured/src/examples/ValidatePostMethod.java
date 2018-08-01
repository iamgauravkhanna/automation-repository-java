package examples;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.json.simple.JSONObject;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ValidatePostMethod {

	@Test(enabled = true)
	public void validatePostMethod1() {

		RestAssured.baseURI = "http://restapi.demoqa.com/customer";

		RequestSpecification request = RestAssured.given();

		JSONObject requestParams = new JSONObject();

		// Defining values in JSON Object
		requestParams.put("FirstName", "Gaurav");
		requestParams.put("LastName", "Khanna");
		requestParams.put("UserName", "dummyUser45434");
		requestParams.put("Password", "password1");
		requestParams.put("Email", "dummyUser45654@fake.com");

		System.out.println("JSON String :" + requestParams.toJSONString());

		request.body(requestParams.toJSONString());

		Response response = request.post("/register");

		int statusCode = response.getStatusCode();

		System.out.println(response.getBody().asString());

		Assert.assertEquals(statusCode, 201);

		String successCode = response.jsonPath().get("SuccessCode");

		System.out.println("Success Code Value : " + successCode);

		Assert.assertEquals(successCode, "OPERATION_SUCCESS", "Correct Success code was not returned");

	}

	@Test(enabled = true)
	public void validatePostMethod2() throws IOException {

		String jsonFilePath = System.getProperty("user.dir") + "\\db_config.json";

		System.out.println("File Path : " + jsonFilePath);

		byte[] encoded = Files.readAllBytes(Paths.get(jsonFilePath));

		String myBody = new String(encoded, "UTF-8");

		System.out.println("Body Content " + myBody);

		RestAssured.baseURI = "http://restapi.demoqa.com/customer";

		RequestSpecification request = RestAssured.given();

		Response response = request.body(myBody).post("/register");

		System.out.println(response.getBody().asString());

	}

}