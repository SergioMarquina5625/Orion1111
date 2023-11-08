import java.io.*;
import java.net.*;

//Write a program using TCP socket for wired network for file transfer. 
public class FileSender {
    public static void main(String[] args) {
        int port = 12345; // Port to use for communication

        try (ServerSocket serverSocket = new ServerSocket(port);
             Socket socket = serverSocket.accept();
             FileInputStream fileInputStream = new FileInputStream("sample.txt");
             OutputStream outputStream = socket.getOutputStream()) {

            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = fileInputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }

            System.out.println("File sent successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
