package views;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

import dao.ContactDAO;
import dto.ContactDTO;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		ContactDAO dao = new ContactDAO();
		SimpleDateFormat sdf = new SimpleDateFormat("yy.MM.dd(E)");
		
		while(true) {
			System.out.println("<<< Contact 관리 프로그램 >>>");
			System.out.println("1. 신규 등록");
			System.out.println("2. 목록 출력");
			System.out.println("3. 항목 삭제");
			System.out.println("4. 항목 수정");
			System.out.println("5. 항목 검색");
			System.out.println("0. 시스템 종료");
			System.out.print(">>> ");
			
			int input = Integer.parseInt(sc.nextLine());
			try {
				/** 신규 등록 **/
				if(input == 1) {
					System.out.print("추가할 멤버의 이름을 입력하세요 >> ");
					String name = sc.nextLine();
					
					System.out.print("추가할 멤버의 핸드폰 번호를 입력하세요 >> ");
					String phone = sc.nextLine();
					
					int result = dao.addNewMember(name, phone);
					if(result == 0) System.out.println("멤버 등록에 실패하였습니다.");
					else System.out.println("멤버 등록에 성공하였습니다.");
				
					
				/** 목록 출력 **/
				} else if(input == 2) {
					List<ContactDTO> list = dao.memberList();
					if(list.size() == 0) System.out.println("등록된 멤버가 없습니다.");
					else {
						System.out.println("id \tname \tphone\t\t reg_date");
						for(ContactDTO dto: list) {
							System.out.println(dto.getId() + "\t" +
											   dto.getName() + "\t" +
											   dto.getPhone() + "\t" +
											   sdf.format(dto.getReg_date()));
						}
					}
					
					
				/** 항목 삭제 **/
				} else if(input == 3) {
					System.out.print("삭제할 멤버의 ID를 입력하세요 >> ");
					int id = Integer.parseInt(sc.nextLine());
					
					int result = dao.deleteMember(id);
					if(result == 0) System.out.println("멤버 삭제에 실패하였습니다");
					else System.out.println("멤버 삭제에 성공하였습니다.");
					
				
				/** 항목 수정 **/
				} else if(input == 4) {
					System.out.print("수정할 멤버의 ID를 입력하세요 >> ");
					int id = Integer.parseInt(sc.nextLine());
					
					int isId = dao.searchById(id);
					if(isId == 0) System.out.println("수정할 대상이 존재하지 않습니다.");
					else {
						System.out.print("수정할 멤버의 이름을 입력하세요 >> ");
						String name = sc.nextLine();
						
						System.out.print("수정할 멤버의 핸드폰 번호를 입력하세요 >> ");
						String phone = sc.nextLine();
						
						int result = dao.updateMember(id, name, phone);
						if(result == 0) System.out.println("멤버 수정에 실패하였습니다");
						else System.out.println("멤버 수정에 성공하였습니다.");
					}
					
					
				/** 항목 검색 **/
				} else if(input == 5) {
					System.out.print("검색할 멤버의 이름을 입력하세요 >> ");
					String name = sc.nextLine();
					
					List<ContactDTO> list = dao.searchMemberList(name);
					if(list.size() == 0) System.out.println("검색과 일치하는 멤버가 없습니다.");
					else {
						System.out.println("id \tname \tphone\t\t reg_date");
						for(ContactDTO dto: list) {
							System.out.println(dto.getId() + "\t" +
											   dto.getName() + "\t" +
											   dto.getPhone() + "\t" +
											   sdf.format(dto.getReg_date()));
						}
					}
					
					
				/** 시스템 종료 **/
				} else if(input == 0) {
					System.out.println("시스템 종료!!!");
					System.exit(0);
					
					
				/** 데이터 오입력 **/
				} else {
					System.err.println("입력값 오류!!!");
					
				}
				
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("오류가 발생했습니다.");
			}
			
			
		}

	}

}
