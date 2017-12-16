import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by Q-ays.
 * 12-11-2017 23:17
 */
public class Client {

    public static void main(String[] args) throws IOException{
        Socket socket = new Socket();

//        socket.connect(new InetSocketAddress("121.42.24.8", 18888), 5000);
        socket.connect(new InetSocketAddress("localhost", 18888), 5000);

//        socket.setSoTimeout(60000); //读操作超时,抛出异常后连接未断开。

        ClientThread clientThread = new ClientThread(socket);

        clientThread.start();

        OutputStream os = socket.getOutputStream();

        PrintWriter pw = new PrintWriter(os);

        Scanner scanner = new Scanner(System.in);

        String data;

        while (!(data = scanner.nextLine()).equals("exit")) {
            pw.write(data + "\n");

            pw.flush();
        }


        socket.shutdownOutput();

        pw.close();
        os.close();
        socket.close();
        System.out.println("socket closed");

    }
}
