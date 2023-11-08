import java.io.*;
import java.net.*;

public class Sender {
    public static void main(String[] args) {
        try {
            // Create a socket to connect to the receiver
            Socket socket = new Socket("receiver_ip_address", 12345); // Replace with the receiver's IP address

            // Get the output stream of the socket
            OutputStream outputStream = socket.getOutputStream();

            // Create a PrintWriter to send messages
            PrintWriter out = new PrintWriter(outputStream, true);

            // Send a "Hello" message
            out.println("Hello from Sender!");

            // Close the socket
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
