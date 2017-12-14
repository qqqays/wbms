import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Q-ays.
 * whosqays@gmail.com
 * 12-14-2017 10:38
 */
public class ServerThreadPool {
    static class ThreadPool implements Runnable{
        Socket socket = null;
        Map<Socket, PrintWriter> map = null;

        public ThreadPool(Socket socket, Map<Socket, PrintWriter> map) {
            this.socket = socket;
            this.map = map;
        }

        @Override
        public void run(){
            System.out.println(Thread.currentThread().getName() + " connected!");

            InputStream is = null;
            InputStreamReader ir = null;
            BufferedReader br = null;

            try {
                is = socket.getInputStream();

                ir = new InputStreamReader(is);

                br = new BufferedReader(ir);

                String info = null;

                while ((info = br.readLine()) != null) {
                    System.out.println(socket.getInetAddress().toString() + ":" + socket.getPort() + "-+--=>" + info);

                    for (Map.Entry<Socket, PrintWriter> entry : map.entrySet()) {
                        PrintWriter pw = entry.getValue();

                        pw.write(socket.getInetAddress().toString() + ": " + socket.getPort() + "-+--=>" + info + "\n");

                        pw.flush();
                    }
                }
                socket.shutdownInput();


                socket.shutdownOutput();

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    br.close();
                    ir.close();
                    is.close();
                    map.get(socket).close();
                    socket.close();
                    map.remove(socket);
                    System.out.println("socket closed");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        Map<Socket, PrintWriter> map = new ConcurrentHashMap<>();

        int max = 5;

        try {
            ServerSocket serverSocket = new ServerSocket(18888, 1);

            ExecutorService fixedThreadPool = Executors.newFixedThreadPool(max);

            while (true) {
                if (map.size() < max) {

                    Socket socket = serverSocket.accept();

                    map.put(socket, new PrintWriter(socket.getOutputStream()));

                    fixedThreadPool.execute(new ThreadPool(socket, map));

                    System.out.println("current active: " + map.size());
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
