package clientserver;

import java.io.*;
import java.net.*;

public class Server2 {
    public static void main(String[] args) {
        int port = 54321; // Port for Server 2

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server 2 is running and listening on port " + port);

            while (true) {
                try (Socket clientSocket = serverSocket.accept();
                     InputStream inputStream = clientSocket.getInputStream()) {

                    byte[] buffer = new byte[1024];
                    int bytesRead;
                    while ((bytesRead = inputStream.read(buffer)) != -1) {
                        System.out.println("Server2 received: " + new String(buffer, 0, bytesRead));
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
