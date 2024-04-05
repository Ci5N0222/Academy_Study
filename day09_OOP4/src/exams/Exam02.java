package exams;

import classes.Student;

public class Exam02 {

	public static void main(String[] args) {
		/**
		 *  Student 클래스 제작
		 *  1. 멤버 필드: 학번 / 이름 / 국어 / 영어 / 수학
		 *  2. 멤버 메서드: setter / getter / constructor / default constructor
		 *  ** 추가 메서드: getSum: 인스턴스 내 점수 합계를 get 하는 메서드
		 *  			 getAvg: 인스턴스 내 점수 평균을 get 하는 메서드
		 *  
		 *  정보 은닉을 꼭 지켜서 작성할 것
		 *  인스턴스는 3개를 만들어서 저장.
		 *  출력: 학번 / 이름 / 국어 / 영어 / 수학 / 합계 / 평균 
		 */
		
		Student[] student = new Student[] {
				new Student(24, "Kim", 60, 70, 60),
				new Student(22, "Lee", 80, 90, 70),
				new Student(21, "Park", 50, 60, 40)
		};
		
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
