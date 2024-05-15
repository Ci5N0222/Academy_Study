import javax.swing.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws Exception{

        // Setting port constructor of ServerSocket
        ServerSocket server = new ServerSocket(9000);

        Socket socket = server.accept();

        System.out.println(socket.getInetAddress() + "로 부터 접속");

        // Create streams for two-way communication
        DataInputStream dis = new DataInputStream(socket.getInputStream());
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

        while (true) {
            String msg = dis.readUTF();
            System.out.println(socket.getInetAddress() + " : " + msg);
            dos.writeUTF(JOptionPane.showInputDialog("보낼 세지를 입력하세요"));
            dos.flush();
        }

    }
}
