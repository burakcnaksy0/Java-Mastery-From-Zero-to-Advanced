package L_10_ExceptionHandling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class D3_ThrowAndThrowsUsage {
    public static void main(String[] args) {

        /*
        throw, manuel olarak bir istisna (exception) fırlatmak (throw) için kullanılır.
        Çalışma zamanında (runtime) bir hata oluşmasını sağlamak için kullanılır.
        Sadece tek bir istisna fırlatabilir.
         */
        Scanner sc = new Scanner(System.in);
        System.out.println("entry your age : ");
        int age = sc.nextInt();
        if (age < 0) {
            throw new IllegalArgumentException("Yaş negatif olamaz!");
        }
        System.out.println("Yaş: " + age);

        /*
        throws, metodun imzasında (signature) yer alır.
        Bir metodun istisna fırlatabileceğini belirtir.
        Birden fazla istisna belirtebilir.
        throws kullanımı, istisnaların metot çağrısı yapılan yerde ele alınması gerektiğini gösterir.
         */
        try {
            readFile();
        } catch (IOException e) {
            System.out.println("Hata: Dosya okunamadı! " + e.getMessage());
        }

        System.out.println();

        System.out.println("entry your age : ");
        int ages = sc.nextInt();

        try {
            if (ages < 0) {
                throw new InvalidAgeException("the age cannot be negative!!");
            }
        } catch (InvalidAgeException e) {
            System.out.println(e.toString());
        }

    }

    public static void readFile() throws IOException {
        FileReader file = new FileReader("dosya.txt"); // Dosya yoksa hata verir
        BufferedReader reader = new BufferedReader(file);
        System.out.println(reader.readLine());
        reader.close();
    }
}

class InvalidAgeException extends Exception {
    String errorMessage;

    public InvalidAgeException(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public String toString() {
        return errorMessage;
    }
}