package clientserver;

import java.io.*;
import java.net.*;

public class Server1 {
    public static void main(String[] args) {
        int port = 12345; // Port for Server 1
        int server2Port = 54321; // Port for Server 2

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server 1 is running and listening on port " + port);

            while (true) {
                try (Socket clientSocket = serverSocket.accept();
                     InputStream inputStream = clientSocket.getInputStream();
                     Socket server2Socket = new Socket("localhost", server2Port);
                     OutputStream outputStream = server2Socket.getOutputStream()) {

                    byte[] buffer = new byte[1024];
                    int bytesRead;
                    while ((bytesRead = inputStream.read(buffer)) != -1) {
                        outputStream.write(buffer, 0, bytesRead);
                        System.out.println("Server1 received: " + new String(buffer, 0, bytesRead));
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
