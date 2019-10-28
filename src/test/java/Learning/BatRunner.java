package Learning;

import java.io.File;
import java.io.OutputStreamWriter;

import org.codehaus.plexus.util.cli.CommandLineException;
import org.codehaus.plexus.util.cli.CommandLineUtils;
import org.codehaus.plexus.util.cli.Commandline;
import org.codehaus.plexus.util.cli.WriterStreamConsumer;

public class BatRunner {

	public BatRunner() {
		String batfile = "java.bat";
		String directory = "D:\\";
		try {
			runProcess(batfile, directory);
		} catch (CommandLineException e) {
			e.printStackTrace();
		}
	}
	
	public void runProcess(String batfile, String directory) throws CommandLineException {
		
		Commandline commandLine = new Commandline();
		
		File executable = new File(directory + "/" +batfile);
		commandLine.setExecutable(executable.getAbsolutePath());
		
		WriterStreamConsumer systemOut = new WriterStreamConsumer(
	            new OutputStreamWriter(System.out));
		
		WriterStreamConsumer systemErr = new WriterStreamConsumer(
	            new OutputStreamWriter(System.out));

		int returnCode = CommandLineUtils.executeCommandLine(commandLine, systemOut, systemErr);
		if (returnCode != 0) {
		    System.out.println("Something Bad Happened!");
		} else {
		    System.out.println("Taaa!! ddaaaaa!!");
		};
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new BatRunner();
	}

}
