package clientserver;

import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        String server1IP = "localhost";
        int server1Port = 12345;

        try (Socket socket = new Socket(server1IP, server1Port);
             OutputStream outputStream = socket.getOutputStream()) {

            String message = "Hello, Server1!";
            outputStream.write(message.getBytes());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
