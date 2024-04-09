package callection;

public class Exam02 {

	public static void main(String[] args) {
		
		String[] arr = new String[10];
		arr[0] = "Hello";
		arr[1] = "World";
		arr[2] = "Java";
		
		System.out.println(arr[0]);
		System.out.println(arr[1]);
		System.out.println(arr[2]);
		
		
		// 인덱스 0의 데이터 삭제
		for(int i=0; i<3; i++) {
			arr[i] = arr[i+1];
		}
		
		System.out.println("===========================");
		System.out.println(arr[0]);
		System.out.println(arr[1]);
		
		
		// 인덱스 1에 데이터를 추가하기 위해 기존 인덱스1을 옮겨주는 작업을 수동으로 한다.
		arr[2] = arr[1];
		arr[1] = "collection";
		
		System.out.println("===========================");
		System.out.println(arr[0]);
		System.out.println(arr[1]);
		System.out.println(arr[2]);
		
		
		System.out.println(arr.length);
		
	}

}
