package chat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class Client {
	public static void main(String[] args) {
		
		try {
			// Client setting
			Socket cilent = new Socket("192.168.0.201", 29000);
		
			// Thread dataStream setting
			Input input = new Input();
			Output output = new Output();
			input.dis = new DataInputStream(cilent.getInputStream());
			output.dos = new DataOutputStream(cilent.getOutputStream());
			
			// Multi thread run
			output.start();
			input.start();
			
		} catch (Exception e) {
			System.err.println("Error : " + e); 
			System.exit(0);
			
		}
		
	}
}
