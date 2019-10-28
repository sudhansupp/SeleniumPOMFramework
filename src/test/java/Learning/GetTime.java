package Learning;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import com.demo.library.CustomFunc;

public class GetTime {

	
	public static void main(String[] args) throws InterruptedException, IOException {
		
		System.out.println("the difference between the time is: "+CustomFunc.getTimeDifference(CustomFunc.getNow(), CustomFunc.getCurrentTime()));
		}
	
@SuppressWarnings("null")
public static long getTimeOfActionForAuditLog() throws InterruptedException, IOException {	
		Date currentTime = null;
		@SuppressWarnings("null")
		long time;
		time=currentTime.getTime();
		
		return time;

	}

public static long getTimeDifference(long oldTime, long latestTime) {

	long diff = latestTime- oldTime;
	System.out.println("TimeDifference in MilliSeconds = " + diff);
	System.out.println("TimeDifference in Seconds = " + diff / 1000);
	return diff;
}
	}


