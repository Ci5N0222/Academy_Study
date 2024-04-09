package callection;

public class Exam04 {
	public static void main(String[] args) {
		
		/**
		 *  for문 비교
		 *  
		 */
		
		String[] arr = new String[] {"Hello", "World"};
		
		
		/**
		 * 	기존 for문
		 * 	i를 이용하여 원하는 바퀴수, 인덱스 증가량 등을 조절할 수 있다.
		 */
		for(int i=0; i<arr.length; i++) {
			System.out.println(arr[i]);
		}
		
		/**
		 * 	변형for문, forEach문
		 * 	전체 데이터를 순회
		 */
		for(String str: arr) {
			System.out.println(str);
		}
		
	}
}
