package L3_ConditionStructures;

import java.util.Scanner;

public class D8_Ex_VücutKitleIndeksCalculate {
    public static void main(String[] args) {
        System.out.println("********** VÜCUT KİTLE İNDEKSİ HESABI **********");

        Scanner sc = new Scanner(System.in);

        System.out.println("Kilonuzu giriniz : ");
        double kilo = sc.nextDouble();

        System.out.println("Boyunu giriniz : (cm cinsinden)");
        double boy = sc.nextDouble();
        double boyIndeks = boy / 100;
        double indeks = kilo / (Math.pow(boyIndeks, 2));
        System.out.println("vücut kitle indeksiniz :" + indeks);
        if (indeks < 15) {
            System.out.println("çok ciddi zayıf");
        } else if (indeks >= 15 & indeks < 16) {
            System.out.println("ciddi zayıf");
        } else if (indeks >= 16 & indeks < 18.5) {
            System.out.println("düşük lilolu");
        } else if (indeks >= 18.5 & indeks < 25) {
            System.out.println("normal");
        } else if (indeks >= 25 & indeks < 30) {
            System.out.println("fazla kilolu");
        } else if (indeks >= 30 & indeks < 35) {
            System.out.println("1.dereceden obez");
        } else if (indeks >= 35 & indeks < 40) {
            System.out.println("2.dereceden obez");
        } else {
            System.out.println("3.dereceden obez");
        }

    }
}
