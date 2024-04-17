package exam;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Exam01 {
	public static void main(String[] args) {
			
		Scanner sc = new Scanner(System.in);
		
		try {
			Socket client = new Socket("192.168.0.161", 40000);
			
			DataInputStream dis = new DataInputStream(client.getInputStream());
			DataOutputStream dos = new DataOutputStream(client.getOutputStream());
			while(true) {
				System.out.print("보낼 메시지 : ");
				String msg = sc.nextLine();
				dos.writeUTF(msg);
			}
			
		} catch (Exception e) {
			System.err.println("Error : " + e);
		}
		
		
	}
}
