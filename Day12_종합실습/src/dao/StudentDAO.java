package dao;

import java.time.LocalDate;
import java.util.ArrayList;

import dto.StudentDTO;

public class StudentDAO {
	
	/** Student Data Save **/
	ArrayList<StudentDTO> students = new ArrayList<StudentDTO>();
	
	// 학번 자동 업데이트
	int aiIndex = 240001;
	
	
	/**
	 * 신규 학생 등록
	 * @param name
	 * @param kor
	 * @param eng
	 * @param math
	 * @return
	 */
	public int addStudent(String name, int kor, int eng, int math) {
		int success = 0;
		try {
			students.add(new StudentDTO(aiIndex, name, kor, eng, math));
			aiIndex++;
			success = 1;
		} catch (Exception e) {
			System.out.println("Error : " + e);
		}

		return success;
	}
	
	
	/**
	 * 학생 목록 출력
	 * @return
	 */
	public ArrayList<StudentDTO> studentList(){
		return students;
	}
	
	
	/**
	 * 학생 정보 검색
	 * @param name
	 * @return
	 */
	public ArrayList<StudentDTO> searchStudentInfo(String name){
		ArrayList<StudentDTO> searchStudent = new ArrayList<StudentDTO>();
		for(StudentDTO student : students) {
			if(student.getName().contains(name)) {
				searchStudent.add(student);
			}
		}
		return searchStudent;
		
	}
	

	/**
	 * 학생 정보 삭제
	 * @param id
	 * @return
	 */
	public int deleteStudent(int id) {
		int success = 0;
		int index = 0;
		
		try {
			for(StudentDTO student: students) {
				if(student.getId() == id) {
					index = students.indexOf(student);
					students.remove(index);
					success = 1;
					break;
				}
			}

		} catch (Exception e) {
			System.out.println("Error : " + e);
		}
		
		return success;
	}
	
	
	/**
	 * ID에 해당하는 학생 찾기
	 * @param id
	 * @return
	 */
	public Boolean searchStudent(int id) {
		for(StudentDTO student : students) {
			if(student.getId() == (id)) {
				return true;
			}
		}
		return false;
	}
	

	/**
	 * 학생 정보 수정
	 * @param id
	 * @param kor
	 * @param eng
	 * @param math
	 * @return
	 */
	public int updateStudent(int id, int kor, int eng, int math) {
		int success = 0;
		
		try {
			for(StudentDTO student : students) {
				if(student.getId() == (id)) {
					student.setKor(kor);
					student.setEng(eng);
					student.setMath(math);
					student.setSum(student.sumScore(kor, eng, math));
					student.setAvg(student.avgScore(student.getSum()));
					student.setWrite_date(LocalDate.now());
					success = 1;
				}
			}
		} catch (Exception e) {
			System.out.println("Error : " + e);
		}
		
		return success;
	}
	
}
	
