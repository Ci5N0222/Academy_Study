package chat;

import java.io.DataInputStream;

public class Input extends Thread {
	public DataInputStream dis;
	
	public void run() {
		
		try {
			while(true) {
				String response = dis.readUTF();
				System.out.println("상대방 : " + response);
			}
			
			
		} catch (Exception e) {
			System.err.println("Error : " + e); 
			System.exit(0);
			
		}
	}
}
