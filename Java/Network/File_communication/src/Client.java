import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String ip = "127.0.0.1";

        DataInputStream dis = null;
        DataOutputStream dos = null;

        try {

            Socket client = new Socket(ip, 30000);
            System.out.println(ip + "로 접속 성공");

            dis = new DataInputStream(client.getInputStream());
            dos = new DataOutputStream(client.getOutputStream());

            int length = dis.readInt();
            System.out.println("=======================");
            System.out.println(ip + "의 파일 목록");
            for(int i=0; i<length; i++) {
                System.out.println(dis.readUTF());
            }

            System.out.println("=======================");
            System.out.print("다운받고 싶은 파일명 입력 >> ");
            String fileName = sc.nextLine();
            dos.writeUTF(fileName.trim());
            dos.flush();


            /**
             * 	파일 전송받기
             * 	1. 파일의 사이즈를 전송 받는다.
             * 	2. RAM에 전송받은 파일 사이즈에 맞는 byte[] 배열을 만든다
             * 	3. FileOutputStream 으로 저장 경로를 지정한다.
             * 	4. 파일 전송에 용이하게 스트림을 업그레이드 한다.
             * 	5. RAM으로 ReadFully 한 파일을 미리 만들어 놓은 byte[] 배열에 담는다
             * 	6. RAM --> HDD로 이동
             *  7. 인스턴스 종료
             */

            long fileSize = dis.readLong();
            byte[] targetFileName = new byte[(int) fileSize];
            System.out.println("=======================");
            System.out.println("저장 경로 : C:/workspace/download/"+ fileName);
            FileOutputStream fos = new FileOutputStream("C:/workspace/download/test/"+ fileName);
            DataOutputStream fileDos = new DataOutputStream(fos);

            // RAM --> My RAM (내 RAM에 미리 만들어 놓은 byte[]에 저장)
            dis.readFully(targetFileName);

            // RAM --> HDD
            fileDos.write(targetFileName);
            fileDos.flush();

            // 전송 인스턴스 종료
            fileDos.close();
            dis.close();
            dos.close();

        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(ip + "로 접속 실패");
        }

    }
}
