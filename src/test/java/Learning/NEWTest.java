package Learning;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NEWTest {
	
	int a=20,b;
	public void display() {
		NEWTest a3= new NEWTest();
		a3.a=50;
		System.out.println("a3 value is:"+a3);
		System.out.println("a value is:"+ a);
		System.out.println("a3 ref value is:"+ a3.a);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*NEWTest a1= new NEWTest();
		NEWTest a2 = new NEWTest();
		System.out.println("a1 value is:"+a1);
		System.out.println("a2 value is:"+a2);
		a1.a=10;
		a1.display();
		a2.display();*/
		/*System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");*/
		

	}

}
