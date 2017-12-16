import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Q-ays.
 * 12-16-2017 21:39
 */
public class ServerBeta {

    static volatile  Map<Socket, PrintWriter> map = new ConcurrentHashMap<>();

    static class ThreadPool implements Runnable{
        Socket socket = null;

        public ThreadPool(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run(){
            System.out.println(Thread.currentThread().getName() + " connected!");

            try (InputStream is = socket.getInputStream();
                 InputStreamReader ir = new InputStreamReader(is);
                 BufferedReader br = new BufferedReader(ir);
                 OutputStream os = socket.getOutputStream();
                 PrintWriter pw = new PrintWriter(os)) {

                map.put(socket, pw);
                System.out.println("current active: " + map.size());

                String info;
                while ((info = br.readLine()) != null) {
                    System.out.println(socket.getInetAddress().toString() + ":" + socket.getPort() + ">>" + info);

                    for (Map.Entry<Socket, PrintWriter> entry : map.entrySet()) {
                        PrintWriter pw1 = entry.getValue();

                        pw1.write(socket.getInetAddress().toString() + ":" + socket.getPort() + ">>" + info + "\n");

                        pw1.flush();
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    socket.close(); //closes socket;
                    System.out.println("socket closed");
                } catch (IOException e) {
                    e.printStackTrace();
                }

                map.remove(socket); //removes socket from map
                System.out.println("map remove socket");
            }
        }
    }

    public static void main(String[] args) {

        int max = 5;

        try {
            ServerSocket serverSocket = new ServerSocket(18888, 1);

            ExecutorService fixedThreadPool = Executors.newFixedThreadPool(max);

            while (true) {
                if (map.size() < max) {

                    Socket socket = serverSocket.accept();

                    fixedThreadPool.execute(new ServerBeta.ThreadPool(socket));
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
