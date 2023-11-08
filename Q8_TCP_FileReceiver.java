import java.io.*;
import java.net.*;

//Write a program using TCP socket for wired network for file transfer. 
public class FileReceiver {
    public static void main(String[] args) {
        String localhost = "localhost"; // Receiver's IP address
        int port = 12345; // Port to use for communication

        try (Socket socket = new Socket(localhost, port);
             InputStream inputStream = socket.getInputStream();
             FileOutputStream fileOutputStream = new FileOutputStream("received_file.txt")) {

            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                fileOutputStream.write(buffer, 0, bytesRead);
            }

            System.out.println("File received successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
