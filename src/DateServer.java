import java.net.*;
import java.io.*;
import java.util.Date;

public class DateServer {
    public static void main(String[] args) {
        try {
            // Create server socket on port 6013
            ServerSocket serverSocket = new ServerSocket(6013);
            System.out.println("Date Server started. Listening on port 6013...");

            // Listen for connections indefinitely
            while (true) {
                System.out.println("Waiting for client connections...");

                // Accept client connection
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected: " + clientSocket.getInetAddress());

                // Create output stream to client
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

                // Send current date to client
                out.println(new Date().toString());
                System.out.println("Date sent to client.");

                // Close the client socket
                clientSocket.close();
                System.out.println("Client connection closed.");
            }
        } catch (IOException e) {
            System.err.println("Server error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}