package chat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) {
		
		try {
			ServerSocket server = new ServerSocket(29000);
			Socket socket = server.accept();
			System.out.println(socket.getInetAddress() + "님과의 대화");
		
			Input input = new Input();
			Output output = new Output();
			input.dis = new DataInputStream(socket.getInputStream());
			output.dos = new DataOutputStream(socket.getOutputStream());
			
			output.start();
			input.start();
			
		} catch (Exception e) {
			System.err.println("Error : " + e); 
			System.exit(0);
			
		}

	}

}
