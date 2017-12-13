import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Q-ays.
 * 12-11-2017 23:08
 */
public class Server {

    public static void main(String[] args) {

        Map<Socket, PrintWriter> map = new ConcurrentHashMap<>();

        try {
            ServerSocket serverSocket = new ServerSocket(18888);

            System.out.println("wait client link");

            int count = 0 ;
            while (true) {
                Socket socket = serverSocket.accept();
                map.put(socket, new PrintWriter(socket.getOutputStream()));
                ServerThread st = new ServerThread(socket, map);

                st.start();
                System.out.println(count++);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
