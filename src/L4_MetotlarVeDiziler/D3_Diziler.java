package L4_MetotlarVeDiziler;

import java.util.Scanner;

public class D3_Diziler {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("dizinin boyutunu giriniz: ");
        int size = sc.nextInt();

        int[] dizi = new int[size];

        for (int i = 0; i < dizi.length; i++) {
            dizi[i] = (int) (Math.random() * 10 + 5);
        }
        for (int i = 0; i < dizi.length; i++) {
            System.out.println(i + " .değer : " + dizi[i]);
        }
    }
}
