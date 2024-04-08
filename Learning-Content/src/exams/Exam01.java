package exams;

import java.util.Arrays;

import classes.Product;

public class Exam01 {

	public static void main(String[] args) {
		
		/**
		 *  Product 클래스 제작
		 *  1. 정보 은닉 / getter & setter / constructor / default constructor 모두 작성
		 *  2. 멤버 필드 : 상품 코드 / 상품명 / 가격 / 재고
		 *  
		 *  Product 설계도 기반 인스턴스를 3개를 생성하고 저장된 데이터를 화면에 출력 (데이터는 자유 선택)
		 */
		
		Product[] product = new Product[] {
			new Product("f1001", "ogange", 3000, 15),
			new Product("f1002", "melon", 10000, 5),
			new Product("f1003", "apple", 2000, 10)
		};
		
		System.out.println("상품코드\t상품명\t가격\t재고");
		for(int i=0; i<product.length; i++) {
			System.out.println(product[i].getCode());
		}
		
		System.out.println(Arrays.toString(product));

	}

}
