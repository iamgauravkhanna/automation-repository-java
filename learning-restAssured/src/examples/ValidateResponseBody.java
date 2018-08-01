package examples;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class ValidateResponseBody {

	@Test
	public void validateResponseBody1() {

		// Specify the base URL to the RESTful web service
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";

		// Get the RequestSpecification of the request that you want to sent
		// to the server. The server is specified by the BaseURI that we have
		// specified in the above step.
		RequestSpecification httpRequest = RestAssured.given();

		// Make a request to the server by specifying the method Type and the method
		// URL.
		// This will return the Response from the server. Store the response in a
		// variable.
		Response response = httpRequest.request(Method.GET, "/Hyderabad");

		// Now let us print the body of the message to see what response
		// we have recieved from the server
		String responseBody = response.getBody().asString();

		System.out.println("Response Body is =>  " + responseBody);

	}

	@Test
	public void validateResponseBody2() {

		// Specify the base URL to the RESTful web service
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";

		String responseBody = RestAssured.given().when().get(RestAssured.baseURI + "/Hyderabad").getBody()
				.prettyPrint();

		System.out.println("");

		System.out.println("Response Body is =>  " + responseBody);

	}

	@Test
	public void validateResponseBody3() {
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.get("/Hyderabad");

		// Retrieve the body of the Response
		ResponseBody body = response.getBody();

		// To check for sub string presence get the Response body as a String.
		// Do a String.contains
		String bodyAsString = body.asString();
		Assert.assertEquals(bodyAsString.contains("Hyderabad") /* Expected value */, true /* Actual Value */,
				"Response body contains Hyderabad");
	}

	@Test
	public void validateResponseBody4() {
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.get("/Hyderabad");

		// Retrieve the body of the Response
		ResponseBody body = response.getBody();

		// To check for sub string presence get the Response body as a String.
		// Do a String.contains
		String bodyAsString = body.asString();

		// convert the body into lower case and then do a comparison to ignore casing.
		Assert.assertEquals(bodyAsString.toLowerCase().contains("hyderabad") /* Expected value */,
				true /* Actual Value */, "Response body contains Hyderabad");
	}

	@Test
	public void validateResponseBody5() {

		RestAssured.baseURI = "https://reqres.in/api";

		RequestSpecification httpRequest = RestAssured.given();

		Response response = httpRequest.get("/users");

		// Retrieve the body of the Response
		ResponseBody body = response.getBody();

		// To check for sub string presence get the Response body as a String.
		// Do a String.contains
		String bodyAsString = body.asString();

		System.out.println(bodyAsString);

	}

}