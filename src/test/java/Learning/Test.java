package Learning;

import java.util.regex.*;

class Test {
    public static void main(String[] args) {
		/*
		 * String hello =
		 * " 2116789112550721022,,enqmxvbgte@siemens.co.in,\"REMOTE_USER\",\"||REMOTE_USER\"\r\n"
		 * +
		 * "    2073985062990251842,Guruprasad Ramesh,guruprasadr.in@gmail.in,\"\",\"Africa|ALL|,Americas|ALL|,On-Demand Devices|On-Demand|\"\r\n"
		 * +
		 * "    2103731566684406840,mavintopjunju mavintopjunju,mavintopjunju@gmail.com,\"\",\"Africa|ALL|,Americas|ALL|,Asia|ALL|,Australia|ALL|,Congo, The Democratic Republic of the|DC WINCC|,E F CWP|ALL|,E F IE Demo|ALL|,FT_Test_AWS|ALL|,On-Demand Devices|On-Demand|,World|ALL|,/World|/ALL|,/World/Africa|/ALL|\"\r\n"
		 * +
		 * "    2037743961694537351,volkan toprak,volkan.toprak@siemens.com,\"\",\"On-Demand Devices|On-Demand|\"\r\n"
		 * +
		 * "    2093567289373754451,HALDUN TERAMAN,haldun.teraman@siemens.com,\"\",\"Africa|AA_reserved_1578|,Americas|AA_reserved_1578|,Asia|AA_reserved_1578|,On-Demand Devices|On-Demand|,World|ALL|\"\r\n"
		 * +
		 * "    2110193399121315575,null,anil.kesti@siemens.com,\"\",\"On-Demand Devices|On-Demand|,/World/Africa|/ALL/AA_reserved_1578/BEProd-165254682|\"\r\n"
		 * +
		 * "    2116762848624379320,JENKINS USER,pranita.sahoo@siemens.com,\"\",\"000000FTsite|ALL|,Africa|ALL|,Americas|ALL|,Asia|ALL|,Australia|ALL|,BLR_LAB_Duration_Tests|ALL|,DontDeleteRegion|ALL|,E F CWP|ALL|,E F IE|ALL|,E F IE Demo|ALL|,E F Routers|ALL|,On-Demand Devices|On-Demand|, PR|ALL|,RegressionAutoIpsecSite|ALL|,SanityAutoIPsecSite|ALL|,World|ALL|\"\r\n"
		 * +
		 * "    2116796058821461525,,sxmpbawxte@siemens.com,\"REMOTE_USER\",\"||REMOTE_USER\""
		 * ; String regx=".*@.*"; Pattern pattern = Pattern.compile(regx); Matcher
		 * matcher = pattern.matcher(hello);
		 * 
		 * int count = 0; while (matcher.find()) count++;
		 * 
		 * System.out.println(count);
		 */
        

String x="device:urn:2104372015723972048";
String y=x.split(":")[2];
System.out.println("y is : "+y);
String a="VtL22JTAJFmQcP86S1uLRoFeRzS88cttfDJo5f5dKmDOeFO/Kwj3FWtdFJgdKPNZm8y99n6NsPfgjZrXl0+QHAWx0kvnSm0C8sxJqYSYCAg=";
String b="VtL22JTAJFmQcP86S1uLRoFeRzS88cttfDJo5f5dKmDOeFO/Kwj3FWtdFJgdKPNZm8y99n6NsPfgjZrXl0+QHAWx0kvnSm0C8sxJqYSYCAg=";
System.out.println("string comparision result : "+a.equals(b));
String a1="th gfdgfdggdfgdfg gfdgdfa";
if(a1.contains("ban")) {
	System.out.println("one");
}
else if(a1.contains("is")) {
	System.out.println("two");
}
else if(a1.contains("sudhansu")) {
	System.out.println("three");
}
else if(a1.contains("panda")) {
	System.out.println("four");
}
else{
	System.out.println("inside else block");
}
}
  
}