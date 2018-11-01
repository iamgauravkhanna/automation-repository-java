package methods;

import java.io.IOException;
import java.util.HashMap;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import utils.JsonUtil;

public class GetWithHeadersExample {

	public void doGetMethod(String url) throws ClientProtocolException, IOException {

		CloseableHttpClient closeableHttpClientObj = HttpClients.createDefault();

		HttpGet httpGetObj = new HttpGet(url); // HTTP Get Request
		
		httpGetObj.addHeader("isRestAPI", "Yes");

		CloseableHttpResponse closeableHttpResponseObj = closeableHttpClientObj.execute(httpGetObj); // Hit the GET Url

		int statusCode = closeableHttpResponseObj.getStatusLine().getStatusCode();

		System.out.println("Status Code : " + statusCode);
		
		Assert.assertEquals(statusCode, 200, "Status Code is not 200");

		String responseString = EntityUtils.toString(closeableHttpResponseObj.getEntity(), "UTF-8");

		JSONObject jsonObj = new JSONObject(responseString);

		System.out.println("API Response to JSON : " + jsonObj);
		
		String value = JsonUtil.getValueByJPath(jsonObj, "/per_page");
		
		System.out.println("Value => " + value);

		value = JsonUtil.getValueByJPath(jsonObj, "/data[0]/last_name");
		
		System.out.println("ArrayValue => " + value);

		
		Header[] headerArrayObj = closeableHttpResponseObj.getAllHeaders();

		HashMap<String, String> headerHashMapObj = new HashMap<String, String>();

		for (Header headerObj : headerArrayObj) {

			headerHashMapObj.put(headerObj.getName(), headerObj.getValue());
		}

		System.out.println("All Headers : " + headerHashMapObj);

	}

	@Test
	public void testGetApi() throws ClientProtocolException, IOException {

		GetWithHeadersExample restClientObj = new GetWithHeadersExample();

		restClientObj.doGetMethod("https://reqres.in/api/users?page=2");

	}

}