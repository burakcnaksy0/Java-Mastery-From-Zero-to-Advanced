package L3_ConditionStructures;

import java.util.Scanner;

public class D10_AsalSayi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Bir sayı giriniz: ");
        int number = sc.nextInt();

        for (int i = 2; i < number; i++) {
            boolean asal = true; // Başlangıçta asal varsayıyoruz

            for (int j = 2; j < i; j++) {
                if (i % j == 0) { // Eğer herhangi bir sayıya bölünüyorsa asal değildir
                    asal = false;
                    break; // Daha fazla kontrol etmeye gerek yok
                }
            }

            if (asal) {
                System.out.println(i + " asal sayıdır.");
            }
        }

    }
}
