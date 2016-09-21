package usingRestAssured;

import static com.jayway.restassured.RestAssured.given;

//import org.junit.Test;

import org.testng.annotations.Test;

public class validateGET extends FunctionalTest {

	@Test
	public void basicTest() {
		given().when().get("/").then().statusCode(405);
	}
}
