package chatting.io;

import java.io.DataOutputStream;
import java.util.Scanner;

public class Output extends Thread {

    Scanner sc = new Scanner(System.in);
    public DataOutputStream dos;

    public void run() {

        try {
            while(true) {
                String msg = sc.nextLine();
                dos.writeUTF(msg);
                System.out.println("나 : " + msg);
            }

        } catch (Exception e) {
            System.err.println("Error : " + e);
            System.exit(0);

        }
    }
}
