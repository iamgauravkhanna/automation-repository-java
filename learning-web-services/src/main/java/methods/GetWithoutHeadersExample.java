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

public class GetWithoutHeadersExample {

	public void doGetMethod(String url) throws ClientProtocolException, IOException {

		CloseableHttpClient closeableHttpClientObj = HttpClients.createDefault();

		HttpGet httpGetObj = new HttpGet(url); // HTTP Get Request

		CloseableHttpResponse closeableHttpResponseObj = closeableHttpClientObj.execute(httpGetObj); // Hit the GET Url

		int statusCode = closeableHttpResponseObj.getStatusLine().getStatusCode();

		System.out.println("Status Code : " + statusCode);

		String responseString = EntityUtils.toString(closeableHttpResponseObj.getEntity(), "UTF-8");

		JSONObject jsonObj = new JSONObject(responseString);

		System.out.println("API Response to JSON : " + jsonObj);

		Header[] headerArrayObj = closeableHttpResponseObj.getAllHeaders();

		HashMap<String, String> headerHashMapObj = new HashMap<String, String>();

		for (Header headerObj : headerArrayObj) {

			headerHashMapObj.put(headerObj.getName(), headerObj.getValue());
		}

		System.out.println("All Headers : " + headerHashMapObj);
		
	}

	public static void main(String[] args) throws ClientProtocolException, IOException {

		GetWithoutHeadersExample restClientObj = new GetWithoutHeadersExample();

		restClientObj.doGetMethod("https://reqres.in/api/users?page=2");

	}

}