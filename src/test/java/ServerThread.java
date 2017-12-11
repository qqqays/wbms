import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.*;
import java.net.Socket;

/**
 * Created by Q-ays.
 * 12-11-2017 23:38
 */
public class ServerThread extends Thread {
    Socket socket = null;

    public ServerThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        InputStream is = null;
        InputStreamReader ir = null;
        BufferedReader br = null;
        OutputStream os  = null;
        PrintWriter pw  = null;
        try {
            is = socket.getInputStream();

            ir = new InputStreamReader(is);

            br = new BufferedReader(ir);

            String info = null;

            while ((info = br.readLine()) != null) {
                System.out.println(info);
            }
            socket.shutdownInput();

            os = socket.getOutputStream();

            pw = new PrintWriter(os);

            pw.write("good morning\n");

            pw.flush();
            socket.shutdownOutput();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                pw.close();
                os.close();
                br.close();
                ir.close();
                is.close();
                socket.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}
