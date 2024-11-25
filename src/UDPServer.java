import java.io.*;
import java.net.*;
import java.util.Scanner;

public class UDPServer {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter port number: ");
        int portNumber = scanner.nextInt();

        DatagramSocket socket = new DatagramSocket(portNumber);
        System.out.println("Server started on port " + portNumber);

        byte[] receiveData = new byte[1024];

        while (true) {
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            socket.receive(receivePacket);

            String receivedMessage = new String(receivePacket.getData(), 0, receivePacket.getLength());
            System.out.println("Received: " + receivedMessage);
        }
    }
}