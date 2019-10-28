package Learning;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpression {

	public static void main(String[] args) {
		Pattern pattern = Pattern.compile("[^e]*e");
		Matcher matcher = pattern.matcher("elephant");
		int count = 0;
		while (matcher.find()) {
		    count++;
		}
		  
		System.out.println("count "+count);

	}

}
