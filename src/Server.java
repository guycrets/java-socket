import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter port number: ");
        int portNumber = scanner.nextInt();

        ServerSocket serverSocket = new ServerSocket(portNumber);
        System.out.println("Server started on port " + portNumber);

        Socket clientSocket = serverSocket.accept();
        System.out.println("Client connected");

        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        String inputLine;

        while ((inputLine = in.readLine()) != null) {
            System.out.println("Client: " + inputLine);
        }

        in.close();
        clientSocket.close();
        serverSocket.close();
    }
}