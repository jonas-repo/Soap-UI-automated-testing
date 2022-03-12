package com.soaupui.test;
import java.io.IOException;

import org.apache.xmlbeans.XmlException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.eviware.soapui.impl.wsdl.WsdlProject;
import com.eviware.soapui.impl.wsdl.WsdlTestSuite;
import com.eviware.soapui.impl.wsdl.testcase.WsdlTestCase;
import com.eviware.soapui.model.support.PropertiesMap;
import com.eviware.soapui.model.testsuite.TestRunner;
import com.eviware.soapui.model.testsuite.TestRunner.Status;
import com.eviware.soapui.support.SoapUIException;

public class OnlyOneTestCaseRun {
  
  @Test
  public void runningAddTestCase() throws XmlException, IOException, SoapUIException{
		//GIVEN
		WsdlProject project = new WsdlProject("C:\\Users\\JonasMaldonadoAyala\\Documents\\Soap course\\EmployeeJava-soapui-project.xml");
		WsdlTestSuite testsuite = project.getTestSuiteByName("TestSuite");
		WsdlTestCase testCase = testsuite.getTestCaseByName("addEmployee TestCase");
		
		//WHEN
		TestRunner runner = testCase.run(new PropertiesMap(), false);
		
		//THEN
		Assert.assertEquals(Status.FINISHED,runner.getStatus());
		
		
  }
}
