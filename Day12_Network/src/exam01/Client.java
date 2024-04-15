package exam01;

import java.io.DataInputStream;
import java.io.InputStream;
import java.net.Socket;

public class Client {

	public static void main(String[] args) throws Exception {
		
		// 접속 대상 (IP, Port)
		Socket client = new Socket("192.168.0.X", 12345);
		
		// 기본 스트림 생성: Input Stream을 열었으나 사용하기 어려운 형태
		InputStream is =  client.getInputStream();
		
		// 업그레이드 스트림: Input Stream을 사용하기 편한 상태로 업그레이드
		DataInputStream dis = new DataInputStream(is);
		
		while(true) {
			// Server의 write()와 형태를 맞춰야 한다.
			String msg = dis.readUTF();
			
			System.out.println(msg);
		}
		
	}

}
