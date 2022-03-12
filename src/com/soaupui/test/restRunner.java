package com.soaupui.test;
import com.eviware.soapui.impl.wsdl.WsdlProject;
import com.eviware.soapui.impl.wsdl.WsdlTestSuite;
import com.eviware.soapui.impl.wsdl.testcase.WsdlTestCase;
import com.eviware.soapui.model.support.PropertiesMap;
import com.eviware.soapui.model.testsuite.TestRunner;
import com.eviware.soapui.model.testsuite.TestRunner.Status;
import com.eviware.soapui.model.testsuite.TestSuite;
import com.eviware.soapui.support.SoapUIException;
import java.io.IOException;

import org.apache.xmlbeans.XmlException;
import org.junit.Assert;
import org.testng.annotations.Test;

public class restRunner {
	
	@Test
	public void SoapTest() throws XmlException, IOException, SoapUIException {
		//GIVEN
		WsdlProject project = new WsdlProject("C:\\Users\\JonasMaldonadoAyala\\Documents\\Soap course\\EmployeeJava-soapui-project.xml");
		WsdlTestSuite testsuite = project.getTestSuiteByName("TestSuite");
		
		for(int i=0; i<testsuite.getTestCaseCount();i++) {
			WsdlTestCase testCase = testsuite.getTestCaseAt(i);
			System.out.println(testCase.toString());
			TestRunner runner = testCase.run(new PropertiesMap(), false);	
			Assert.assertEquals(Status.FINISHED, runner.getStatus());
			
		}
		
		
	}

}
