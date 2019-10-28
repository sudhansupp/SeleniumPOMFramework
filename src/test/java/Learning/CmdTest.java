package Learning;

import java.io.*;

public class CmdTest {
	
    public static void main(String[] args) throws Exception {
        ProcessBuilder builder = new ProcessBuilder(
            "cmd.exe", "/c", "cd \"C:\\Program Files (x86)\\cRSP-SSL-VPN-Client\" && where java && dir");
        builder.redirectErrorStream(true);
        Process p = builder.start();
        BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
        String line;
        while (true) {
            line = r.readLine();
            if (line == null) { break; }
            System.out.println(line);
        }
    }
}