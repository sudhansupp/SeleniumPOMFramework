package Learning;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.stream.Collectors;

public class RunBatFile {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String path = System.getProperty("user.dir")+"\\TestData\\TextData\\dir.bat";
		runBatchFile(path);

	}
	public static void runBatchFile(String path) throws Exception {
		
		
		// Running
		System.out.println("exe");
		String cmd = "cmd /c start "+path;
		Runtime r = Runtime.getRuntime();
		//Process pr = r.exec("java -version");
		Process pr = r.exec("java -version");
		//Thread.sleep(5000);
		pr.waitFor();
		System.out.println("exe done");
		System.out.println("exit code is :"+pr.getOutputStream());
		
		String result = new BufferedReader(new InputStreamReader(pr.getInputStream()))
				  .lines().collect(Collectors.joining("\n"));
		System.out.println("exit code is :"+result);
       System.out.println("--------->"+convertStreamToString(pr.getInputStream()));
       PrintStream prtStrm = System.out;
       prtStrm = new PrintStream(pr.getOutputStream());
       prtStrm.println();
       
       
        result = new BufferedReader(new InputStreamReader(pr.getErrorStream()))
				  .lines().collect(Collectors.joining("\n"));
		System.out.println("Result is :"+result);
		
		 result = new BufferedReader(new InputStreamReader(pr.getErrorStream()))
				  .lines().collect(Collectors.joining("\n"));
		System.out.println("Result is ----------->>> :"+result);
       
		
		

	}
	
	static String convertStreamToString(java.io.InputStream is) {
	    java.util.Scanner s = new java.util.Scanner(is).useDelimiter("\\A");
	    return s.hasNext() ? s.next() : "";
	}
	public static void runBatchAndReturnString(String path) throws IOException, InterruptedException {
		
			System.out.println("insdie runBatchAndReturnString");
		
			String cmd = "cmd /c start "+path;
            Process p=Runtime.getRuntime().exec(cmd); 
            Thread.sleep(3000);
           // Process p = Runtime.getRuntime().exec(new String[] {"ipconfig", g});
            InputStream s = p.getInputStream();

            BufferedReader in = new BufferedReader(new InputStreamReader(s));
            String temp;
System.out.println("before test :"+ in.readLine());
            while ((temp = in.readLine()) != null) {
            	System.out.println("inside while loop");
                System.out.println(temp);
            }
	}
}
		


