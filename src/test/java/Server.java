import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Q-ays.
 * 12-11-2017 23:08
 */
public class Server {

    public static void main(String[] args) {

        try {
            ServerSocket serverSocket = new ServerSocket(18888);

            System.out.println("wait client link");

            int count = 0 ;
            while (true) {
                Socket socket = serverSocket.accept();
                ServerThread st = new ServerThread(socket);

                st.start();
                System.out.println(count++);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
