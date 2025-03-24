import java.io.*;

public class OrdinaryPipes {
    public static void main(String[] args) throws IOException {
        // Pipe oluştur (Anonim)
        PipedOutputStream outputStream = new PipedOutputStream();
        PipedInputStream inputStream = new PipedInputStream(outputStream);

        // Çocuk işlemi başlat
        ChildProcess child = new ChildProcess(inputStream);
        Thread childThread = new Thread(child);
        childThread.start();

        // Mesajı pipe'a yaz
        PrintWriter writer = new PrintWriter(outputStream);
        writer.println("Merhaba, ben Parent!");
        writer.flush();

        // Kaynakları kapat
        writer.close();
        outputStream.close();
    }
}

class ChildProcess implements Runnable {
    private PipedInputStream inputStream;

    public ChildProcess(PipedInputStream inputStream) {
        this.inputStream = inputStream;
    }

    @Override
    public void run() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String message = reader.readLine();
            System.out.println("Child aldı: " + message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
