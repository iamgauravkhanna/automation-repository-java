package usingRestAssured;

import static com.jayway.restassured.RestAssured.given;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

//import org.junit.Test;

import org.testng.annotations.Test;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;

public class validatePOST extends FunctionalTest {

	String xmlBody;
	public static Response response;

	String readFile(String fileName) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		try {
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();

			while (line != null) {
				sb.append(line);
				sb.append("\n");
				line = br.readLine();
			}
			return sb.toString();
		} finally {
			br.close();
		}
	}

	@Test
	public void basicTest() throws IOException {

		xmlBody = readFile("C:\\selenium\\employee.xml");

		System.out.println(xmlBody);
		
		response = given().contentType("application/xml").body(xmlBody).when().post("/").then().contentType(ContentType.XML).extract().response();
		
		response.body().print();
	}
}
