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
