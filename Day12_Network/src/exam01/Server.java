package exam01;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JOptionPane;

public class Server {

    public static void main(String[] args) throws Exception {

        // 생성자에 port 번호
        ServerSocket server = new ServerSocket(26000);

        // 생성자에 입력한 포트 허가 및 대기
        Socket socket = server.accept();

        System.out.println(socket.getInetAddress() + "로 부터 접속");

        // 기본스트림 생성: Output Stream을 열었으나 사용하기 힘든 형태
        OutputStream os = socket.getOutputStream();

        // 업그레이드 스트림: Output Stream을 사용하기 편한 상태로 업그레이드
        DataOutputStream dos = new DataOutputStream(os);
        
        // 양방향 통신을 위해 인풋 스트림 추가
        InputStream is = socket.getInputStream();
        DataInputStream dis = new DataInputStream(is);
        
        while(true){
            // writeUTF
            dos.writeUTF(JOptionPane.showInputDialog("보낼 메세지를 입력하세요"));

            // 메시지가 작성되어도 데이터를 보내지 않기 떄문에 강제로 보내준다.
            dos.flush();

            String msg = dis.readUTF();
            System.out.println("Client : " + msg);
        }
        
	}

}
