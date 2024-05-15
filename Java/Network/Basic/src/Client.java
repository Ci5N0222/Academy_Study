import javax.swing.*;
import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {

        // Connect Server setting (IP, Port)
        Socket client = new Socket("127.0.0.1", 9000);

        // Create streams for two-way communication
        DataInputStream dis = new DataInputStream(client.getInputStream());
        DataOutputStream dos = new DataOutputStream(client.getOutputStream());

        while (true) {
            dos.writeUTF(JOptionPane.showInputDialog("보낼메시지를 입력하세요"));
            dos.flush();
            String msg = dis.readUTF();
            System.out.println("Server received: " + msg);
        }
    }
}