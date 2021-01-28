package bio;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket();
        serverSocket.bind(new InetSocketAddress(10001));
        System.out.println("start server ....");
        try {
            while (true) {
                new Thread(new ServereTask(serverSocket.accept())).start();
            }
        } finally {

        }


    }

    private static class ServereTask implements Runnable {

        Socket socket;

        public ServereTask(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            //自动释放的语法
            try (ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
                 ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream())) {
                String userName = inputStream.readUTF();
                System.out.println("Accept client message:" + userName);
                outputStream.writeUTF("hello," + userName);
                //强制写
                outputStream.flush();

            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
