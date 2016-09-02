package xmlExamples;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ReadFromXml {

	public static void main(String args[]) {

		try {

			File inputFile = new File(System.getProperty("user.dir") + "\\assets\\Environment.xml");

			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();

			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

			Document doc = dBuilder.parse(inputFile);

			doc.getDocumentElement().normalize();

			XPath xPath = XPathFactory.newInstance().newXPath();

			String expression = "/environments/environment";

			NodeList nodeList = (NodeList) xPath.compile(expression).evaluate(doc, XPathConstants.NODESET);

			for (int i = 0; i < nodeList.getLength(); i++) {

				Node nNode = nodeList.item(i);

				System.out.println("\nCurrent Element :" + nNode.getNodeName());

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) nNode;

					if (eElement.getAttribute("name").equalsIgnoreCase("common"))
						break;

					System.out.println("environment : " + eElement.getAttribute("name"));

					System.out.println("host : " + eElement.getElementsByTagName("host").item(0).getTextContent());

					System.out.println(
							"WicSftpUrl : " + eElement.getElementsByTagName("WicSftpUrl").item(0).getTextContent());

					System.out.println(
							"serverName : " + eElement.getElementsByTagName("serverName").item(0).getTextContent());

					System.out.println(
							"dbDetails : " + eElement.getElementsByTagName("dbDetails").item(0).getTextContent());

				}
			}
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (XPathExpressionException e) {
			e.printStackTrace();
		}

	}

}
