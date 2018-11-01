package javaExamples.xml;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class XPathExample {
	
	// Reference : https://viralpatel.net/blogs/java-xml-xpath-tutorial-parse-xml/

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, XPathExpressionException {

		File inputFile = new File("inputFile.xml");

		DocumentBuilderFactory documentBuilderFactoryObj = DocumentBuilderFactory.newInstance();

		DocumentBuilder documentBuilderObj = documentBuilderFactoryObj.newDocumentBuilder();

		Document documentObj = documentBuilderObj.parse(inputFile);
		
		documentObj.getDocumentElement().normalize();
		
		XPath xpathObj = XPathFactory.newInstance().newXPath();
		
		
		// Example 1
		
		String xPathValue = "/class/student/firstname";
		
		NodeList nodeListObj = (NodeList)xpathObj.compile(xPathValue).evaluate(documentObj, XPathConstants.NODESET);
				
		for (int i = 0; i < nodeListObj.getLength(); i++) {
			
		    System.out.println(nodeListObj.item(i).getFirstChild().getNodeValue()); 
		
		}
		
		// Example 2
		
		String expression = "/class/student[@rollno='493']";
		
		Node node = (Node) xpathObj.compile(expression).evaluate(documentObj, XPathConstants.NODE);
		
		if(null != node) {
			
			nodeListObj = node.getChildNodes();
			
			for (int i = 0;null!=nodeListObj && i < nodeListObj.getLength(); i++) {
				
				Node nod = nodeListObj.item(i);
				if(nod.getNodeType() == Node.ELEMENT_NODE)
					
					System.out.println(nodeListObj.item(i).getNodeName() + " : " + nod.getFirstChild().getNodeValue()); 
			}
		}

	}

}
