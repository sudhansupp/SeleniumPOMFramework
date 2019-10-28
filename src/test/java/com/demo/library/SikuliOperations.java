package com.demo.library;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;
import org.sikuli.script.Screen;
import org.testng.Reporter;

public class SikuliOperations {
	static WiniumDriver driver1,driver2,driver3,driver4,driver5;
	static boolean flag1,flag2,flag3,flag4;
	public static String sikuliRepository=System.getProperty("user.dir") + "\\ObjectRepository\\SikuliObjects";
	
		
	public static boolean enterRDPPassword(String password){
		
		boolean flag=true;
		Screen s=new Screen();
		if(s.exists(sikuliRepository+"\\RDPIcon.PNG") != null){
			try{
				s.click(sikuliRepository+"\\RDPIcon.PNG");
				Thread.sleep(3000);
				try{
				s.click(sikuliRepository+"\\ConnectButton.PNG");
				Thread.sleep(3000);
				}
				
				catch (Exception e){
					Reporter.log("Connect Button is not present",true);
				}
				Thread.sleep(3000);
				s.type(sikuliRepository+"\\PasswordField.PNG",password);
				Thread.sleep(3000);
				s.click(sikuliRepository+"\\OkButton.PNG");
				//s.exists(repositoryLocation+"\\RDPIcon.PNG");
			}
			catch(Exception e2){
				Reporter.log("Something went Wrong!! RDP Password is not entered properly!!",true);
				flag=false;
				e2.printStackTrace();
				}
			
		}
			
		else{
			flag=false;
			Reporter.log("RDP is not invoked!! Hense quitting the test case.",true);
		}
		
		
		return flag;
	}
	
	
	
	
	
	public static boolean closeActiveRDPSession(){
		
		boolean flag=false;
		Screen s=new Screen();
		if (s.exists(sikuliRepository + "\\RDPIcon.PNG") != null) {
			try{
			s.rightClick(sikuliRepository + "\\RDPIcon.PNG");
			Thread.sleep(3000);
			s.click(sikuliRepository + "\\CloseWindowButton.PNG");
			Thread.sleep(3000);
			s.click(sikuliRepository + "\\CloseRdpOkButton.PNG");
			Thread.sleep(3000);
			flag=true;
		}
			  
			  catch(Exception e1){
				  Reporter.log("Some Error Occured while Closing Active RDP Session",true);
						
			  
			  }
			
		}
			
		 else {
			  Reporter.log("Active RDP Session is not available.",true);
			
			flag=false;
	}
		
		
		return flag;
	}
		
	
	public static boolean copyJarFileToRemoteMachine(String sourceFile, String destination, String ipAddressOfDestination){
		boolean flag=false;
		try{
			
			DesktopOptions options = new DesktopOptions();
			options.setApplicationPath("C:\\Windows\\System32\\cmd.exe");
			// options.setDebugConnectToRunningApp(true);
			driver1 = new WiniumDriver(new URL("http://"+ipAddressOfDestination+":9999"), options);
			flag1=true;
			driver1.findElementByClassName("ConsoleWindowClass").sendKeys("md "+destination+ System.getProperty("line.separator"));
			driver1.findElementByClassName("ConsoleWindowClass").sendKeys("copy /y \""+sourceFile +"\" "+destination+ System.getProperty("line.separator"));

			/*driver.findElementByClassName("ConsoleWindowClass")
					.sendKeys(line2 + System.getProperty("line.separator"));

			driver.findElementByClassName("ConsoleWindowClass")
					.sendKeys(line3 + System.getProperty("line.separator"));
	*/
			System.out.println("Done!!!");
			
			
			Thread.sleep(5000);
		//	driver.findElementByClassName("ConsoleWindowClass").sendKeys("TASKKILL /FI \"WINDOWTITLE eq win_title"+ System.getProperty("line.separator"));
			//TASKKILL /FI "WINDOWTITLE eq win_title
			flag=true;
			}
			
			catch(Exception e){
				Reporter.log("Failed To Copy File to the Remote machine!!"+e.getLocalizedMessage(),true);
				flag=false;
			}
		
		try {
			Thread.sleep(30000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
		
	}
	
	public static boolean unZipTheFileInRemoteMachine(String sourceFile, String destination, String ipAddressOfDestination){
		boolean flag=false;
		try{
			
			DesktopOptions options = new DesktopOptions();
			options.setApplicationPath("C:\\Windows\\system32\\WindowsPowerShell\\v1.0\\powershell.exe");
			// options.setDebugConnectToRunningApp(true);
			driver2 = new WiniumDriver(new URL("http://"+ipAddressOfDestination+":9999"), options);
			flag2=true;
			Thread.sleep(2000);
			driver2.findElementByClassName("ConsoleWindowClass")
			
			.sendKeys("powershell.exe (new-object -com shell.application).NameSpace(\""+destination+"\").CopyHere((new-object -com shell.application).NameSpace(\""+sourceFile+"\").Items())"+ System.getProperty("line.separator"));
		

			/*driver.findElementByClassName("ConsoleWindowClass")
					.sendKeys(line2 + System.getProperty("line.separator"));

			driver.findElementByClassName("ConsoleWindowClass")
					.sendKeys(line3 + System.getProperty("line.separator"));
	*/
			System.out.println("Done!!!");
			
			
			Thread.sleep(5000);
		//	driver.findElementByClassName("ConsoleWindowClass").sendKeys("TASKKILL /FI \"WINDOWTITLE eq win_title"+ System.getProperty("line.separator"));
			//TASKKILL /FI "WINDOWTITLE eq win_title
			flag=true;
			}
			
			catch(Exception e){
				flag=false;
				Reporter.log("Failed To Unzip the file in the Remote machine!!",true);
			}
		return flag;
		
	}
	
	public static boolean runTheJarInRemoteMachine(String fileName, String windowTitle, String ipAddressOfDestination){
		boolean flag=false;
		try{
		
			DesktopOptions options = new DesktopOptions();
				options.setApplicationPath("C:\\Windows\\System32\\cmd.exe");
				// options.setDebugConnectToRunningApp(true);
				driver3 = new WiniumDriver(new URL("http://"+ipAddressOfDestination+":9999"), options);
				flag3=true;
				driver3.findElementByClassName("ConsoleWindowClass").sendKeys("start \""+windowTitle+"\" java -jar "+fileName+ System.getProperty("line.separator"));

				/*driver.findElementByClassName("ConsoleWindowClass")
						.sendKeys(line2 + System.getProperty("line.separator"));

				driver.findElementByClassName("ConsoleWindowClass")
						.sendKeys(line3 + System.getProperty("line.separator"));
		*/
				System.out.println("Done!!!");
				
				
				Thread.sleep(5000);
		//	driver.findElementByClassName("ConsoleWindowClass").sendKeys("TASKKILL /FI \"WINDOWTITLE eq win_title"+ System.getProperty("line.separator"));
			//TASKKILL /FI "WINDOWTITLE eq win_title
			flag=true;
			}
			
			catch(Exception e){
				flag=false;
				Reporter.log("Failed To Run The Jar in the Remote machine!!",true);
			}
		return flag;
		
	}
	
	
	public static boolean closeTheJarInRemoteMachine(String windowTitle, String ipAddressOfDestination){
		boolean flag=false;
		try{
			
			DesktopOptions options = new DesktopOptions();
			options.setApplicationPath("C:\\Windows\\System32\\cmd.exe");
			driver4 = new WiniumDriver(new URL("http://"+ipAddressOfDestination+":9999"), options);
			flag4=true;
			driver4.findElementByClassName("ConsoleWindowClass").sendKeys("TASKKILL /FI \"WINDOWTITLE eq "+windowTitle + System.getProperty("line.separator"));
			System.out.println("Done!!!");
				/*driver.findElementByClassName("ConsoleWindowClass")
						.sendKeys(line2 + System.getProperty("line.separator"));

				driver.findElementByClassName("ConsoleWindowClass")
						.sendKeys(line3 + System.getProperty("line.separator"));
		*/
				System.out.println("Done!!!");
				
				
				Thread.sleep(5000);
		//	driver.findElementByClassName("ConsoleWindowClass").sendKeys("TASKKILL /FI \"WINDOWTITLE eq win_title"+ System.getProperty("line.separator"));
			//TASKKILL /FI "WINDOWTITLE eq win_title
			flag=true;
			}
			
			catch(Exception e){
				flag=false;
				Reporter.log("Failed To Close The Jar in the Remote machine!!",true);
			}
		return flag;
	}	
	
	
public static boolean enterRdpUserNameAndPassword(String userName, String password){
	
	boolean flag=true;
	Screen s=new Screen();
	if(s.exists(sikuliRepository+"\\RDPIcon.PNG") != null){
		try{
			s.click(sikuliRepository+"\\RDPIcon.PNG");
			Thread.sleep(3000);
			try{
			s.click(sikuliRepository+"\\ConnectButton.PNG");
			Thread.sleep(3000);
			}
			
			catch (Exception e){
				Reporter.log("Connect Button is not present",true);
			}
			Thread.sleep(3000);
			s.click(sikuliRepository+"\\useAnotherAccount.PNG");
			s.type(sikuliRepository+"\\UserName.PNG",userName);
			s.type(sikuliRepository+"\\PasswordField.PNG",password);
			Thread.sleep(3000);
			s.click(sikuliRepository+"\\OkButton.PNG");
			//s.exists(repositoryLocation+"\\RDPIcon.PNG");
		}
		catch(Exception e2){
			Reporter.log("Something went Wrong!! RDP Password is not entered properly!!",true);
			flag=false;
			e2.printStackTrace();
			}
		
	}
		
	else{
		flag=false;
		Reporter.log("RDP is not invoked!! Hense quitting the test case.",true);
	}
	
	
	return flag;
}

public static boolean cancelReconnect(){
	
	boolean flag=false;
	Screen s=new Screen();
	if (s.exists(sikuliRepository + "\\RDPIcon.PNG") != null) {
		try{
			s.click(sikuliRepository+"\\RDPIcon.PNG");
			Thread.sleep(3000);
		s.click(sikuliRepository + "\\CancelReconnect.PNG");
		Thread.sleep(3000);
		flag=true;
	}
		  
		  catch(Exception e1){
			  Reporter.log("Some Error Occured while Closing ReConnect",true);
					
		  
		  }
		
	}
		
	 else {
		  Reporter.log("Active RDP Session is not available.",true);
		
		flag=false;
}
	return flag;
}

public static void cleanupWinumDrivers(){
	if (flag1==true){
		driver1.quit();
	}
	if (flag2==true){
		driver2.quit();
	}
	if (flag3==true){
		driver3.quit();
	}
	if (flag4==true){
		driver4.quit();
	}
	
}


	public static void runTomcatApacheServer(String path,String ipAddressOfDestination) throws MalformedURLException{
		try {
		DesktopOptions options = new DesktopOptions();
			options.setApplicationPath("C:\\Windows\\System32\\cmd.exe");
			driver5 = new WiniumDriver(new URL("http://"+ipAddressOfDestination+":9999"), options);
			
			flag1=true;
			driver5.findElementByClassName("ConsoleWindowClass").sendKeys("cd "+path+ System.getProperty("line.separator"));
			driver5.findElementByClassName("ConsoleWindowClass").sendKeys("startup.bat");
			System.out.println("Done!!!");
	
	}catch (Exception e){
		Reporter.log("Some Error Occured while Running Apache Application",true);
	}
	}
}