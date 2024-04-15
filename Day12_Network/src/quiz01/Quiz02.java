package quiz01;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Quiz02 {

	public static void main(String[] args) throws Exception {
		
		/**
		 *	서버
		 *  1. 클라이언트가 1번을 입력한 경우 로또번호를 생성하여 String 타입으로 반환
		 *  2. 클라이언트가 2번을 입력한 경우 현재 시간을 yyyy-MM-dd hh:mm:ss 형식으로 반환
		 *    
		 */
		
		// Server
		ServerSocket server = new ServerSocket(26000);
		Socket socket = server.accept();
		System.out.println(socket.getInetAddress() + "로 부터 접속");
		
		// create output stream 
		OutputStream os = socket.getOutputStream();
		DataOutputStream dos = new DataOutputStream(os);
		
		// create input stream
		InputStream is = socket.getInputStream();
		DataInputStream dis = new DataInputStream(is);
		
		while(true) {
			
			// 클라이언트로 부터 요청 받은 번호
			String msg = dis.readUTF();
			System.out.println("request : " + msg);
			String response = "";
			
			if(msg.equals("1")) {
				// 로또 번호 로직 return (String)
				Set<Integer> lottoNumberSet = new HashSet<>();
		        Random random = new Random();

		        while (lottoNumberSet.size() < 6) {
		            int randomNumber = random.nextInt(45) + 1;
		            lottoNumberSet.add(randomNumber); 
		        }

		        // 정렬된 문자열로 변환하여 반환
		        response = lottoNumberSet.stream()
	                             		 .map(Object::toString)
	                             		 .sorted()
	                             		 .reduce("", (acc, num) -> acc.isEmpty() ? num : acc + ", " + num);
				
			} else if(msg.equals("2")) {
				// 현재시간 반환 로직 return (yyyy-MM-dd hh:mm:ss, String)
				long ctime = System.currentTimeMillis();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
				response = sdf.format(ctime);
				
			} else {
				// 잘못된 번호 전송
				response = "잘못된 번호 입력";
			}
			
			System.out.println("전송된 데이터 : " + response);
			dos.writeUTF(response);
			dos.flush();
			
		}

	}

}
