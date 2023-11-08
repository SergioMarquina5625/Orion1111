import java.io.*;
import java.net.*;

//Write TCP Client, TCP Server Socket Programming using Java.
public class TCPServer {
    public static void main(String[] args) {
        int serverPort = 12345; // Server port to listen on

        try (ServerSocket serverSocket = new ServerSocket(serverPort)) {
            System.out.println("Server is waiting for client connections on port " + serverPort);

            while (true) {
                Socket clientSocket = serverSocket.accept(); // Accept client connection
                System.out.println("Client connected from " + clientSocket.getInetAddress());

                // Create input and output streams for communication with the client
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

                String message = in.readLine(); // Read data from the client
                System.out.println("Client says: " + message);

                // Send a response back to the client
                out.println("Hello, client!");

                clientSocket.close(); // Close the client connection
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
