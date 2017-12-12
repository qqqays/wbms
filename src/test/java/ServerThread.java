import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.*;
import java.net.Socket;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by Q-ays.
 * 12-11-2017 23:38
 */
public class ServerThread extends Thread {
    Socket socket = null;

    Map<String, Socket> map = null;

    String uuid = null;

    public ServerThread(Socket socket, Map<String, Socket> map, String uuid) {
        this.socket = socket;
        this.map = map;
        this.uuid = uuid;
    }

    @Override
    public void run() {
        InputStream is = null;
        InputStreamReader ir = null;
        BufferedReader br = null;
        OutputStream os  = null;
//        PrintWriter pw  = null;
        try {
            is = socket.getInputStream();

            ir = new InputStreamReader(is);

            br = new BufferedReader(ir);

//            os = socket.getOutputStream();
//
//            pw = new PrintWriter(os);

            Set<PrintWriter> set = new HashSet<>();
            for (Map.Entry<String, Socket> entry : map.entrySet()) {
                os = entry.getValue().getOutputStream();
                set.add(new PrintWriter(os));
            }

            String info = null;

            while ((info = br.readLine()) != null) {
                System.out.println(socket.getInetAddress().toString() + ":" + socket.getPort() + "-+--=>" + info);

                for (PrintWriter pw : set) {

                    pw.write(uuid +" : " + info + "\n");

                    pw.flush();
                }
            }
            socket.shutdownInput();


            socket.shutdownOutput();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
//                pw.close();
                os.close();
                br.close();
                ir.close();
                is.close();
                socket.close();
                map.remove(uuid);
                System.out.println("socket closed");
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}
