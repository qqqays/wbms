import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketAddress;

/**
 * Created by Q-ays.
 * 12-11-2017 20:19
 */
public class JavaSocket implements Runnable{

    public void run() {

        try {
            Socket socket = new Socket("192.168.1.3", 4567);

            OutputStream os = socket.getOutputStream();

            PrintWriter pw = new PrintWriter(os);

            pw.write("姓名陆果座位号7" );

            pw.flush();

            while (true) {

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        JavaSocket socket = new JavaSocket();

        Thread t = new Thread(socket);

        t.start();
     }
}
