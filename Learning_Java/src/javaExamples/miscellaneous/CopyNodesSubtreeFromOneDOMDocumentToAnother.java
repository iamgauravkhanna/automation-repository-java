package javaExamples.miscellaneous;

import java.io.File;
import java.io.FileInputStream;
import java.io.StringWriter;
import java.io.Writer;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class CopyNodesSubtreeFromOneDOMDocumentToAnother {
	
	public static void main(String[] args) throws Exception {
		
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		dbf.setValidating(false);
		DocumentBuilder db = dbf.newDocumentBuilder();
		
		Document doc1 = db.parse(new FileInputStream(new File("C:\\Selenium\\files\\file1.xml")));
		Document doc2 = db.parse(new FileInputStream(new File("C:\\Selenium\\files\\file2.xml")));
		
		System.out.println("Before Copy...");
		prettyPrint(doc2);
		
		NodeList list = doc1.getElementsByTagName("wig:EnrollmentTxn");
		Element element = (Element) list.item(0);

		// Imports a node from another document to this document, without altering 
	    // or removing the source node from the original document
		Node copiedNode = doc2.importNode(element, true);

		// Adds the node to the end of the list of children of this node
		doc2.getDocumentElement().appendChild(copiedNode);
		
		System.out.println("After Copy...");
		prettyPrint(doc2);
		
	}
	
	public static final void prettyPrint(Document xml) throws Exception {
		Transformer tf = TransformerFactory.newInstance().newTransformer();
		tf.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
		tf.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
		tf.setOutputProperty(OutputKeys.INDENT, "yes");
		Writer out = new StringWriter();
		tf.transform(new DOMSource(xml), new StreamResult(out));
		System.out.println(out.toString());
	}

}