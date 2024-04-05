package quizs;

import java.util.Scanner;

import classes.Student;
import models.StudentManager;

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
		StudentManager manager = new StudentManager();
		
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
				System.out.println("학생 이름 : ");
				String name = sc.next();
				
				System.out.println(name + "학생 국어 : ");
				int kor = sc.nextInt();
				
				System.out.println(name + "학생 영어 : ");
				int eng = sc.nextInt();
				
				System.out.println(name + "학생 수학 : ");
				int math = sc.nextInt();
				
				String id = String.valueOf(1000 + manager.getIndex());
				
				Student std = new Student(id, name, kor, eng, math);
				manager.addStudent(std);
				manager.setIndex(manager.getIndex());
				
			} else if(input == 2) {
				// 학생 목록 출력
				Student[] stds = manager.getStds();
				if(manager.getIndex() == 0) {
					System.out.println("등록된 학생이 없습니다.");
					continue;
				}
				System.out.println("manager.getIndex() ==== "+manager.getIndex());
				System.out.println("학번\t 이름\t 국어\t 영어\t 수학\t 총점\t 평균\t");
				for(int i=0; i<manager.getIndex(); i++) {
					System.out.println(stds[i].getId() + "\t" +
									   stds[i].getName() + "\t" +
									   stds[i].getKorean() + "\t" +
									   stds[i].getEnglish() + "\t" +
									   stds[i].getMath() + "\t" +
									   stds[i].getSum() + "\t" +
									   stds[i].getAvg() + "\t");
				}
				
			} else if(input == 3) {
				// 힉생 정보 검색 input: 이름, 중복 값 있을 시 모두 출력
				System.out.print("검색할 학생 이름 : ");
				String name = sc.next();
				Student[] stds = manager.getStds();
				System.out.println("학번\t 이름\t 국어\t 영어\t 수학\t 총점\t 평균\t");
				for(int i=0; i<manager.getIndex(); i++) {
					if(stds[i].getName().contains(name)) {
						System.out.println(stds[i].getId() + "\t" +
								   stds[i].getName() + "\t" +
								   stds[i].getKorean() + "\t" +
								   stds[i].getEnglish() + "\t" +
								   stds[i].getMath() + "\t" +
								   stds[i].getSum() + "\t" +
								   stds[i].getAvg() + "\t");
					}
				}
			}else if(input == 0) {
				// 시스템 종료
				System.out.println("!!! 시스템 종료 !!!");
				break;
				
			} else {
				System.err.println("!!! 잘못된 입력 값 !!!");
			}
		}
	}

}
