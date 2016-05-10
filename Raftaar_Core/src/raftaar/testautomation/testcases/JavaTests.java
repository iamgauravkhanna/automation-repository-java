package raftaar.testautomation.testcases;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.testng.annotations.Test;
import org.xml.sax.SAXException;

import raftaar.testautomation.utlities.XmlUtils;

public class JavaTests {

	XmlUtils xu = new XmlUtils();

	@Test
	public void testjavamethod() throws ParserConfigurationException, SAXException, IOException {

		XmlUtils.readParameters();
		
	}

}
