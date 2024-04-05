package quizs;

import java.util.Scanner;

import javax.swing.plaf.synth.SynthOptionPaneUI;

import classes.Contact;
import models.TelManager;

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
		TelManager tel = new TelManager();
		
		while(true) {
			System.out.println("<< 연락처 관리 프로그램 >>");
			System.out.println("1. 신규 연락처 등록");
			System.out.println("2. 연락처 목록 출력");
			System.out.println("3. 연락처 검색");
			System.out.println("4. 연락처 업데이트");
			System.out.println("5. 연락처 삭제");
			System.out.println("0. 프로그램 종료");
			System.out.println(">> ");
			
			int input = sc.nextInt();
			
			if(input == 1) {
				// 신규 연락처 등록
				System.out.println("이름을 입력해주세요 >> ");
				String name = sc.next();
				
				System.out.println("연락처를 입력해주세요 >> ");
				String phone = sc.next();
				
				String id = String.valueOf(1000 + tel.getIndex());

				Contact contact = new Contact(id, name, phone);
				tel.AddContact(contact);
				
			} else if(input == 2) {
				// 연락처 목록 출력
				if(tel.getIndex() == 0) {
					System.out.println("등록된 연락처가 없습니다.");
					continue;
				}
				Contact[] contact = tel.getContacts();
				System.out.println("ID\t 이름\t 연락처\t");
				for(int i=0; i<tel.getIndex(); i++) {
					System.out.println(contact[i].getId() +"\t"+
									   contact[i].getName() +"\t"+
									   contact[i].getPhone() +"\t");
				}
				
			} else if(input == 3) {
				// 연락처 검색
				System.out.println("검색할 번호를 입력해주세요.");
				String search = sc.next();
				
				Contact[] contact = tel.searchString(search);
				if(contact.length == 0) {
					System.out.println("연락처가 없습니다");
					continue;
				}
				
				System.out.println("ID\t 이름\t 연락처\t");
				for(int i=0; i<contact.length; i++) {
					if(contact[i].getPhone().contains(search)) {
						System.out.println(contact[i].getId() +"\t"+
										   contact[i].getName() +"\t"+
										   contact[i].getPhone() +"\t");
					}
				}
				
			} else if(input == 4) {
				// 연락처 업데이트
				System.out.println("변경을 원하는 ID를 입력하세요: ");
				String id = sc.next();
				System.out.println("변경하실 연락처의 입력하세요: ");
				String num = sc.next();
				int update = tel.updateContact(id, num);
				if(update == 1) {
					System.out.println("정상적으로 변경이 완료되었습니다.");
				} else {
					System.out.println("ID를 확인하고 다시 시도해주세요.");
				}
				
			} else if(input == 5) {
				// 연락처 삭제
				System.out.println("삭제를 원하는 ID를 입력하세요: ");
				String id = sc.next();
				int delete = tel.deleteContact(id);
				if(delete == 1) {
					System.out.println("정상적으로 삭제가 완료되었습니다.");
				} else {
					System.out.println("ID를 확인하고 다시 시도해주세요.");
				}
				
			} else if(input == 0) {
				// 프로그램 종료
				System.out.println("!!! 프로그램 종료 !!!");
				break;
			}
		}
	}
}

