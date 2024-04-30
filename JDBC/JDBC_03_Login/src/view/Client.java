package view;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		try {
			Socket client = new Socket("192.168.1.8", 35000);
			
			DataOutputStream dos = new DataOutputStream(client.getOutputStream());
			DataInputStream dis = new DataInputStream(client.getInputStream());
			
			boolean isLogin = false;
			String sessionId = "";
			
			while(true) {
				System.out.println("<< Login >>");
				System.out.println("1. 로그인");
				System.out.println("2. 회원가입");
				System.out.println("0. 종료");
				String input = sc.nextLine();
				
				if(input.equals("1")) {
					System.out.println("<< 로그인 >>");
					System.out.print("ID : ");
					String id = sc.nextLine();
					System.out.print("PW : ");
					String pw = sc.nextLine();
					
					dos.writeUTF("1");
					dos.writeUTF(id);
					dos.writeUTF(pw);
					dos.flush();
					
					String res = dis.readUTF();
					System.out.println(res);
					
					if(res.equals("로그인 성공")) {
						sessionId = id;
						isLogin = true;
						break;
					}
					
				} else if(input.equals("2")) {
					System.out.println("<< 회원 가입 >>");
					System.out.print("ID : ");
					String id = sc.nextLine();
					System.out.print("PW : ");
					String pw = sc.nextLine();
					System.out.print("Name : ");
					String name = sc.nextLine();
					
					dos.writeUTF("2");
					dos.writeUTF(id);
					dos.writeUTF(pw);
					dos.writeUTF(name);
					dos.flush();
					
					String res = dis.readUTF();
					System.out.println(res);
					
				} else if(input.equals("0")) {
					System.out.println("시스템을 종료합니다.");
					System.exit(0);
					
				} else {
					System.out.println("잘못 입력함!!!");
				}
				
			}
			
			if(isLogin) {
				System.out.println("                        ____                                 __ ");
				System.out.println(" /'\\_/`\\               /\\  _`\\                              /\\ \\");
				System.out.println("/\\      \\    __  __    \\ \\ \\L\\ \\   __        __        __   \\ \\ \\ ");
				System.out.println("\\ \\ \\__\\ \\  /\\ \\/\\ \\    \\ \\ ,__/ /'__`\\    /'_ `\\    /'__`\\  \\ \\ \\ ");
				System.out.println(" \\ \\ \\_/\\ \\ \\ \\ \\_\\ \\    \\ \\ \\/ /\\ \\L\\.\\_ /\\ \\L\\ \\  /\\  __/   \\ \\_\\");
				System.out.println("  \\ \\_\\\\ \\_\\ \\/`____ \\    \\ \\_\\ \\ \\__/.\\_\\\\ \\____ \\ \\ \\____\\   \\/\\_\\");
				System.out.println("   \\/_/ \\/_/  `/___/> \\    \\/_/  \\/__/\\/_/ \\/___L\\ \\ \\/____/    \\/_/");
				System.out.println("                 /\\___/                      /\\____/");
				System.out.println("                 \\/__/                       \\_/__/ ");
				System.out.println();
				System.out.println("\t\t\t 안녕하세요 '" + sessionId + "'님 환영합니다.");
			}

			
		} catch (Exception e) {
			System.out.println("Error : " + e);
		}

	}

}
