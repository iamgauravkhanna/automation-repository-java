package raftaar.testautomation.utlities;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.apache.commons.io.FileUtils;
import org.apache.xml.serializer.OutputPropertiesFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLReader;

/**
 * This class contains all utility methods related to xml handling
 * 
 * @author anonymous
 */
public class XmlUtils {
	/**
	 * Stub to creating an xml document starting with specified root node name
	 * 
	 * @param rootNode
	 *            name of the root node
	 * @return root element
	 * @throws Exception
	 */
	public static Element createXmlDocument(String rootNode) throws Exception {
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

		// root elements
		Document doc = docBuilder.newDocument();
		Element rootElement = doc.createElement(rootNode);
		doc.appendChild(rootElement);

		return rootElement;
	}

	/**
	 * Writes an xml document to a text file on disk
	 * 
	 * @param xmlDoc
	 *            xml document object to be written to disk
	 * @return xml file which was written
	 * @throws Exception
	 */
	public static File writeXmltoFile(Document xmlDoc) throws Exception {
		File out = File.createTempFile("out", ".xml");
		return writeXmltoFile(out, xmlDoc, true);
	}

	/**
	 * Writes an xml document to a known file on disk
	 * 
	 * @param outFile
	 *            {@link File} file to which xml will be written to
	 * @param xmlDoc
	 *            {@link Document} document representing xml
	 * @return {@link File} file containing xml
	 * @throws Exception
	 */
	public static File writeXmltoFile(File outFile, Document xmlDoc, boolean indent) throws Exception {
		TransformerFactory transformerFactory = TransformerFactory.newInstance();

		Transformer transformer = transformerFactory.newTransformer();
		transformer.setOutputProperty(OutputKeys.METHOD, "xml");

		if (indent) {
			transformer.setOutputProperty(OutputPropertiesFactory.S_KEY_INDENT_AMOUNT, "2");
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		}

		DOMSource source = new DOMSource(xmlDoc);
		// StreamResult result = new StreamResult(outFile);

		StringWriter writer = new StringWriter();
		transformer.transform(source, new StreamResult(writer));
		// String output = writer.toString();

		FileUtils.write(outFile, writer.toString(), "UTF-8");
		return outFile;
	}

	public static File writeXmltoFile(File outFile, Document xmlDoc) throws Exception {
		return writeXmltoFile(outFile, xmlDoc, true);
	}

	/**
	 * Finds elements in an xml document against a given xpath
	 * 
	 * @param xpathString
	 *            xpath based on which elements needs to be located
	 * @param filename
	 *            location of the xml file containing xml data
	 * @return List of elements found based on given xpath
	 * @throws Exception
	 */
	public static NodeList findXmlElementsByXPath(String xpathString, String filename) throws Exception {
		DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance();
		domFactory.setNamespaceAware(true);

		domFactory.setValidating(false);
		domFactory.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);

		DocumentBuilder builder;

		builder = domFactory.newDocumentBuilder();

		InputSource inputSource = new InputSource();
		inputSource.setEncoding("UTF-8");
		inputSource.setCharacterStream(new StringReader(FileUtils.readFileToString(new File(filename), "UTF-8")));
		NodeList nodes = null;
		try {
			Document doc = builder.parse(inputSource);

			XPathFactory factory = XPathFactory.newInstance();
			XPath xpath = factory.newXPath();

			XPathExpression expr = xpath.compile(xpathString);
			Object result = expr.evaluate(doc, XPathConstants.NODESET);
			nodes = (NodeList) result;
		} catch (Exception e) {
			throw e;
		} finally {
		}

		return nodes;
	}

	/**
	 * find and returns all the elements which contains specific attribute
	 * irrespective of its value
	 * 
	 * @param name
	 *            node name of the attribute such as "name", "id"
	 * @param filename
	 *            location of the file contain xml data
	 * @return list of all elements found with specified attribute
	 * @throws Exception
	 */
	public static ArrayList<Element> findElementsByAttribute(String name, String filename) throws Exception {
		NodeList nodelist = null;
		ArrayList<Element> allElements = new ArrayList<>();
		String xpath = "//*[@" + name + "]";
		nodelist = findXmlElementsByXPath(xpath, filename);
		for (int i = 0; i < nodelist.getLength(); i++)
			allElements.add((Element) nodelist.item(i));
		return allElements;
	}

	/**
	 * Finds element with a specific value of an attribute
	 * 
	 * @param name
	 *            node name of the attribute such as "name"
	 * @param value
	 *            value of the attribute based on which lookup is performed
	 * @param filename
	 *            location of the file contain xml data
	 * @return first matching element
	 * @throws Exception
	 */
	public static Element findElementByAttribute(String name, String value, String filename) throws Exception {
		Element element = null;

		// This special xpath ignore multiple whitespace and makes xpath case
		// insensitive
		String xpath = "//*[(translate(@" + name
				+ ", 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'))=(translate('" + value
				+ "', 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'))]";

		element = (Element) findXmlElementsByXPath(xpath, filename).item(0);
		return element;
	}

	/**
	 * Validates an XML file against XML schema
	 * 
	 * @param xsdPath
	 *            XML schema file path against which XML to be validated
	 * @param xmlPath
	 *            XML file path to be validated against schema
	 * @return true if XML file is successfully validated against schema or
	 *         false otherwise
	 * @throws SAXException
	 * @throws IOException
	 * @throws XMLStreamException
	 */
	public static boolean validateXMLSchema(File xsd, File xml)
			throws SAXException, IOException, XMLStreamException, Exception {
		Reader xmlFile = new FileReader(xml);
		try {
			/*
			 * SchemaFactory factory =
			 * SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
			 * Schema schema = factory.newSchema(xsd); Validator validator =
			 * schema.newValidator();
			 * 
			 * //validator.validate(new StreamSource(xmlFile));
			 * 
			 * XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
			 * XMLStreamReader xmlStreamReader =
			 * xmlInputFactory.createXMLStreamReader(new FileInputStream(xml));
			 * validator.validate(new StAXSource(xmlStreamReader));
			 */

			SAXParserFactory factory = SAXParserFactory.newInstance();
			factory.setValidating(true);
			factory.setNamespaceAware(true);

			SAXParser parser = factory.newSAXParser();

			parser.setProperty("http://java.sun.com/xml/jaxp/properties/schemaLanguage",
					"http://www.w3.org/2001/XMLSchema");
			parser.setProperty("http://java.sun.com/xml/jaxp/properties/schemaSource",
					"file:" + xsd.getCanonicalPath());

			XMLReader reader = parser.getXMLReader();
			reader.setErrorHandler(new ErrorHandler() {

				@Override
				public void warning(SAXParseException arg0) throws SAXException {
					throw arg0;
				}

				@Override
				public void fatalError(SAXParseException arg0) throws SAXException {
					throw arg0;
				}

				@Override
				public void error(SAXParseException arg0) throws SAXException {
					throw arg0;
				}
			});
			reader.parse(new InputSource(new FileReader(xml)));

		} catch (Exception e) {
			throw e;
		} finally {
			xmlFile.close();
		}
		return true;
	}

	/**
	 * Format xml contents to nice readable xml structure
	 * 
	 * @param xmlFile
	 *            {@link File} file contains xml contents. Same file will be
	 *            overwritten.
	 */
	public static void formatXml(File xmlFile, boolean indent) {
		try {
			List<String> xmlLines = FileUtils.readLines(xmlFile);
			String xmlText = "";
			for (int i = 0; i < xmlLines.size(); i++) {
				if (!xmlLines.get(i).isEmpty())
					xmlText = xmlText + xmlLines.get(i).trim();
			}

			xmlText = xmlText.trim();

			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			InputSource is = new InputSource(new StringReader(xmlText));
			// is.setEncoding("UTF-16");
			Document document = db.parse(is);

			writeXmltoFile(xmlFile, document, indent);
		} catch (Exception e) {
		}
	}

	public static void splitXml(String xmlFile, String xpath) {
		try {
			NodeList nodes = XmlUtils.findXmlElementsByXPath(
					"//*[local-name()='ExchangeSubscriberID'][text()='732807312']/../..", xmlFile);// nodes.getLength();
			Element rootNode = XmlUtils.createXmlDocument("root");
			rootNode.appendChild(rootNode.getOwnerDocument().adoptNode(nodes.item(0).cloneNode(true)));
			System.out.println(XmlUtils.writeXmltoFile(rootNode.getOwnerDocument()));
		} catch (Exception e) {
		}

	}

	public static void updateAttributeValue(File xmlFile, String xpathForNodes, String attrName, String attrValue)
			throws Exception {
		NodeList nodes = findXmlElementsByXPath(xpathForNodes, xmlFile.getAbsolutePath());
		for (int i = 0; i < nodes.getLength(); i++) {
			nodes.item(i).getAttributes().getNamedItem(attrName).setNodeValue(attrValue);
		}

		if (nodes.getLength() > 0)
			writeXmltoFile(xmlFile, nodes.item(0).getOwnerDocument());
	}

	public static void updateNodeText(File xmlFile, String xpathForNodes, String nodeText) throws Exception {
		NodeList nodes = findXmlElementsByXPath(xpathForNodes, xmlFile.getAbsolutePath());
		boolean replaced = false;
		for (int i = 0; i < nodes.getLength(); i++) {
			// Replace only if there is a direct and only text node inside the
			// element
			// When there is only one child (which is text node), replace
			if (nodes.item(i).getChildNodes().getLength() <= 1) {
				replaced = true;
				nodes.item(i).setTextContent(nodeText);
			}
		}

		if (replaced)
			writeXmltoFile(xmlFile, nodes.item(0).getOwnerDocument());
	}

	public static void deleteNode(File xmlFile, String xpathForNodes) throws Exception {
		NodeList nodes = findXmlElementsByXPath(xpathForNodes, xmlFile.getAbsolutePath());
		Node parentNode = null;
		for (int i = 0; i < nodes.getLength(); i++) {
			parentNode = nodes.item(i).getParentNode();
			nodes.item(i).getParentNode().removeChild(nodes.item(i));
		}

		if (parentNode != null)
			writeXmltoFile(xmlFile, parentNode.getOwnerDocument());
	}

	public static String readParameters() throws ParserConfigurationException, SAXException, IOException {
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		
		DocumentBuilder builder = factory.newDocumentBuilder();

		String xmlPath = System.getProperty("user.dir") + "\\assets\\parameters.xml";
		
		if(xmlPath.isEmpty())
		{
			System.out.println("File Not Found");
		}
		
		Document document = builder.parse(new File(xmlPath));
		
		Element rootElement = document.getDocumentElement();
		
		System.out.println("Root Element Is : " + rootElement);
		
		NodeList list = rootElement.getElementsByTagName("parameter");
		
		System.out.println(list);
		
		for (int temp = 0; temp < list.getLength(); temp++) {
			Node nNode = list.item(temp);
			
			System.out.println("Node Is : " + nNode);
			
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) nNode;
				System.out.print("Name : ");
				System.out.println(eElement.getAttribute("name"));
			}
		}
		return xmlPath;

	}
}