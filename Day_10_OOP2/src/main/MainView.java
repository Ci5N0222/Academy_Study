package main;

import java.util.Scanner;

import classes.Gold;
import classes.Silver;
import dao.MemberManager;

public class MainView {

	public static void main(String[] args) {
		
		/**
		 *  회원 관리 시스템
		 *	- Main (View): 화면구성
		 *	<< 회원 관리 시스템 >>
		 *	1. 신규 회원 등록
		 *  2. 회원 목록 출력
		 *  0. 시스템 종료
		 *  
		 * - silver (data): 데이터 저장
		 *   멤버 필드: id, name, point
		 *   멤버 메서드: setter, getter, constructor, default constructor, getBonus(멤버의 point 값 *0.02)
		 * 
		 * - MemberManager (data): 데이터 관리
		 *   silver 인스턴스를 최대 10개까지 저장할 수 있는 배열 members, index
		 *   멤버 메서드: addMember(), getMembers()
		 *   
		 *   
		 *  추가 사항
		 *  	1. 골드 등급 추가 요청 --> Gold 클래스 추가 작업 진행
		 *  
		 *  추가 작업을 진행한 현 회원관리 시스템의 치명적인 문제점
		 *  	1. 코드 중복: 같은 코드로 작성된 클래스가 중복됨
		 *  	  --> 상속을 이용하여 해결
		 *		2. 코드 결합도: 유지보수 및 처리에 불편함 (MemberManager의 클래스 간 의존도가 높다 (결합도가 높다))
		 *		  --> 다형성을 이용하여 해결
		 * 		3. 저장소 문제: 배열이라는 것 자체가 저장소로 부적합하다.
		 * 		  --> 컬렉션을 이용하여 해결
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
//				// Create new members
//				int point = 1000;
//				System.out.println("아이디를 입력해주세요.");
//				String id = sc.nextLine();
//				System.out.println("이름을 입력해주세요.");
//				String name = sc.nextLine();
//				int success = manager.addMember(id, name, point);
//				
//				// Create success or fail
//				if(success == 1) System.out.println("!!! 회원 등록 성공 !!!");
//				else System.out.println("더 이상 회원을 추가할 수 없습니다.");
				manager.addMember("sv1", "kim", 1000);
				manager.addMember("sv2", "lee", 2000);
				manager.addGoldMember("gd1", "park", 5000);
				
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
				
				Gold[] gold = manager.getGoldMembers();
				if(gold == null && silver == null) System.out.println("등록된 회원이 없습니다");
				else {
					if(silver == null)System.out.println("ID\t이름\t포인트\t보너스");
					for(int i=0; i<manager.getGoldIndex(); i++) {
						System.out.println(gold[i].getId() + "\t" +
										   gold[i].getName() + "\t" +
									  	   gold[i].getPoint() + "\t" +
										   gold[i].getBonus() + "\t");
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


