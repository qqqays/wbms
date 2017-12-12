import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * Created by Q-ays.
 * whosqays@gmail.com
 * 12-12-2017 8:33
 */
public class ClientThread extends Thread {

    Socket socket = null;

    public ClientThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {

        InputStream is = null;

        InputStreamReader ir = null;

        BufferedReader br = null;
        try {
            is = socket.getInputStream();

            ir = new InputStreamReader(is);

            br = new BufferedReader(ir);

            String info = null;

            while ((info = br.readLine()) != null) {
                System.out.println(info);
            }

//            socket.shutdownInput();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
                ir.close();
                is.close();
            } catch (Exception e) {

            }
        }

    }
}
