import java.io.IOException;

public class ForkExample {
    public static void main(String[] args) {
        // İşletim sistemini kontrol et
        boolean isWindows = System.getProperty("os.name").toLowerCase().contains("win");

        // Windows ise "cmd /c dir", değilse "ls" komutunu çalıştır
        ProcessBuilder processBuilder = isWindows
                ? new ProcessBuilder("cmd", "/c", "dir")  // Windows için
                : new ProcessBuilder("ls");              // Linux/Mac için

        try {
            Process process = processBuilder.start();
            process.waitFor();
            System.out.println("Child Complete");
        } catch (IOException | InterruptedException e) {
            System.err.println("Fork Failed");
            e.printStackTrace();
        }
    }
}
