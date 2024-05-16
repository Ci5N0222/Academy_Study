package models;

import java.util.Scanner;

public class InputManager {
	
	/**
	 *  !! 문제 발생: str에 int 타입의 123을 입력시 오류 발생
	 *  !! 입력받은 값의 타입을 확인하는 메서드 필요
	 */
	
	Scanner sc = new Scanner(System.in);
	
	/**
	 *  Scanner Class를 사용하여 String 형태의 input data만 받는 메서드
	 * @return
	 */
	public String stringInputData() {
		String str = sc.nextLine();
		boolean success = false;
		char[] arr = str.toCharArray();
		for(int i=0; i<arr.length; i++) {
		    // 아스키 코드로 문자 범위에 있는지 없는지 검증
		    if((65 <= arr[i] && arr[i] <= 90) || (97 <= arr[i] && arr[i] <= 122)) {
		    	success = true;
		    } else {
		        System.out.println("문자만 입력하세요.");
		    }
		}
		if(success) return str; 
		else return null;
	}
	
	

}
