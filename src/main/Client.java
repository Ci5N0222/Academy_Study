package main;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import javax.swing.JOptionPane;


public class Client {
	public static void main(String[] args) {
		
		InputStream is = null;
		DataInputStream dis = null;
		
		OutputStream os = null;
		DataOutputStream dos = null;
		
		
		try {
			Socket client = new Socket("127.0.0.1", 26000);
			
			is = client.getInputStream();
			dis = new DataInputStream(is);
			
			os = client.getOutputStream();
			dos = new DataOutputStream(os);
			
			while(true) {
				
				// 서버측으로 보낼 input 값 (Param String)
				String input = JOptionPane.showInputDialog("<<< 데이터 요청 >>>\n" + "1. 로또 번호 추천\n" + "2. 현재 시간 요청\n" + "3. 오늘의 명언\n");
				dos.writeUTF(input);
				
				// 서버측으로 받은 Data (Return String)
				String msg = dis.readUTF();
				
				// 회원 정보 출력
				if(input.equals("1")) JOptionPane.showMessageDialog(null, "로또 추첨 번호\n" + msg);
			}
			
			
		} catch (Exception e) {
			System.out.println("Error : " + e);
			System.exit(0);
		}
		
				
	
	}
}
