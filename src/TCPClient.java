import java.io.*;
import java.net.*;
import java.util.Scanner;

public class TCPClient {
    private static final int PORT = 7654;
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter server IP address: ");
        String serverAddress = scanner.nextLine();

        Socket clientSocket = new Socket(serverAddress, PORT);
        System.out.println("Connected to server");

        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String userInput;
        while ((userInput = in.readLine()) != null) {
            if (userInput.equals("x")) {
                break;
            }
            out.println(userInput);
        }

        out.close();
        in.close();
        clientSocket.close();
    }
}
