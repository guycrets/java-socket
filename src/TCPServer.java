import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class TCPServer {

    private static final int PORT = 7654;

    public static void main(String[] args) {
        // Executor for virtual threads
        try (var executor = Executors.newThreadPerTaskExecutor(Thread.ofVirtual().factory())) {

            // Create the server socket
            try (ServerSocket serverSocket = new ServerSocket(PORT)) {
                System.out.println("Server started on port " + PORT);

                while (true) {
                    // Accept a client connection
                    Socket clientSocket = serverSocket.accept();
                    System.out.println("New client connected: " + clientSocket.getRemoteSocketAddress());

                    // Handle client in a virtual thread
                    executor.submit(() -> handleClient(clientSocket));
                }
            } catch (IOException e) {
                System.err.println("Error starting the server: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }

    private static void handleClient(Socket clientSocket) {
        try (
                var input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                var output = new PrintWriter(clientSocket.getOutputStream(), true)
        ) {
            String message;
            output.println("Welcome to the virtual thread server! Type 'bye' to exit.");

            while ((message = input.readLine()) != null) {
                if (message.equalsIgnoreCase("bye")) {
                    output.println("Goodbye!");
                    break;
                }
                System.out.println("Received: " + message);
                output.println("Echo: " + message);
            }
        } catch (IOException e) {
            System.err.println("Error handling client: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                clientSocket.close();
                System.out.println("Client disconnected");
            } catch (IOException e) {
                System.err.println("Error closing client socket: " + e.getMessage());
            }
        }
    }
}
