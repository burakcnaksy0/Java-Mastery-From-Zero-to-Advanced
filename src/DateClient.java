import java.net.*;
import java.io.*;

public class DateClient {
    public static void main(String[] args) {
        try {
            // Connect to server at localhost on port 6013
            System.out.println("Attempting to connect to server...");
            Socket socket = new Socket("localhost", 6013);
            System.out.println("Connected to server.");

            // Create reader for server response
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));

            // Read date from server
            String dateFromServer = in.readLine();
            System.out.println("Current date from server: " + dateFromServer);

            // Close the socket
            socket.close();
            System.out.println("Connection closed.");

        } catch (UnknownHostException e) {
            System.err.println("Unknown host: localhost");
            System.err.println(e.getMessage());
        } catch (IOException e) {
            System.err.println("Could not connect to server");
            System.err.println(e.getMessage());
        }
    }
}