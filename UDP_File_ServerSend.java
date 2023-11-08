import java.io.*;
import java.net.*;

public class UDPFileServerSend {
    public static void main(String[] args) {
        DatagramSocket socket = null;
        FileInputStream fileInputStream = null;

        try {
            socket = new DatagramSocket(9876); // Create a UDP socket on port 9876

            // Prepare a buffer to receive data
            byte[] receiveData = new byte[1024];
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);

            System.out.println("Server is running. Waiting for file...");

            // Receive the file name
            socket.receive(receivePacket);
            String fileName = new String(receivePacket.getData(), 0, receivePacket.getLength());

            // Open the file for writing
            fileInputStream = new FileInputStream(fileName);
            int bytesRead;
            byte[] fileBuffer = new byte[1024];

            while ((bytesRead = fileInputStream.read(fileBuffer)) != -1) {
                // Create a new packet to send data
                DatagramPacket sendPacket = new DatagramPacket(fileBuffer, bytesRead, receivePacket.getAddress(), receivePacket.getPort());
                socket.send(sendPacket);
            }

            System.out.println("File sent successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (socket != null) {
                    socket.close();
                }
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
