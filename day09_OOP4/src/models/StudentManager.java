package models;

import classes.Student;

// 데이터 선납 관리 클래스
public class StudentManager {
	// 학생 정보 입력은 최대 10명까지, 데이터 저장소(시각적 요소X)
	private Student[] stds = new Student[10];
	private int index = 0;
	
	public void addStudent(Student std) {
		stds[index] = std;
		index++;
	}
	
	public Student[] getStds() {
		return stds;
	}

	/** getter & setter **/
	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}
	
	
}
