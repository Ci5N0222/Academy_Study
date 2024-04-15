package quiz01;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import javax.swing.JOptionPane;

public class Quiz01 {

	public static void main(String[] args) throws Exception {
		
		/**
		 *  [ Client ]
		 *  1. 로또 번호 추천
		 *  2. 현재 시간 요청 
		 *  3. 입력창 ( >> )
		 *  
		 */
		
		/** Client **/ 
		Socket client = new Socket("192.168.0.202", 26000);
		
		// Create input Stream
		InputStream is = client.getInputStream();
		DataInputStream dis = new DataInputStream(is);
		
		// Create output Stream
		OutputStream os = client.getOutputStream();
		DataOutputStream dos = new DataOutputStream(os);
		
		while(true) {
			
			// 서버측으로 보낼 input 값 (Param String)
			String input = JOptionPane.showInputDialog("<<< 데이터 요청 >>>\n" + "1. 로또 번호 추천\n" + "2. 현재 시간 요청\n");
			dos.writeUTF(input);
			
			// 서버측으로 받은 Data (Return String)
			String msg = dis.readUTF();
			
			// 로또 번호 출력
			if(input.equals("1")) JOptionPane.showMessageDialog(null, "로또 추첨 번호\n" + msg);
			
			// 현재시간 출력
			else if(input.equals("2")) JOptionPane.showMessageDialog(null, "현재시간 : " + msg);
			
			// 오류 출력
			else System.out.println("입력값 오류 : " + input); 
			
		}
		
	}

}
