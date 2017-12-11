import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by Q-ays.
 * 12-11-2017 23:17
 */
public class Client {

    public static void main(String[] args) throws IOException{
        Socket socket = new Socket("127.0.0.1", 18888);

        OutputStream os = socket.getOutputStream();

        PrintWriter pw = new PrintWriter(os);

        Scanner scanner = new Scanner(System.in);

        String data;

        while (!(data = scanner.nextLine()).equals("exit")) {
            pw.write(data + "\n");
            pw.flush();
        }


        socket.shutdownOutput();

        InputStream is = socket.getInputStream();

        InputStreamReader ir = new InputStreamReader(is);

        BufferedReader br = new BufferedReader(ir);

        String info = null;

        while ((info = br.readLine()) != null) {
            System.out.println(info);
        }
        socket.shutdownInput();

        br.close();
        ir.close();
        is.close();
        pw.close();
        os.close();
        socket.close();

    }
}
