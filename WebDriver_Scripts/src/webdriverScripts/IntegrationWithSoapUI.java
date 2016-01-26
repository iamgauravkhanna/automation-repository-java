/*********************************
 
Title  : Integration with SoapUI
Author : Gaurav Khanna

 *********************************//*

package webdriverScripts;

import org.testng.annotations.Test;
import com.eviware.soapui.tools.SoapUIMockServiceRunner;
import com.eviware.soapui.tools.SoapUITestCaseRunner;

public class IntegrationWithSoapUI {

	@Test
	public void testintegrationWithSoapUI() throws Exception {

		//
		SoapUITestCaseRunner runner = new SoapUITestCaseRunner();

		//
		SoapUIMockServiceRunner mockServiceRunner = new SoapUIMockServiceRunner();

		//
		mockServiceRunner.setProjectFile("c://code//soap//soapui-project.xml");

		//
		mockServiceRunner.run();

		//
		runner.setProjectFile("c://code//soap//soapui-project.xml");

		//
		runner.run();

	}

}
*/