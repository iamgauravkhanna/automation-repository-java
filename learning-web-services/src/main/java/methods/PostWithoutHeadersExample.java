package methods;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;

public class PostWithoutHeadersExample {

	public void doPostMethod(String url, String entityStringObj) throws ClientProtocolException, IOException {

		CloseableHttpClient closeableHttpClientObj = HttpClients.createDefault();

		HttpPost httpPostObj = new HttpPost(url);

		httpPostObj.setEntity(new StringEntity(entityStringObj));

		httpPostObj.addHeader("Content-Type", "application/json");

		CloseableHttpResponse closeableHttpResponseObj = closeableHttpClientObj.execute(httpPostObj);

		System.out.println("Status Code : " + closeableHttpResponseObj.getStatusLine().getStatusCode());

		String responseString = EntityUtils.toString(closeableHttpResponseObj.getEntity(), "UTF-8");
		
		JSONObject resonseJsonObj = new JSONObject(responseString) ;
		
		System.out.println("Response : " + resonseJsonObj);
	}

	@Test
	public void testGetApi() throws ClientProtocolException, IOException {

		PostWithoutHeadersExample restClientObj = new PostWithoutHeadersExample();

		JSONObject jsonObj = new JSONObject();

		jsonObj.put("name", "gaurav");

		jsonObj.put("job", "tester");

		String entityStringObj = jsonObj.toString();

		restClientObj.doPostMethod("https://reqres.in/api/users", entityStringObj);

	}

}