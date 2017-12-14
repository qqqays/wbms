import java.io.*;
import java.net.Socket;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by Q-ays.
 * 12-11-2017 23:38
 */
public class ServerThread implements Runnable {
    Socket socket = null;

    Map<Socket,PrintWriter> map = null;

    public ServerThread(Socket socket, Map<Socket, PrintWriter> map) {
        this.socket = socket;
        this.map = map;
    }

    @Override
    public void run() {

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

                    pw.write(socket.getPort() + ": " + info + "\n");

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
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}
