package L_10_ExceptionHandling;

import java.io.*;

public class D9_FileReaderWriter {
    public static void main(String[] args) {

        dataWrite();
        dataRead();
    }

    private static void dataRead() {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("karakter.txt"))) {
            String s;
            while ((s = bufferedReader.readLine()) != null) {
                System.out.println(s);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void dataWrite() {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("karakter.txt", true))) {
            bufferedWriter.write("hello world");
            bufferedWriter.newLine();
            bufferedWriter.write("end file.");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
