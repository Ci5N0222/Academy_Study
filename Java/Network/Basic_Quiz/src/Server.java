import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Server {
    public static void main(String[] args) throws Exception{

        /**
         *	[ Server ]
         *  1. 클라이언트가 1번을 입력한 경우 로또번호를 생성하여 String 타입으로 반환
         *  2. 클라이언트가 2번을 입력한 경우 현재 시간을 String(yyyy-MM-dd hh:mm:ss) 형식으로 반환
         *  3. 클라이언트가 3번을 입력한 경우 3개의 명언중 랜덤하게 한개를 String 타입으로 반환
         */

        String[] array = new String[] {
                "잠을 자도 피로가 안 풀리냐 - 박명수",
                "원수는 직장에서 만난다 - 박명수",
                "늦었다고 생각할 때가 진짜 너무 늦었다 - 박명수"
        };

        /** Server **/
        ServerSocket server = new ServerSocket(26000);
        Socket socket = server.accept();
        System.out.println(socket.getInetAddress() + "로 부터 접속");

        // Create streams for two-way communication
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
        DataInputStream dis = new DataInputStream(socket.getInputStream());

        while(true) {

            // 클라이언트로 부터 요청 받은 번호
            String msg = dis.readUTF();
            System.out.println("request : " + msg);

            // Return data save
            String response = "";

            if(msg.equals("1")) {
                // 로또 번호 로직 ( Return String )
                Set<Integer> lottoNumberSet = new HashSet<>();
                Random random = new Random();

                while (lottoNumberSet.size() < 6) {
                    int randomNumber = random.nextInt(45) + 1;
                    lottoNumberSet.add(randomNumber);
                }
                response = lottoNumberSet.stream()
                        .map(Object::toString)
                        .sorted()
                        .reduce("", (acc, num) -> acc.isEmpty() ? num : acc + ", " + num);

            } else if(msg.equals("2")) {
                // 현재시간 반환 로직 ( Return String -> yyyy-MM-dd hh:mm:ss )
                long ctime = System.currentTimeMillis();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                response = sdf.format(ctime);

            } else if(msg.equals("3")) {
                // 랜덤 명언 반환 로직 ( Return String )
                Random random = new Random();
                int randomIndex = random.nextInt(array.length);
                response = array[randomIndex];

            }else {
                // 잘못된 번호 전송
                response = "잘못된 번호 입력";
            }

            System.out.println("전송된 데이터 : " + response);
            dos.writeUTF(response);
            dos.flush();

        }

    }
}
