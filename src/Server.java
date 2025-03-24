import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        int port = 12345; // Port numarası

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server başlatıldı. Port: " + port);

            Socket clientSocket = serverSocket.accept();
            System.out.println("Client bağlandı: " + clientSocket.getInetAddress());

            BufferedReader input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter output = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader serverInput = new BufferedReader(new InputStreamReader(System.in)); // Sunucunun mesaj yazabilmesi için

            Thread readThread = new Thread(() -> {
                try {
                    String clientMessage;
                    while ((clientMessage = input.readLine()) != null) {
                        System.out.println("Client: " + clientMessage);
                        if (clientMessage.equalsIgnoreCase("exit")) {
                            System.out.println("Client bağlantıyı kapattı.");
                            break;
                        }
                    }
                    clientSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

            Thread writeThread = new Thread(() -> {
                try {
                    String serverMessage;
                    while ((serverMessage = serverInput.readLine()) != null) {
                        output.println(serverMessage);
                        if (serverMessage.equalsIgnoreCase("exit")) {
                            System.out.println("Bağlantı kapatılıyor...");
                            break;
                        }
                    }
                    clientSocket.close();
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
