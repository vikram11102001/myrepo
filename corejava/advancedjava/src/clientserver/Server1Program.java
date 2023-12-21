package clientserver;

import java.io.*;
import java.net.*;

public class Server1Program {
    public static void main(String[] args) {
        int port = 12345; // Port for Server 1
        int server2Port = 54321; // Port for Server 2

        try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Server 1 is running and listening on port " + port);

            while (true) {
                Socket clientSocket = serverSocket.accept();

                // Create input and output streams for data transfer
                InputStream inputStream = clientSocket.getInputStream();
                OutputStream outputStream = new Socket("localhost", server2Port).getOutputStream();
                outputStream.write(new String("malar").getBytes());
                outputStream.flush();

                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                    System.out.println(new String(buffer));
                }

                clientSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}