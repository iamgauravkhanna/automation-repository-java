/**
 * 
 */
package javaExamples;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * @author shashank.upadhyay
 *
 */
public class XmlMerger {
	public static void main(String argv[]) {

		String filePath = "C:/Selenium/files/IndvEnrlWIGGeneration_validFileDirectoryPath";

		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = null;
		Document doc = null;
		NodeList fFileNodeList = null;

		File docFile = new File(filePath);
		File[] rootFiles = docFile.listFiles();
		try {

			int i = 0;

			for (File file : rootFiles) {

				if (file.isDirectory())
					continue;

				if (i == 0) {
					db = dbf.newDocumentBuilder();
					doc = db.parse(file);
					fFileNodeList = doc.getElementsByTagName("wig:EnrollmentTxn");
					i++;
					continue;
				}
				DocumentBuilder db2 = dbf.newDocumentBuilder();
				Document doc2 = db2.parse(file);

				NodeList secFileNodeList = doc2.getElementsByTagName("wig:EnrollmentTxn");

				for (int j = 0; j < secFileNodeList.getLength(); j++) {
					Node secNode = secFileNodeList.item(j);

					Node nodeArea = doc.importNode(secNode, true);
					fFileNodeList.item(0).getParentNode().appendChild(nodeArea);

				}

			}

			TransformerFactory tFactory = TransformerFactory.newInstance();
			Transformer transformer = tFactory.newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new StringWriter());
			transformer.transform(source, result);
			Writer output = new BufferedWriter(new FileWriter(filePath + "/testFinal.xml"));
			String xmlOutput = result.getWriter().toString();
			output.write(xmlOutput);
			output.close();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		}
	}
}