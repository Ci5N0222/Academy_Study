package main;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;


public class Client {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		InputStream is = null;
		DataInputStream dis = null;
		
		OutputStream os = null;
		DataOutputStream dos = null;
		
		try {
			Socket client = new Socket("192.168.0.201", 26000);
			
			is = client.getInputStream();
			dis = new DataInputStream(is);
			
			os = client.getOutputStream();
			dos = new DataOutputStream(os);
			
			while(true) {
	
				System.out.println("┌──────────────────────────────┐");
				System.out.println("│ <<< Netflix 영화 관리 시스템 >>> │");
				System.out.println("│ 1. 신규 영화 등록		       │");
				System.out.println("│ 2. 영화 목록 출력		       │");
				System.out.println("│ 3. 영화 검색	               │");
				System.out.println("│ 4. 영화 삭제	               │");
				System.out.println("│ 5. 영화 정보 변경	               │");
				System.out.println("│ 0. 시스템 종료         　  　 　  │");
				System.out.println("└──────────────────────────────┘");
				System.out.print(" >>> ");
				
				String input = sc.nextLine();
				
				/** 신규 영화 등록 **/
				if(input.equals("1")) {
					System.out.print("ID를 입력하세요 : ");
					String id = sc.nextLine();
					System.out.print("제목을 입력하세요 : ");
					String title = sc.nextLine();
					System.out.print("장르를 입력하세요 : ");
					String genre = sc.nextLine();
					
					// Request
					dos.writeUTF(input);
					dos.writeUTF(id);
					dos.writeUTF(title);
					dos.writeUTF(genre);
					dos.flush();

				/** 영화 목록 출력 **/
				} else if(input.equals("2")) {
					
					// Request
					dos.writeUTF(input);
					dos.flush();
					
					// Response
					String[] arr = dis.readUTF().split(",");
					if(arr.length == 0) System.out.println("등록된 영화가 없습니다.");
					else {
						String result = "";
						for(int i=0; i<arr.length; i++) {
							result += arr[i] + "\t";
						}
						System.out.println("ID\t 제목\t 장르\t 개봉날짜");
						System.out.println(result);
					}
						
				/** 영화 검색 **/
				} else if(input.equals("3")) {
					System.out.print("제목을 입력하세요 : ");
					String title = sc.nextLine();
					
					// Request 
					dos.writeUTF(input);
					dos.writeUTF(title);
					dos.flush();
					
					// Response
					String[] arr = dis.readUTF().split(",");
					if(arr.length == 0) System.out.println("등록된 영화가 없습니다.");
					else {
						String result = "";
						for(int i=0; i<arr.length; i++) {
							result += arr[i] + "\t";
						}
						System.out.println("ID\t 제목\t 장르\t 개봉날짜");
						System.out.println(result);
					}
					
				/** 영화 삭제 **/
				} else if(input.equals("4")) {
					System.out.print("ID를 입력하세요 : ");
					String id = sc.nextLine();
					
					// Request
					dos.writeUTF(input);
					dos.writeUTF(id);
					dos.flush();
					
					
				/** 영화 정보 변경 **/
				} else if(input.equals("5")) {
					System.out.print("ID를 입력하세요 : ");
					String id = sc.nextLine();
					System.out.print("제목을 입력하세요 : ");
					String title = sc.nextLine();
					System.out.print("장르를 입력하세요 : ");
					String genre = sc.nextLine();
					
					// Request
					dos.writeUTF(input);
					dos.writeUTF(id);
					dos.writeUTF(title);
					dos.writeUTF(genre);
					dos.flush();
					
				/** 시스템 종료 **/
				} else if(input.equals("0")) {
					System.out.println("시스템 종료!!!");
					System.exit(0);
					
				/** 입력 오류 **/
				} else {
					System.out.println("잘못된 번호 입력!!");
				}
			}
			
			
		} catch (Exception e) {
			System.out.println("Error : " + e);
			System.exit(0);
		}		
	
	}
}
