import org.json.JSONObject;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * BIO
 * <p>
 * Created by Q-ays.
 * 12-16-2017 21:39
 */
public class ServerBeta {

    //Stores socket and print writer of socket
    static volatile Map<Socket, PrintWriter> map = new ConcurrentHashMap<>();

    //Stores socket ip address
    static volatile Map<String, Long> limitMap = new HashMap<>();

    //password
    static volatile String password = "";

    static class ThreadPool implements Runnable {
        Socket socket = null;

        public ThreadPool(Socket socket) {
            this.socket = socket;
        }

        public boolean verification(String pw) {
            if (pw.equals(password)) {
                return true;
            } else {
                return false;
            }
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " connected!");

            try (InputStream is = socket.getInputStream();
                 InputStreamReader ir = new InputStreamReader(is);
                 BufferedReader br = new BufferedReader(ir);
                 OutputStream os = socket.getOutputStream();
                 PrintWriter pw = new PrintWriter(os)) {

                String info;
                String identity;

                //todo verifies
                for (int i = 0; ; i++) {

                    pw.write("Enter password: \n");
                    pw.flush();

                    if ((info = br.readLine()) != null)
                        if (verification(info)) {
                            pw.write("Connect success\r\n");
                            pw.write("Please input your name: \r\n");
                            pw.flush();

                            if ((identity = br.readLine()) == null) {
                                identity = UUID.randomUUID().toString();
                            }

                            pw.write(identity + ", welcome to join\r\n");
                            pw.write("You can type something here:\r\n");
                            pw.flush();

                            break;
                        } else {
                            pw.write("you type error password!\r\n");
                            pw.flush();
                            if (i > 2) {
                                limitMap.put(socket.getInetAddress().toString(), System.currentTimeMillis());
                                socket.close();
                            }
                        }
                }

                map.put(socket, pw);
                System.out.println("current active thread: " + map.size());

                while ((info = br.readLine()) != null) {
                    System.out.println(identity + "@" + socket.getInetAddress().toString() + ":" + socket.getPort() + ">>" + info);

                    for (Map.Entry<Socket, PrintWriter> entry : map.entrySet()) {
                        PrintWriter pw1 = entry.getValue();

                        pw1.write(identity + "@" + socket.getInetAddress().toString() + ":" + socket.getPort() + ">>" + info + "\n");

                        pw1.flush();
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    socket.close(); //closes socket;
                    System.out.println("Socket closed");
                } catch (IOException e) {
                    e.printStackTrace();
                }

                map.remove(socket); //removes socket from map
                System.out.println("Remove this socket from map, sizes : " + map.size());
            }
        }
    }

    public static void main(String[] args) {

        int max = 5; //The max number of thread pool

        int limitTime = 10 * 1000; //ms

        if (args.length > 0) {
            password = args[0];
        }

        try {
            ServerSocket serverSocket = new ServerSocket(18888, 1);

            ExecutorService fixedThreadPool = Executors.newFixedThreadPool(max);

            while (true) {
                if (map.size() < max) {

                    Socket socket = serverSocket.accept();

                    for (Map.Entry<String, Long> entry : limitMap.entrySet()) {
                        if (entry.getKey().equals(socket.getInetAddress().toString())) {
                            if (System.currentTimeMillis() < entry.getValue() + limitTime) {
                                socket.close();
                                break;
                            }
                        }
                    }

                    if (!socket.isClosed())
                        fixedThreadPool.execute(new ServerBeta.ThreadPool(socket));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
