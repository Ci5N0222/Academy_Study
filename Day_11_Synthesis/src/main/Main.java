package main;

import java.util.ArrayList;
import java.util.Scanner;

import dao.MusicDAO;
import dto.MusicDTO;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		MusicDAO musicDAO = new MusicDAO();
		
		while(true) {
			System.out.println("┌──────────── ──────────┐");
			System.out.println("│ << Melon 관리 시스템 >>	│ ");
			System.out.println("│ 1. 신규 음악 등록		│");
			System.out.println("│ 2. 음악 목록		│");
			System.out.println("│ 3. 음악 검색		│");
			System.out.println("│ 4. 항목 삭제		│");
			System.out.println("│ 5. 항목 수정		│");
			System.out.println("│ 6. 시스템 종료		│");
			System.out.println("└─────────── ───────────┘");
			System.out.println(" >>> ");
			int input = Integer.parseInt(sc.nextLine());
			
			
			if(input == 1) {
				/** 신규 음악 등록 **/
				// Mock-data
				 musicDAO.addMusic(new MusicDTO(musicDAO.getId(), "좋은날", "아이유"));
				 musicDAO.addMusic(new MusicDTO(musicDAO.getId(), "너랑나", "아이유"));
				
				System.out.println("제목을 입력해주세세요 : ");
				String title = sc.nextLine();
				System.out.println("가수명을 입력해주세세요 : ");
				String singer = sc.nextLine();
				int success = musicDAO.addMusic(new MusicDTO(musicDAO.getId(), title, singer));
				
				// success
				if(success == 1) System.out.println("등록이 성공적으로 완료되었습니다");
				else System.err.println("등록에 실패하였습니다");
				
			} else if(input == 2) {
				/** 음악 목록 출력 **/ 
				ArrayList<MusicDTO> list = musicDAO.musicList();
				if(list.size() == 0) System.err.println("등록된 음원이 없습니다");
				else {
					System.out.println("ID\t제목\t가수\t등록날짜\t\t업데이트");
					for(MusicDTO detail: list) {
						System.out.println(detail.getId() +"\t"+
										   detail.getTitle() +"\t"+
										   detail.getSinger() +"\t"+
										   detail.getWrite_date() +"\t"+
										   detail.getUpdate_date());
					}
				}
				
			} else if(input == 3) {
				/** 음악 검색 **/
				System.out.println("제목을 검색해주세요");
				String title = sc.nextLine();
				ArrayList<MusicDTO> list = musicDAO.searchAllMusic(title);
				if(list.size() == 0) System.err.println("등록된 음원이 없습니다");
				else {
					System.out.println("ID\t제목\t가수\t등록날짜\t\t업데이트");
					for(MusicDTO detail: list) {
						System.out.println(detail.getId() +"\t"+
										   detail.getTitle() +"\t"+
										   detail.getSinger() +"\t"+
										   detail.getWrite_date() +"\t"+
										   detail.getUpdate_date());
					}
				}
				 
			} else if(input == 4) {
				/** 음원 삭제 **/
				System.out.println("[음원 삭제]");
				System.out.println("ID를 입력해 주세요");
				int id = Integer.parseInt(sc.nextLine());
				int success = musicDAO.deleteMusic(id);
				
				// success
				if(success == 1) System.out.println("삭제가 정상적으로 처리되었습니다");
				else System.err.println("삭제하려는 음원의 아이디를 확인해주세요");
				
			} else if(input == 5) {
				/** 음원 수정 **/
				System.out.println("[음원 수정]");
				System.out.println("ID를 입력해 주세요");
				int id = Integer.parseInt(sc.nextLine());
				MusicDTO music = musicDAO.searchMusic(id);
				
				// ID validate
				if(music == null) {
					System.out.println("해당 ID에 맞는 음원이 없습니다.");
				} else {
					System.out.println("제목을 입력해 주세요");
					String title = sc.nextLine();
					System.out.println("가수를 입력해 주세요");
					String singer = sc.nextLine();
					int success = musicDAO.updateMusic(new MusicDTO(id, title, singer));
					
					// success
					if(success == 1) System.out.println("수정이 정상적으로 처리되었습니다");
					else System.err.println("수정 중 오류가 발생했습니다");
				}
				
			} else if(input == 6) {
				/** 시스템 종료 **/
				System.out.println("!!! 시스템 종료 !!!");
				break;
				
			} else {
				/** 잘못된 입력 **/
				System.err.println("!!! 잘못된 숫자 입력 !!!");
			}
			
		}
		
		
	}

}

