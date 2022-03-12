package com.soaupui.test;
import java.io.IOException;
import java.util.Iterator;

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

public class MultipleTestCasesRunRest {
	
  @Test
  public void multipleRestTestCases() throws XmlException, IOException, SoapUIException {
	  WsdlProject project = new WsdlProject("C:\\Users\\JonasMaldonadoAyala\\Documents\\Soap course\\LibraryAPI.xml");
	  
	 for (int i = 0; i < project.getTestSuiteCount(); i++) {
		 WsdlTestSuite testSuite = project.getTestSuiteAt(i);
		 for (int j = 0; j < testSuite.getTestCaseCount(); j++) {
			WsdlTestCase testCase = testSuite.getTestCaseAt(j);
			
			TestRunner runner = testCase.run(new PropertiesMap(), false);
			Assert.assertEquals(Status.FINISHED,runner.getStatus());
		}
	}
	  
  }
}
