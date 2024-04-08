package main;

import java.util.Scanner;

import classes.Silver;
import dao.MemberManager;

public class MainView {

	public static void main(String[] args) {
		
		/**
		 *  회원 관리 시스템
		 *  1. 신규회원 등록
		 *  2. 회원 목록 출력
		 *  
		 *  추가 사항
		 *  1. 골드 등급 추가 요청
		 */
		
		Scanner sc = new Scanner(System.in);
		MemberManager manager = new MemberManager();
		
		while(true) {
			System.out.println("<< 회원 관리 시스템 >>");
			System.out.println("1. 신규 회원 등록");
			System.out.println("2. 회원 목록");
			System.out.println("0. 시스템 종료");
			System.out.println(">> ");
			int input = Integer.parseInt(sc.nextLine());
			
			if(input == 1) {
				// Create new members
				int point = 1000;
				System.out.println("아이디를 입력해주세요.");
				String id = sc.nextLine();
				System.out.println("이름을 입력해주세요.");
				String name = sc.nextLine();
				int success = manager.addMember(id, name, point);
				
				// Create success or fail
				if(success == 1) System.out.println("!!! 회원 등록 성공 !!!");
				else System.out.println("더 이상 회원을 추가할 수 없습니다.");
				
			} else if(input == 2) {
				// Members list
				Silver[] silver = manager.getMembers();
				if(silver == null) System.out.println("등록된 회원이 없습니다");
				else {
					System.out.println("ID\t이름\t포인트\t보너스");
					for(int i=0; i<manager.getIndex(); i++) {
						System.out.println(silver[i].getId() + "\t" +
										   silver[i].getName() + "\t" +
										   silver[i].getPoint() + "\t" +
										   silver[i].getBonus() + "\t");
					}
				}
				
			} else if(input == 0) {
				// Power off
				System.out.println("!!! 시스템이 종료됩니다 !!!");
				break;
				
			} else {
				System.out.println("!!! 잘못된 번호 입력 !!!");
			}
			
		}
		
	}

}


