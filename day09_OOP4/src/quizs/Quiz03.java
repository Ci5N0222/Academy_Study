package quizs;

import java.util.Scanner;

import javax.swing.plaf.synth.SynthOptionPaneUI;

import classes.Contact;

public class Quiz03 {

	public static void main(String[] args) {
		/**
		 *	연락처 관리 프로그램
		 *	1. 클래스 이름: Contact
		 *	2. 멤버 필드: id/ name / phone
		 *	3. 멤버 메서드: getter&setter / constructor / default constructor
		 * 	
		 *  CRUD 중 C, R 기능을 구현
		 *  이름 기반의 검색 기능 구현
		 *  1. 신규 연락처 등록
		 *  2. 연락처 목록 출력
		 *  3. 연락처 검색
		 *  4. 연락처 업데이트 (Update)
		 *  5. 연락처 삭제 (Delete)
		 *  0. 프로그램 종료
		 */
		
		Scanner sc = new Scanner(System.in);
		Contact[] contact = new Contact[10];
		int index = 0;
		
		while(true) {
			System.out.println("<< 연락처 관리 프로그램 >>");
			System.out.println("1. 신규 연락처 등록");
			System.out.println("2. 연락처 목록 출력");
			System.out.println("3. 연락처 검색");
			System.out.println("0. 프로그램 종료");
			System.out.println(">> ");
			
			int input = sc.nextInt();
			
			if(input == 1) {
				// 신규 연락처 등록
				System.out.println("이름을 입력해주세요 >> ");
				String name = sc.next();
				
				System.out.println("연락처를 입력해주세요 >> ");
				int phone = sc.nextInt();
				
				String id = String.valueOf(1001+index);
				System.out.println("id ==== " + id);
				contact[index] = new Contact(id, name, phone);
				index++;
			} else if(input == 2) {
				// 연락처 목록 출력
				if(index == 0) {
					System.out.println("등록된 연락처가 없습니다.");
					continue;
				}
				System.out.println("ID\t 이름\t 연락처\t");
				for(int i=0; i<index; i++) {
					System.out.println(contact[i].getId() +"\t"+
									   contact[i].getName() +"\t"+
									   contact[i].getPhone() +"\t");
				}
				
			} else if(input == 3) {
				int count = 0;
				System.out.println("검색할 번호를 입력해주세요.");
				String search = sc.next();
				// 연락처 검색
				System.out.println("ID\t 이름\t 연락처\t");
				for(int i=0; i<index; i++) {
					if(String.valueOf(contact[index].getPhone()).contains(search)) {
						System.out.println(contact[i].getId() +"\t"+
										   contact[i].getName() +"\t"+
										   contact[i].getPhone() +"\t");
						count++;
					}
				}
				if(count == 0) {
					System.out.println("검색한 연락처가 없습니다.");
				}
				
			} else if(input == 0) {
				// 프로그램 종료
				System.out.println("!!! 프로그램 종료 !!!");
				break;
			}
		}
		
		

	}

}

