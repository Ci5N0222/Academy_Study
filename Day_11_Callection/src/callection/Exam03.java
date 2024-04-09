package callection;

import java.util.ArrayList;
import java.util.Scanner;

public class Exam03 {

	public static void main(String[] args) {
		/**
		 *  ArrayList
		 *  1. 초기 사이즈를 지정할 필요가 없다.
		 *  	- 사이즈가 부족하면 자동으로 2배로 늘어난다.
		 *  2. 인덱스를 지정하고 값을 할당할 수 없다.
		 *  	- 중간의 값이 빠지면 자동으로 빠진 배열의 뒷부분부터 앞으로 한칸씩 정렬되기 떄문에
		 *  3. 데이터 타입이 없음 ? ==> Object 타입을 가짐, 다형성으로 데이터 타입 없이 사용
		 *  	- Object: 자바에 존재하는 모든 클래스 타입의 최고 조상
		 *  	- 자바에 존재하는 모든 클래스는 Object를 상속 받게 되어있다.
		 *  	
		 *  다형성은 최대한 필요한 상황이 아닐경우 최대한 피해야 한다.
		 *  
		 *  Array<String> arr = new Array<String>();
		 *  <> --> 제너릭 타입
		 *  <String> --> 스트링 제너릭 타입
		 *  
		 */
		
		// Object는 모든 클래스의 조상이기 떄문에 모든 데이터를 담을 수 있다.
		// 저장은 편하게 하지만 사용을 불편하게 함 ( 불필요한 다운캐스팅을 많이해야 한다 )
		Object o = 10;
		o = 3.14;
		o = "string";
		o = new Scanner(System.in);
		
		
		ArrayList<String> arr = new ArrayList<String>();
		
		
		arr.add("Hello");
		arr.add("World");
		arr.add("Java");
		
		System.out.println(arr.get(0));
		System.out.println(arr.get(1));
		System.out.println(arr.get(2));
		
		// 인덱스 0의 데이터 삭제
		arr.remove(0);
		
		System.out.println("===========================");
		System.out.println(arr.get(0));
		System.out.println(arr.get(1));
		
		// 인덱스 1에 데이터 추가
		arr.add(1, "collection");
		System.out.println("===========================");
		System.out.println(arr.get(0));
		System.out.println(arr.get(1));
		System.out.println(arr.get(2));
		
		// ArrayList length
		System.out.println(arr.size());
	}

}

