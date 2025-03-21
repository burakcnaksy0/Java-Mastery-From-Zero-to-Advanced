import java.io.IOException;

public class CreateProcessExample {
    public static void main(String[] args) {
        // Çalıştırılacak program (Paint)
        String command = "C:\\Windows\\System32\\mspaint.exe";

        try {
            // Process başlat
            ProcessBuilder processBuilder = new ProcessBuilder(command);
            Process process = processBuilder.start();

            System.out.println("Paint başlatıldı, PID: " + process.pid());

            // Çocuk sürecin tamamlanmasını bekle
            process.waitFor();

            System.out.println("Child Complete (Paint kapandı)");

        } catch (IOException | InterruptedException e) {
            System.err.println("Create Process Failed");
            e.printStackTrace();
        }
    }
}
