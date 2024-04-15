package exam;

public class Exam01 {

	public static void main(String[] args) {
		
		// Timestamp: 1970년 1월 1일을 기준으로 현재까지 흐른 시간에 대한 초값
		
		// System.currentTimeMillis() --> timestamp*1000
		
		Long startTime = System.currentTimeMillis();
		
		int count = 0;
		for(int i=0; i<1000000; i++) {
			count++;
		}
		
		Long endTime = System.currentTimeMillis();
		System.out.println(endTime - startTime);
		
		
	}

}
