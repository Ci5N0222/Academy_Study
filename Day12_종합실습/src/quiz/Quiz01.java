package quiz;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Quiz01 {
	// 1919년 3월 1일은 무슨 요일이었을까요?

	public static void main(String[] args) throws ParseException {
		
		
		String ctime = "1919-03-01";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date result = sdf.parse(ctime);
		
		long timestamp = result.getTime();
		System.out.println(timestamp);
		
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd(E)");
		String result2 = sdf2.format(timestamp);
		System.out.println(result2);
		
		
	}

}
