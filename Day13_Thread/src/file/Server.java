package file;

import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) {
		
		try {
			ServerSocket server = new ServerSocket(4040);
			
			while(true) {
				Socket socket = server.accept();
				System.out.println(socket.getInetAddress() + "로 부터 접속");
				
				FileThread ft = new FileThread(socket);
				ft.start();
			}
			
		} catch (Exception e) {

		}
		

	}

}
