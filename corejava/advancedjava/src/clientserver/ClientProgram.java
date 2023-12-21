package clientserver;

import java.io.*;
import java.net.*;

public class ClientProgram {
    public static void main(String[] args) {
        String server1IP = "localhost";
        int server1Port = 54321;

        try {
            Socket socket = new Socket(server1IP, server1Port);

            // Create input and output streams for data transfer
            OutputStream outputStream = socket.getOutputStream();

            String message = "Data to be sent from the client to Server 1.";
            outputStream.write(message.getBytes());

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}