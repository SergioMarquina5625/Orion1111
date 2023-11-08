import java.io.*;
import java.net.*;

public class UDPFileClientReceive {
    public static void main(String[] args) {
        DatagramSocket socket = null;
        FileOutputStream fileOutputStream = null;

        try {
            socket = new DatagramSocket(); // Create a UDP socket

            String serverAddress = "localhost"; // Replace with the server's IP address
            int serverPort = 9876; // Server port

            // Send the file name to the server
            String fileName = "sample.txt"; // Replace with the actual file name
            byte[] fileNameBytes = fileName.getBytes();
            InetAddress serverInetAddress = InetAddress.getByName(serverAddress);
            DatagramPacket sendPacket = new DatagramPacket(fileNameBytes, fileNameBytes.length, serverInetAddress, serverPort);
            socket.send(sendPacket);

            // Prepare a buffer to receive data
            byte[] receiveData = new byte[1024];

            // Create a file for writing
            fileOutputStream = new FileOutputStream("received_" + fileName);

            while (true) {
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                socket.receive(receivePacket);

                fileOutputStream.write(receivePacket.getData(), 0, receivePacket.getLength());

                if (receivePacket.getLength() < receiveData.length) {
                    break;
                }
            }

            System.out.println("File received successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (socket != null) {
                    socket.close();
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
