package file;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.Socket;

public class FileThread extends Thread {

	private Socket client;
	
	public FileThread(Socket client) {
		this.client = client;
	}
	
	public void run() {
		
		try {
			DataInputStream dis = new DataInputStream(client.getInputStream());
			DataOutputStream dos = new DataOutputStream(client.getOutputStream());
			
			// 저장된 파일 목록의 경로
			String path = "C:/workspace/download/";
			
			// 경로에 있는 파일들을 배열로 만들기
			File list = new File(path);
			File[] filesList = list.listFiles();
			
			// 1. 파일 목록의 길이
			dos.writeInt(filesList.length);
			dos.flush();
			
			// 2. 파일 목록의 이름들
			for(File file: filesList) {
				dos.writeUTF(file.getName());
			}
			dos.flush();
			
			// 3. 클라이언트에게 원하는 파일명 입력받기
			String target = dis.readUTF();
			System.out.println("클라이어트가 원하는 파일 : " + target);
			
			// 4. 클라이언트가 원하는 파일 경로를 File 인스턴스로 만든다.
			File targetFile = new File(path + target);
			
			// 5. RAM에 File을 저장할 수 있는 공간을 byte[]로 만든다.
			byte[] targetFileName = new byte[(int) targetFile.length()];
			
			// 6. 대상 RAM 에게 File의 크기를 알려준다.
			dos.writeLong((int)targetFile.length());
			
			// 7. File 전송에 유리하게 데이터 스트림을 업그레이드 시킨다.
			FileInputStream fis = new FileInputStream(path + target);
			DataInputStream fileDis = new DataInputStream(fis);
			
			// 8. RAM에 미리 만들어 둔 byte[]배열 공간에 File을 저장한다.
			fileDis.readFully(targetFileName);
			
			// 9. 상대 RAM으로 byte[] 배열 전송 
			dos.write(targetFileName);
			
			// 10. 인스턴스 종료
			fileDis.close();
			dos.close();
			
		} catch (Exception e) {
			System.err.println(client.getInetAddress() + " 접속 해제");
		}
		
	}
	
}
