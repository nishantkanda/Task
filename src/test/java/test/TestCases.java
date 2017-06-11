package test;

import org.testng.annotations.Test;
import task.CmpResponse;

public class TestCases {
	static String USER_AGENT = "Mozilla 5.0";

	@Test
	public void testAll() throws Exception {
		CmpResponse cm = new CmpResponse();
		cm.cmpResp(USER_AGENT);
	}

}
