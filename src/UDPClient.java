import java.io.*;
import java.net.*;
import java.util.Scanner;

public class UDPClient {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter server IP address: ");
        String serverAddress = scanner.nextLine();

        System.out.print("Enter server port number: ");
        int portNumber = scanner.nextInt();

        InetAddress IPAddress = InetAddress.getByName(serverAddress);

        DatagramSocket clientSocket = new DatagramSocket();

        while (true) {
            System.out.print("Enter message to send: ");
            String message = scanner.nextLine();

            byte[] sendData = message.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, portNumber);
            clientSocket.send(sendPacket);

            if (message.equals("exit")) {
                break;
            }
        }

        clientSocket.close();
    }
}