package webdriverScripts.others;

import java.io.*;
import java.net.*;

public class TestwebServiceFinal {

	public void getTemprature() throws MalformedURLException, IOException {

		// Code to make a web service HTTP request
		// System.out.println("---------I-N-S-I-D-E---getTemprature()-----------");
		String responseString = "";
		String outputString = "";
		String wsURL = "http://www.w3schools.com/webservices/tempconvert.asmx";

		URL url = new java.net.URL(wsURL);
		java.net.URLConnection connection = url.openConnection();
		HttpURLConnection httpConn = (HttpURLConnection) connection;
		ByteArrayOutputStream bout = new ByteArrayOutputStream();
		String xmlInput = "<soap:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" 				xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">\n"
				+ "<soap:Body>\n" + "<CelsiusToFahrenheit xmlns=\"http://www.w3schools.com/webservices/\">\n"
				+ "<Celsius>100</Celsius>\n" + "</CelsiusToFahrenheit>\n" + "</soap:Body>\n" + "</soap:Envelope>";
		System.out.println("Formatted SOAP Request : \n" + xmlInput);

		byte[] buffer = new byte[xmlInput.length()];
		buffer = xmlInput.getBytes();
		bout.write(buffer);
		byte[] b = bout.toByteArray();
		String SOAPAction = "http://www.w3schools.com/webservices/CelsiusToFahrenheit";

		// Set the appropriate HTTP parameters.
		httpConn.setRequestProperty("Content-Length", String.valueOf(b.length));
		httpConn.setRequestProperty("Content-Type", "text/xml; charset=utf-8");
		httpConn.setRequestProperty("SOAPAction", SOAPAction);
		httpConn.setRequestMethod("POST");
		httpConn.setDoOutput(true);
		httpConn.setDoInput(true);
		OutputStream out = httpConn.getOutputStream();

		// Write the content of the request to the output stream of the HTTP
		// Connection.
		out.write(b);
		out.close();
		// Ready with sending the request.
		// Read the response.
		InputStreamReader isr = new InputStreamReader(httpConn.getInputStream());
		BufferedReader in = new BufferedReader(isr);

		// Write the SOAP message response to a String.
		while ((responseString = in.readLine()) != null) {
			outputString = outputString + responseString;
		}

		// System.out.println("SOAP Response :" + outputString);
		// System.out.println("\n\n\n");
		String[] size = null;
		String[] SoapAns = null;

		// Parsing Soap Response
		size = outputString.split("<CelsiusToFahrenheitResult>");
		// System.out.println("SOAP Response after split 1:" + size[0]);
		SoapAns = size[1].split("<");
		System.out.println("CelsiusToFahrenheitResult" + SoapAns[0]);
		// System.out.println("\n\n\n");

	} // End of getTemprature function
} // End of TestwebService class
