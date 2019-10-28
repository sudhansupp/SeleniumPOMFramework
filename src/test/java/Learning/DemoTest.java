package Learning;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DemoTest {

	String abc;
	//@Test(description = "1e", priority = 1)
	public void test1() {
		abc="sudhansu";
		System.out.println("abc in test1 is :"+abc);
	}
	@Test(description = "22", priority = 2)
	public void test2() {
		/*
		 * String value="sudhansu"; System.out.println("abc in test2 is :"+abc); String
		 * payloadData = "{\n" + "  \"asset_id\": \"dgfdfg\",\n" +
		 * "  \"appl_instance_name\": \"ghggdf\"\n" + "}";
		 * System.out.println("payload date is "+payloadData);
		 */
		/*
		 * boolean x=false; if(!x) { System.out.println("inside if block"); }
		 */
		boolean st=check();
		System.out.println("st value is : "+st);
	}
	public Boolean check() {
		boolean status;
		int x=2, y=3;
		if(x==y) {
			status=true;
			 Assert.assertTrue(status, "The IPSec router status is not coming up");
		}
		else {
			status =false;
		//	Assert.fail("failed the test");
		}
		System.out.println("returned value is "+status);
		return status;
	}
}
