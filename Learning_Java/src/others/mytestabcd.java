package others;

import jetr.nsef.api.xmlgenner.XMLGennerSingleton;
import jetr.nsef.api.xmlgenner.XmlGenner;

public class mytestabcd {

	public static void main(String args[]) {

		try {
			XmlGenner x = XMLGennerSingleton.getXmlGenner();
			x.setCustomRows(1000);
			x.setSubRootElementName("TestCases");
			x.generateXML_Item("c:/gk/employee.xls", "c:/gk/out.xml");
		} catch (Exception ex) {
			// handler
		}
	}
}