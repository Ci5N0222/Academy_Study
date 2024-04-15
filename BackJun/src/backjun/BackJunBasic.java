package backjun;

import java.util.Scanner;

public class BackJunBasic {

	public static void main(String[] args) {
		/**
		 * 	두 자연수 A와 B가 주어진다.
		 *  이 때, A+B, A-B, A*B, A/B, A%B를 출력하는 프로그램을 작성하시오.
		 */
		
		Scanner sc = new Scanner(System.in);
		double num1 = sc.nextInt();
		double num2 = sc.nextInt();
		
		System.out.println(num1 + num2);
		System.out.println(num1 - num2);
		System.out.println(num1 * num2);
		System.out.println(num1 / num2);
		System.out.println(num1 % num2);
		
		
	}

}
