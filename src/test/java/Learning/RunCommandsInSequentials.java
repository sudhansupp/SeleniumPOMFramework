package Learning;

import java.io.IOException;

public class RunCommandsInSequentials {
	public static void main(String[] args) throws Exception {
		
		
		/*
		 * Runtime rt = Runtime.getRuntime(); rt.exec(new
		 * String[]{"cmd.exe","/c","start","java -version"});
		 */
		 
		/*
		 * String command = "cmd.exe /c start "+"java -version";
		 * 
		 * Process child = Runtime.getRuntime().exec(command);
		 * System.out.println(child.getOutputStream().toString());
		 */
		/*
		 * Runtime. getRuntime(). exec("D:\\java.bat");
		 */
		//Runtime.getRuntime().exec(new String[]{"cmd.exe", "/D", "java.bat"});
		
		//Running a batch file from a particular directory and working
		/*
		 * String path="cmd /c start d:\\java.bat"; Runtime rn=Runtime.getRuntime();
		 * Process pr=rn.exec(path);
		 */
		/*
		 * try { Process process =
		 * Runtime.getRuntime().exec("cmd /c start D:\\java.bat");
		 * System.out.println(process.getOutputStream()); } catch(IOException e) {
		 * e.printStackTrace(); }
		 */
		
		
		/*
		 * String path="cmd /c start d:\\gradle.bat"; Runtime rn=Runtime.getRuntime();
		 * Process pr=rn.exec(path);
		 */
		/*
		 * ProcessBuilder pb = new ProcessBuilder(executable, arguments, if, any);
		 * pb.directory(theWorkingDirectory); pb.start();
		 */
		 
		//Runtime.getRuntime().exec("c:/elevate");
		 
		//Runtime.getRuntime().exec("runas /profile /user:Administrator \"cmd.exe /c Powrprof.dll,SetSuspendState\"");
		System.out.println(System.getProperty("user.dir"));
	}
	
}
