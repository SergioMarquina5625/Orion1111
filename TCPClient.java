// Write TCP Client, TCP Server Socket Programming using Java.

import java.io.*;
import java.net.*;

public class TCPClient {
    public static void main(String[] args) {
        String serverHostname = "localhost"; // Server's hostname or IP (in this case, localhost)
        int serverPort = 12345; // Server's port

        try (Socket socket = new Socket(serverHostname, serverPort);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            out.println("Hello, server!"); // Send a message to the server
            String response = in.readLine(); // Receive the server's response
            System.out.println("Server says: " + response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
