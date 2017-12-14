import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Q-ays.
 * 12-11-2017 23:08
 */
public class Server {

    public static void main(String[] args) {

        Map<Socket, PrintWriter> map = new ConcurrentHashMap<>();

        Integer max = 3;

        try {
            ServerSocket serverSocket = new ServerSocket(18888, 1);

//            serverSocket.setSoTimeout(120000); //读操作超时，抛出异常连接未断开，资源不释放。

            ExecutorService fixedThreadPool = Executors.newFixedThreadPool(max);


            System.out.println("wait client link");

            while (true) {
                if (map.size() < max) {
                    Socket socket = serverSocket.accept();

                    map.put(socket, new PrintWriter(socket.getOutputStream()));

                    fixedThreadPool.execute(new ServerThread(socket, map));

                    System.out.println("current active: " + map.size());
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
