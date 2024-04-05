package quizs;

import java.lang.reflect.Array;
import java.util.Scanner;

import classes.Student;

public class Quiz02 {

	public static void main(String[] args) {
		
		/**
		 *  디자인 패턴
		 * 	MVC ( Model View Control )
		 *  M - Model: 데이터를 관리하는 소스코드 집합
		 *  V - View: 시각요소를 관리하는 소스코드 집합
		 *  C - Control: 프로그램 흐름을 관리하는 소스코드 집합
		 *  
		 */
		
		Scanner sc = new Scanner(System.in);
		Student[] stds = new Student[10];	// 학생 정보 입력은 최대 10명까지
		int index = 0;
		
		
		while(true) {
			System.out.println("<< 학생 관리 시스템 >>");
			System.out.println("1. 신규 정보 입력");
			System.out.println("2. 학생 목록 출력");
			System.out.println("3. 학생 정보 검색"); // input: 검색할 학생 이름
			System.out.println("0. 시스템 종료");
			System.out.print(">> ");
			int input = sc.nextInt();
			
			if(input == 1) {
				// 신규 정보 입력
				if(index == 9) {
					System.err.println("더 이상 학생을 추가할 수 없습니다.");
					continue;
				}
				System.out.println("학생 이름 : ");
				String name = sc.next();
				
				System.out.println(name + "학생 국어 : ");
				int kor = sc.nextInt();
				
				System.out.println(name + "학생 영어 : ");
				int eng = sc.nextInt();
				
				System.out.println(name + "학생 수학 : ");
				int math = sc.nextInt();
				
				stds[index] = new Student(String.valueOf(index), name, kor, eng, math);
				index ++;
				
			} else if(input == 2) {
				// 학생 목록 출력
				if(index == 0) {
					System.err.println("등록된 학생이 없습니다.");
					continue;
				}
				System.out.println("학번\t이름\t국어\t영어\t수학\t합계\t평균");
				for(int i=0; i<index; i++) {
					System.out.println(stds[i].getId()+ "\t" +
									   stds[i].getName()+ "\t"+
								  	   stds[i].getKorean()+ "\t"+
									   stds[i].getEnglish()+ "\t"+
									   stds[i].getMath()+ "\t"+
									   stds[i].getSum()+ "\t"+
									   // 소수점 자리수 지정하여 출력
									   String.format("%.2f", stds[i].getAvg()) + "\t");
				}
				
			} else if(input == 3) {
				// 힉생 정보 검색 input: 이름, 중복 값 있을 시 모두 출력
				System.out.println("학생 이름을 입력하세요 : ");
				String name = sc.next();
				int result = 0;
				System.out.println("학번\t이름\t국어\t영어\t수학\t합계\t평균");
				for(int i=0; i<index; i++) {
					if(stds[i].getName().contains(name)) {
						System.out.println(stds[i].getId()+ "\t" +
								   stds[i].getName()+ "\t"+
							  	   stds[i].getKorean()+ "\t"+
								   stds[i].getEnglish()+ "\t"+
								   stds[i].getMath()+ "\t"+
								   stds[i].getSum()+ "\t"+
								   // 소수점 자리수 지정하여 출력
								   String.format("%.2f", stds[i].getAvg()) + "\t");
						result++;
					}
				}
				if(result == 0) {
					System.out.println("!!! 검색 결과 없음 !!!");
					continue;
				}
				
				
			}else if(input == 0) {
				// 시스템 종료
				System.out.println("!!! 시스템이 종료 !!!");
				break;
				
			} else {
				System.err.println("!!! 잘못된 입력 값 !!!");
			}
		}
	}

}
