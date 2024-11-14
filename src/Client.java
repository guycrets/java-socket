import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter server IP address: ");
        String serverAddress = scanner.nextLine();

        System.out.print("Enter server port number: ");
        int portNumber = scanner.nextInt();

        Socket clientSocket = new Socket(serverAddress, portNumber);
        System.out.println("Connected to server");

        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String userInput;
        while ((userInput = in.readLine()) != null) {
            out.println(userInput);
        }

        out.close();
        in.close();
        clientSocket.close();
    }
}