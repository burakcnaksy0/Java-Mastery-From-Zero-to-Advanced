import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        String serverAddress = "localhost"; // Sunucu adresi
        int port = 12345; // Sunucu portu

        try (Socket socket = new Socket(serverAddress, port);
             BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in))) {

            System.out.println("Server'a bağlandı. Mesaj gönderin (Çıkış için 'exit' yazın):");

            Thread readThread = new Thread(() -> {
                try {
                    String serverMessage;
                    while ((serverMessage = input.readLine()) != null) {
                        System.out.println("Server: " + serverMessage);
                        if (serverMessage.equalsIgnoreCase("exit")) {
                            System.out.println("Server bağlantıyı kapattı.");
                            break;
                        }
                    }
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

            Thread writeThread = new Thread(() -> {
                try {
                    String userMessage;
                    while ((userMessage = userInput.readLine()) != null) {
                        output.println(userMessage);
                        if (userMessage.equalsIgnoreCase("exit")) {
                            System.out.println("Bağlantı kapatılıyor...");
                            break;
                        }
                    }
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

            readThread.start();
            writeThread.start();

            readThread.join();
            writeThread.join();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
