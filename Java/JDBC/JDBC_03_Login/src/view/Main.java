package view;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import dao.MemberDAO;

public class Main {

	public static void main(String[] args) {
		
		MemberDAO dao = new MemberDAO();
		
		try {
			ServerSocket server = new ServerSocket(35000);
			Socket socket = server.accept();
			
			System.out.println(socket.getInetAddress() + "로 부터 접속");
			
			DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
			DataInputStream dis = new DataInputStream(socket.getInputStream());
			
			while(true) {
				String menu = dis.readUTF();
				
				if(menu.equals("1")) {
					
					String id = dis.readUTF();
					String pw = dis.readUTF();
					
					String res = dao.userExist(id, pw);
					
					dos.writeUTF(res);
					dos.flush();
					
				} else if(menu.equals("2")) {
					
					String id = dis.readUTF();
					String pw = dis.readUTF();
					String name = dis.readUTF();
					
					int result = dao.addMembers(id, pw, name);
					if(result == 0) dos.writeUTF("회원가입 실패");
					else dos.writeUTF("회원가입 성공");
					dos.flush();
					
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("오 류 발 생 !!!");
		}
		
	}

}
