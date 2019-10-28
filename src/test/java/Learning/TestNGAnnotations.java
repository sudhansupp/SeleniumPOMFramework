package Learning;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class TestNGAnnotations {
	
@BeforeMethod()	
	public void beforeMethod() {
	
	System.out.println(" Before Method will execute before every test method");
	
	}
	//@Parameters({ "SiteData", "DeviceData", "UserData"})
	@Test(priority = 2)	
	public void testMethod() {
		System.out.println("Inside test-----------");
		boolean x;
		int a=10,b=20;
		if(a==b) {
			x=true;
		}
		else
			x=false;
		Assert.assertFalse(x);
		System.out.println("Inside test");
		Assert.fail("test failed");
		System.out.println("Inside test2");
		
		}
	@Test
	public void testAethod1333() {
		
		System.out.println("Inside test13333");
		
		}
	@BeforeTest
	public void testAethod1() {
		
		System.out.println("Inside test1");
		
		}


}
