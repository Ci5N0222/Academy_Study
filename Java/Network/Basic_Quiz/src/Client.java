import javax.swing.*;
import java.net.Socket;
import java.io.DataInputStream;
import java.io.DataOutputStream;

public class Client {
    public static void main(String[] args) throws Exception{

        /**
         *  [ Client ]
         *  1. 로또 번호 추천
         *  2. 현재 시간 요청
         *  3. 오늘의 명언
         */

        /** Client **/
        Socket client = new Socket("127.0.0.1", 9000);

        // Create streams for two-way communication
        DataInputStream dis = new DataInputStream(client.getInputStream());
        DataOutputStream dos = new DataOutputStream(client.getOutputStream());

        while(true) {

            // 서버측으로 보낼 input 값 (Param String)
            String input = JOptionPane.showInputDialog("<<< 데이터 요청 >>>\n" + "1. 로또 번호 추천\n" + "2. 현재 시간 요청\n" + "3. 오늘의 명언\n");
            dos.writeUTF(input);

            // 서버측으로 받은 Data (Return String)
            String msg = dis.readUTF();

            // 로또 번호 출력
            if(input.equals("1")) JOptionPane.showMessageDialog(null, "로또 추첨 번호\n" + msg);

            // 현재시간 출력
            else if(input.equals("2")) JOptionPane.showMessageDialog(null, "현재시간 : " + msg);

            // 명언 출력
            else if(input.equals("3")) JOptionPane.showMessageDialog(null, "오늘의 명언\n" + msg);

            // 오류 출력
            else System.out.println("입력값 오류 : " + input);

        }
    }
}
