import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * finish：读超时， 设置密码， 验证失败后设置cd， 线程池控制线程， 队列限制，资源正常释放， 命令（单发，自定义数据存储，获取信息）。
 * to do：读取文件配置， 存储。
 * Created by Q-ays.
 * 12-17-2017 17:01
 */
public class ServerAlpha {
    //Stores sockets
    static volatile List<SocketWrap> list = new ArrayList<>();

    //Stores socket ip address
    static volatile Map<String, Long> limitMap = new HashMap<>();

    //connect password
    static volatile String password = "";

    //socket wrapper
    static class SocketWrap {
        String identity;
        Map<String, String> map;
        PrintWriter printWriter;
        Socket socket;

        SocketWrap(Socket socket) {
            this.socket = socket;
            identity = UUID.randomUUID().toString();
            printWriter = null;
            map = new HashMap<>();
        }

        public SocketWrap(String identity, PrintWriter printWriter, Socket socket) {
            this.identity = identity;
            this.printWriter = printWriter;
            this.socket = socket;
            map = new HashMap<>();
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

        public Map<String, String> getMap() {
            return map;
        }
    }


    //    mass
    static void mass(String identity, String msg) {
        mass(identity + ">> " + msg);
    }

    static void mass(String msg) {
        Iterator<SocketWrap> it = list.iterator();

        while (it.hasNext()) { //send message to all sockets
            SocketWrap sw = it.next();
            PrintWriter pw = sw.getPrintWriter();
            pw.write(msg +"\n");
            pw.flush();
        }
    }

    //    distribute messages
    static void distMsg(String msg, SocketWrap socketWrap, List<SocketWrap> list) {

        Iterator<SocketWrap> it = list.iterator();

        if (msg.startsWith("#")) {

            PrintWriter pw = socketWrap.getPrintWriter();
            Socket socket = socketWrap.getSocket();
            Map<String, String> map = socketWrap.getMap();

            int start = msg.indexOf("(");
            int end = msg.indexOf(")");

            boolean hasParam = start > 0 && end > 0;

            String cmd = hasParam ? msg.substring(1, start) : msg.substring(1);
            String param = hasParam ? msg.substring(start + 1, end) : "";
            String value = hasParam && msg.length() >= end + 2 ? msg.substring(end + 2) : "";

            switch (cmd) {
                case "to":
                    while (it.hasNext()) {
                        SocketWrap sw = it.next();
                        if (sw.getIdentity().equals(param)) {
                            PrintWriter pw1 = sw.getPrintWriter();
                            pw1.write(socketWrap.getIdentity() + "@You: " + msg.substring(end + 2) + "\r\n");
                            pw1.flush();
                            pw.write(socketWrap.getIdentity() + ">> " + msg);
                        }
                    }
                    break;

                case "users":
                    StringBuilder sb = new StringBuilder("--Here some users: ");
                    while (it.hasNext()) {
                        SocketWrap sw = it.next();
                        sb.append(sw.getIdentity());
                        sb.append(", ");
                    }
                    pw.write(sb.toString());
                    break;

                case "store":
                    map.put(param, value);
                    pw.write("key: " + param + ", value: " + value);
                    break;

                case "get":
                    String value1 = map.get(param) == null ? "Not find the value!" : map.get(param);
                    pw.write(value1);
                    break;

                case "show":
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(socketWrap.getIdentity());
                    sb2.append("@");
                    sb2.append(socket.getInetAddress());
                    sb2.append(":");
                    sb2.append(socket.getPort());
                    String info = map == null ? "not find map" : map.toString();
                    sb2.append(info);
                    pw.write(sb2.toString());
                    break;

                case "showAll":
                    StringBuilder sb1 = new StringBuilder("All socket information: ");
                    while (it.hasNext()) {
                        SocketWrap sw1 = it.next();

                        sb1.append(sw1.getIdentity());
                        sb1.append("@");
                        sb1.append(sw1.getSocket().getInetAddress());
                        sb1.append(":");
                        sb1.append(sw1.getSocket().getPort());
                        sb1.append(sw1.getMap().toString());
                        sb1.append(", ");
                    }
                    pw.write(sb1.toString());
                    break;

                default:
                    pw.write("The cmd that you typed not find !");
            }

            pw.write("\r\n");
            pw.flush();

        } else {
            mass(socketWrap.getIdentity(), msg);
        }
    }

    // this thread accept and send message
    static class ThreadPool implements Runnable {
        SocketWrap socketWrap = null;

        ThreadPool(SocketWrap socketWrap) {
            this.socketWrap = socketWrap;
        }

        boolean verification(String pw) {
            return pw.equals(password);

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
                socketWrap.getSocket().setSoTimeout(30000);
                for (int i = 0; ; i++) {

                    pw.write("Enter password: \n");
                    pw.flush();

                    if ((info = br.readLine()) != null)
                        if (verification(info)) {

                            socketWrap.getSocket().setSoTimeout(300000);
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

                mass(identity + " on line!");
                list.add(socketWrap);
                System.out.println("current active thread: " + list.size());

                while ((info = br.readLine()) != null) {
                    System.out.println(identity + "@" + socketWrap.getSocket().getInetAddress().toString() + ":" + socketWrap.getSocket().getPort() + ">>" + info);

                    distMsg(info, socketWrap, list);
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
                mass(socketWrap.getIdentity() + " out line!");
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