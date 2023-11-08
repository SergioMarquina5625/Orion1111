import java.io.*;
import java.net.*;

public class Receiver {
    public static void main(String[] args) {
        try {
            // Create a server socket to listen for incoming connections
            ServerSocket serverSocket = new ServerSocket(12345); // Use the same port as the sender

            // Accept incoming connections
            System.out.println("Receiver is waiting for a connection...");
            Socket socket = serverSocket.accept();
            System.out.println("Connection established with Sender.");

            // Get the input stream of the socket
            InputStream inputStream = socket.getInputStream();
            BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));

            // Read and print the message from the sender
            String message = in.readLine();
            System.out.println("Received message: " + message);

            // Close the socket and server socket
            socket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
