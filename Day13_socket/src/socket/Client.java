package socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) {
		
		/**
	 	 ┌──────────────────────────────────────────────────┐
		 │													│
		 │	Socket Study									│
		 │	1. 컴퓨터와 컴퓨터끼리 전송							│
		 │	2. 내부 RAM <-> HDD 의 파일 전송	  				│
		 │													│
		 └──────────────────────────────────────────────────┘ 
		 **/
		
		Scanner sc = new Scanner(System.in);
		String ip = "192.168.0.161";
		
		try {
			
			Socket client = new Socket(ip, 30000);
			System.out.println(ip + "로 접속 성공");
			
			DataInputStream dis = new DataInputStream(client.getInputStream());
			DataOutputStream dos = new DataOutputStream(client.getOutputStream());
			
			int length = dis.readInt();
			System.out.println("=======================");
			System.out.println(ip + "의 파일 목록");
			for(int i=0; i<length; i++) {
				System.out.println(dis.readUTF());
			}
			
			System.out.println("=======================");
			System.out.print("다운받고 싶은 파일명 입력 >> ");
			String fileName = sc.nextLine();
			dos.writeUTF(fileName.trim());
			dos.flush();
			
			/**
			 * 	파일 전송받기
			 * 	1. 파일의 사이즈를 전송 받는다.
			 * 	2. RAM에 전송받은 파일 사이즈에 맞는 byte[] 배열을 만든다
			 * 	3. FileOutputStream 으로 저장 경로를 지정한다.
			 * 	4. 파일 전송에 용이하게 스트림을 업그레이드 한다.
			 * 	5. RAM으로 ReadFully 한 파일을 미리 만들어 놓은 byte[] 배열에 담는다
			 * 	6. RAM --> HDD로 이동
			 *  7. 인스턴스 종료
			 */
			
			// 1. 파일의 사이즈를 전송 받는다.
			long fileSize = dis.readLong();
			
			// 2. RAM에 전송받은 파일 사이즈에 맞는 byte[] 배열을 만든다
			byte[] targetFileName = new byte[(int) fileSize];
			
			// 3. FileOutputStream 으로 저장 경로를 지정한다.
			System.out.println("================================================");
			System.out.println("저장 경로 : C:/workspace/download/"+ fileName);
			System.out.println("================================================");
			FileOutputStream fos = new FileOutputStream("C:/workspace/download/test/"+ fileName);
			
			// 4. 파일 전송에 용이하게 스트림을 업그레이드 한다.
			DataOutputStream fileDos = new DataOutputStream(fos);
			
			// 5. RAM으로 ReadFully 한 파일을 미리 만들어 놓은 byte[] 배열에 담는다
			dis.readFully(targetFileName);
			
			// 6. RAM --> HDD로 이동
			fileDos.write(targetFileName);
			fileDos.flush();
			
			// 7. 인스턴스 종료
			fileDos.close();
			dis.close();
			dos.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(ip + "로 접속 실패");
		}
		

	}

}
