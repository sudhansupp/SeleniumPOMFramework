package utils.ExtentReports;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.demo.library.CustomFunc;
import com.relevantcodes.extentreports.ExtentReports;

//OB: ExtentReports extent instance created here. That instance can be reachable by getReporter() method.

public class ExtentManager {

    private static ExtentReports extent;

    public synchronized static ExtentReports getReporter(){
    	

		Calendar calendar = Calendar.getInstance();
		Date date = calendar.getTime();
		SimpleDateFormat stringDate = new SimpleDateFormat("ddMMyyyyhhmmssSS");

		String newDate = stringDate.format(date);
		
        if(extent == null){
            //Set HTML reporting file location
            String workingDir = System.getProperty("user.dir");
            extent = new ExtentReports(workingDir+"\\ExtentReports\\ExtentReportResults_"+newDate+".html", true);
        }
        return extent;
    }
}
