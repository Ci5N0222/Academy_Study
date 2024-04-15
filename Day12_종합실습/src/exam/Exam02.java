package exam;

import java.text.SimpleDateFormat;

public class Exam02 {

	public static void main(String[] args) {
		
		// Timestamp -> String(형식을 갖춘)
		
		// 현재의 Timestamp 추출
		long ctime = System.currentTimeMillis();
		
		// 어떤 형식으로 보여줄지 결정
		// MM: 달, mm: 분
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd(E) hh:mm:ss");
		
		// Timestamp를 형식에 맞게 반환하는 메서드(.format()) 호출
		String date = sdf.format(ctime);
		
		// 결과 출력
		System.out.println(date);
	}

}
