package chatting;

import chatting.io.Input;
import chatting.io.Output;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {

        try {
            // Client setting
            Socket cilent = new Socket("127.0.0.1", 9000);

            // Thread dataStream setting
            Input input = new Input();
            Output output = new Output();

            input.dis = new DataInputStream(cilent.getInputStream());
            output.dos = new DataOutputStream(cilent.getOutputStream());

            // Multi thread run
            output.start();
            input.start();

        } catch (Exception e) {
            System.err.println("Error : " + e);
            System.exit(0);

        }
    }
}
