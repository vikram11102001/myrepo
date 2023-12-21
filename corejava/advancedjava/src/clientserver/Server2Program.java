package clientserver;

import java.io.*;
import java.net.*;

public class Server2Program {
    public static void main(String[] args) {
        int port = 54321; // Port for Server 2

        try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Server 2 is running and listening on port " + port);

//            int  i = 0;
//            while(i==0) {
//            	System.out.println("checking");
//            }
            while (true) {
            	System.out.println("s2 in loop");
                Socket clientSocket = serverSocket.accept();

                // Create input and output streams for data transfer
                InputStream inputStream = clientSocket.getInputStream();
                OutputStream outputStream = clientSocket.getOutputStream();

                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }
                System.out.println(new String(buffer));

                clientSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}