package exam;

import java.text.SimpleDateFormat;
import java.util.Date;

public class exam03 {

	public static void main(String[] args) throws Exception {
		
		// String -> Timestamp	
		String ctime = "2014-04-15";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date result = sdf.parse(ctime);
		
		// Timestamp
		long parsedTime = result.getTime();
		System.out.println(parsedTime);
		
		
		// Timestamp -> String
		SimpleDateFormat sdf2 = new SimpleDateFormat("dd.MM.yyyy");
		String result2 = sdf.format(parsedTime);
		System.out.println(result2);
		
		
	}

}
