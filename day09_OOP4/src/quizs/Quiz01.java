package quizs;

import java.util.Scanner;

import classes.Student;

public class Quiz01 {

	public static void main(String[] args) {
		/**
		 *  Student class를 사용
		 *  Scanner로 입력 받아 합계/ 평균 내기
		 */
		
		Scanner scan = new Scanner(System.in);
		Student[] student = new Student[3];
		
		
		for(int i=0; i<student.length; i++) {
			System.out.println(i+1 + "번째 학생 이름 : ");
			String name = scan.next();
			
			System.out.println(name + "학생 국어 : ");
			int kor = scan.nextInt();
			
			System.out.println(name + "학생 영어 : ");
			int eng = scan.nextInt();
			
			System.out.println(name + "학생 수학 : ");
			int math = scan.nextInt();
			
			student[i] = new Student(i, name, kor, eng, math);
			
		}
		
		System.out.println("학번\t이름\t국어\t영어\t수학\t합계\t평균");
		for(int i=0; i<student.length; i++) {
			System.out.println(student[i].getId()+ "\t" +
							   student[i].getName()+ "\t"+
							   student[i].getKorean()+ "\t"+
							   student[i].getEnglish()+ "\t"+
							   student[i].getMath()+ "\t"+
							   student[i].getSum()+ "\t"+
							   // 소수점 자리수 지정하여 출력
							   String.format("%.2f", student[i].getAvg()) + "\t");
		}
		

	}

}
