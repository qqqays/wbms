import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Q-ays.
 * 12-17-2017 17:01
 */
public class ServerAlpha {
    //Stores socket and print writer of socket
    static volatile List<SocketWrap> list = new ArrayList<>();

    //Stores socket ip address
    static volatile Map<String, Long> limitMap = new HashMap<>();

    //password
    static volatile String password = "";

    static class SocketWrap {
        String identity;
        PrintWriter printWriter;
        Socket socket;

        SocketWrap(Socket socket) {
            this.socket = socket;
            identity = UUID.randomUUID().toString();
            printWriter = null;
        }

        public SocketWrap(String identity, PrintWriter printWriter, Socket socket) {
            this.identity = identity;
            this.printWriter = printWriter;
            this.socket = socket;
        }

        String getIdentity() {
            return identity;
        }

        void setIdentity(String identity) {
            this.identity = identity;
        }

        PrintWriter getPrintWriter() {
            return printWriter;
        }

        void setPrintWriter(PrintWriter printWriter) {
            this.printWriter = printWriter;
        }

        Socket getSocket() {
            return socket;
        }

        void setSocket(Socket socket) {
            this.socket = socket;
        }
    }


    //    thread pool
    static class ThreadPool implements Runnable {
        SocketWrap socketWrap = null;

        public ThreadPool(SocketWrap socketWrap) {
            this.socketWrap = socketWrap;
        }

        boolean verification(String pw) {
            if (pw.equals(password)) {
                return true;
            } else {
                return false;
            }
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " connected!");

            try (InputStream is = socketWrap.getSocket().getInputStream();
                 InputStreamReader ir = new InputStreamReader(is);
                 BufferedReader br = new BufferedReader(ir);
                 OutputStream os = socketWrap.getSocket().getOutputStream();
                 PrintWriter pw = new PrintWriter(os)) {

                String info;
                String identity;

                //verification
                for (int i = 0; ; i++) {

                    pw.write("Enter password: \n");
                    pw.flush();

                    if ((info = br.readLine()) != null)
                        if (verification(info)) {

                            socketWrap.setPrintWriter(pw);

                            pw.write("Connect success\r\n");
                            pw.write("Please input your name: \r\n");
                            pw.flush();

                            if ((identity = br.readLine()) == null) {
                                identity = UUID.randomUUID().toString();
                            }

                            socketWrap.setIdentity(identity);

                            pw.write(identity + ", welcome to join\r\n");
                            pw.write("You can type something here:\r\n");
                            pw.flush();

                            break;
                        } else {
                            pw.write("you type error password!\r\n");
                            pw.flush();
                            if (i > 2) {
                                limitMap.put(socketWrap.getSocket().getInetAddress().toString(), System.currentTimeMillis());
                                socketWrap.getSocket().close();
                            }
                        }
                }

                list.add(socketWrap);
                System.out.println("current active thread: " + list.size());

                while ((info = br.readLine()) != null) {
                    System.out.println(identity + "@" + socketWrap.getSocket().getInetAddress().toString() + ":" + socketWrap.getSocket().getPort() + ">>" + info);

                    Iterator<SocketWrap> it = list.iterator();

                    if (info.startsWith("#To")) {
                        int end = info.indexOf(")");
                        String to = info.substring(4, end);
                        System.out.println(to);
                        while (it.hasNext()) {
                            SocketWrap sw = it.next();
                            if (sw.getIdentity().equals(to)) {
                                PrintWriter pw1 = sw.getPrintWriter();
                                pw1.write(identity + "@" + socketWrap.getSocket().getInetAddress().toString() + ":" + socketWrap.getSocket().getPort() + ">> @You:" + info.substring(end + 2) + "\n");
                                pw1.flush();
                                pw.write(identity + "@" + socketWrap.getSocket().getInetAddress().toString() + ":" + socketWrap.getSocket().getPort() + ">> " + info + "\n");
                                pw.flush();
                            }
                        }
                    } else if(info.startsWith("#users")) {
                        StringBuffer sb = new StringBuffer().append("--Here some users: ");
                        while (it.hasNext()) {
                            SocketWrap sw = it.next();
                            sb.append(sw.getIdentity() + ", ");
                        }
                        pw.write(sb.toString() + "\r\n");
                        pw.flush();
                    }else{
                        while (it.hasNext()) {
                            SocketWrap sw = it.next();
                            PrintWriter pw1 = sw.getPrintWriter();
                            pw1.write(identity + "@" + socketWrap.getSocket().getInetAddress().toString() + ":" + socketWrap.getSocket().getPort() + ">>" + info + "\n");
                            pw1.flush();
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    socketWrap.getSocket().close(); //closes socket;
                    System.out.println("Socket closed");
                } catch (IOException e) {
                    e.printStackTrace();
                }

                list.remove(socketWrap); //removes socket from map
                System.out.println("Remove this socket from list, sizes : " + list.size());
            }
        }
    }

    public static void main(String[] args) {

        int max = 5; //The max number of thread pool

        int limitTime = 10 * 1000; //ms

        if (args.length > 0) {
            password = args[0];
        }

        try {
            ServerSocket serverSocket = new ServerSocket(18888, 1);

            ExecutorService fixedThreadPool = Executors.newFixedThreadPool(max);

            while (true) {
                if (list.size() < max) {

                    Socket socket = serverSocket.accept();

                    for (Map.Entry<String, Long> entry : limitMap.entrySet()) {
                        if (entry.getKey().equals(socket.getInetAddress().toString())) {
                            if (System.currentTimeMillis() < entry.getValue() + limitTime) {
                                socket.close();
                                break;
                            }
                        }
                    }

                    if (!socket.isClosed())
                        fixedThreadPool.execute(new ThreadPool(new ServerAlpha.SocketWrap(socket)));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
