package main;

import java.util.ArrayList;
import java.util.Scanner;

import dao.StudentDAO;
import dto.StudentDTO;

public class Main {

	public static void main(String[] args) {
		// 학생 관리 시스템
		
		Scanner sc = new Scanner(System.in);
		StudentDAO studentDAO = new StudentDAO();
		
		while(true) {
			System.out.println("<<< 학생 관리 시스템 >>>");
			System.out.println("1. 신규학생 등록");
			System.out.println("2. 학생 목록 출력");
			System.out.println("3. 학생 정보 검색");
			System.out.println("4. 학생 정보 삭제");
			System.out.println("5. 학생 정보 수정");
			System.out.println("6. 시스템 종료");
			System.out.println(">>> ");
			int input = Integer.parseInt(sc.nextLine());
			
			switch (input) {
				case 1:
					/** 신규 학생 등록 **/
					System.out.println("<<< 신규학생 등록 >>>");
					System.out.println("이름을 입력하세요 > ");
					String name = sc.nextLine();
					System.out.println("국어 점수를 입력하세요 > ");
					int kor = Integer.parseInt(sc.nextLine());
					System.out.println("영어 점수를 입력하세요 > ");
					int eng = Integer.parseInt(sc.nextLine());
					System.out.println("수학 점수를 입력하세요 > ");
					int math = Integer.parseInt(sc.nextLine());
					
					int addSuccess = studentDAO.addStudent(name, kor, eng, math);
					
					// success
					if(addSuccess == 0) System.out.println("신규 학생 등록에 실패하였습니다");
					else System.out.println("신규 학생 등록에 성공하였습니다");
					
					break;
				
				case 2:
					/**  학생 목록 출력 **/
					ArrayList<StudentDTO> studentList = studentDAO.studentList();
					if(studentList.size() == 0) System.out.println("등록된 학생이 없습니다");
					else {
						System.out.println("학번 \t 이름 \t 국어 \t 영어 \t 수학 \t 총점 \t 평균\t 날짜");
						for(StudentDTO student: studentList) {
							System.out.println(student.getId() + "\t" +
											   student.getName() + "\t" + 
											   student.getKor() + "\t" + 
											   student.getEng() + "\t" + 
											   student.getMath() + "\t" + 
											   student.getSum() + "\t" + 
											   student.getAvg() + "\t" + 
											   student.getWrite_date());
						}
					}
					break;
				
				case 3:
					/** 학생 정보 검색 **/
					System.out.println("<<< 학생 정보 검색 >>>");
					System.out.println("학생의 이름을 입력해주세요");
					String searchName = sc.nextLine();
					
					ArrayList<StudentDTO> searchStudents = studentDAO.searchStudentInfo(searchName);
					if(searchStudents.size() == 0) System.out.println("검색에 해당하는 학생이 없습니다.");
					else {
						System.out.println("학번 \t 이름 \t 국어 \t 영어 \t 수학 \t 총점 \t 평균\t 날짜");
						for(StudentDTO student: searchStudents) {
							System.out.println(student.getId() + "\t" +
											   student.getName() + "\t" + 
											   student.getKor() + "\t" + 
											   student.getEng() + "\t" + 
											   student.getMath() + "\t" + 
											   student.getSum() + "\t" + 
											   student.getAvg() + "\t" + 
											   student.getWrite_date());
						}
					}
					break;
				
				case 4:
					/** 학생 정보 삭제 **/
					System.out.println("<<< 학생 정보 삭제 >>>");
					System.out.println("삭제할 학생의 학번을 입력해주세요");
					int studentCode = Integer.parseInt(sc.nextLine());
					
					int deleteSuccess = studentDAO.deleteStudent(studentCode);
					
					// success
					if(deleteSuccess == 0) System.out.println("학생 정보 삭제에 실패했습니다.");
					else System.out.println("학생 정보가 삭제되었습니다.");
					break;
				
				case 5:
					/** 학생 정보 수정 **/
					System.out.println("<<< 학생 정보 수정 >>>");
					System.out.println("정보를 수정할 학생의 학번을 입력해주세요");
					int studentid = Integer.parseInt(sc.nextLine());
					
					Boolean searchCode =  studentDAO.searchStudent(studentid);
					
					if(!searchCode) System.out.println("해당 학생이 없습니다.");
					else {
						System.out.println("학생의 국어 점수를 입력해주세요");
						int updateKor = Integer.parseInt(sc.nextLine());
						System.out.println("학생의 영어 점수를 입력해주세요");
						int updateEng = Integer.parseInt(sc.nextLine());
						System.out.println("학생의 수학 점수를 입력해주세요");
						int updateMath = Integer.parseInt(sc.nextLine());
						
						int updateSuccess = studentDAO.updateStudent(studentid, updateKor, updateEng, updateMath);
						// success
						if(updateSuccess == 0) System.out.println("학생 정보 수정에 실패했습니다.");
						else System.out.println("학생 정보가 수정되었습니다.");
					}
					
					break;
				
				case 6:
					/** 시스템 종료 **/
					System.out.println("시스템이 종료됩니다.");
					System.exit(0);
					
				default:
					/** 입력 데이터 오류 **/
					System.out.println("번호를 잘못 입력하였습니다.");
					break;
			}
				
		}
		
	}

}
