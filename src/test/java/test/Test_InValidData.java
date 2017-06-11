package test;


import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import task.ParmResponse;

public class Test_InValidData {

	static String USER_AGENT = "Mozilla 5.0";
	int k;

	@BeforeTest
	public void btValue() {
		k = 102;
	}

	@Test
	public void testid_InValidInput() throws Exception {
		ParmResponse pr = new ParmResponse();
		int response = pr.PrmResponse(k, USER_AGENT);
		Assert.assertEquals(404, response);
	}
	

}
