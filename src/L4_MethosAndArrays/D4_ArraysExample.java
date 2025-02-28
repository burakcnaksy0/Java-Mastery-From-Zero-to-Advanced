package L4_MethosAndArrays;

import java.util.Scanner;

public class D4_ArraysExample {
    public static void main(String[] args) {

        // 10 elemanlı bir diziye eleman olarak dizinin indeksinin karesini atama

        int[] array = new int[10];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) Math.pow(i, 2);
        }
        for (int i = 0; i < array.length; i++) {
            System.out.println(i + ". değer :" + array[i]);
        }

        // kullanıcının girdiği sayıları dizide tut ve ortalamalarını al.
        double avg, sum = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("kaç tane değer gireceksiniz : ");
        int size = sc.nextInt();
        int[] dizi = new int[size];
        for (int i = 0; i < dizi.length; i++) {
            System.out.print((i + 1) + ". değeri giriniz : ");
            dizi[i] = sc.nextInt();
        }
        for (int i = 0; i < dizi.length; i++) {
            sum += dizi[i];
        }
        System.out.println("dizinin toplamı : " + sum);
        avg = sum / dizi.length;
        System.out.println("dizini ortalaması  :" + avg);


        // foreach usage
        for (int i : dizi) {
            System.out.println("girilen değerler : " + i);
        }

    }
}
