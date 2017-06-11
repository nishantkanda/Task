package test;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import task.ParmResponse;

public class Test_ValidData {
	static String USER_AGENT = "Mozilla 5.0";
	int k;

	@BeforeTest
	public void btValue() {
		k = 2;
	}

	@Test
	public void testid_ValidInput() throws Exception {
		ParmResponse pr = new ParmResponse();
		int response = pr.PrmResponse(k, USER_AGENT);
		Assert.assertEquals(200, response);
	}
}
