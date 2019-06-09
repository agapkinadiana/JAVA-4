package Server;

import Client.ClientObj;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        try {
            ServerSocket server = new ServerSocket(8090);
            System.out.println("Wait connections...");
            while (true) {
                Socket socket = server.accept();
                System.out.println(socket.getInetAddress() + " connected");

                ClientObj thread = new ClientObj(socket);
                thread.start();
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
