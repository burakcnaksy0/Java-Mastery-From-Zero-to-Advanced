package L3_ConditionStructures;

import java.util.Scanner;

public class D6_ScannerClass {
    public static void main(String[] args) {
        // scanner class
        Scanner sc = new Scanner(System.in);

        System.out.print("entry a value : ");
        int value = sc.nextInt();

        System.out.println("value of user : " + value);

        System.out.println();


        // string ifadeler
        System.out.print("your name is : ");
        String name = sc.next();   // girilen ifadenin ilk kelimesini alır.

        sc.nextLine();  // art arda girilen next() ve nextLine() ifadelerinde nextlinedan önce boş çalıştırılır.

        System.out.print("your name and surname is : ");
        String nameSurname = sc.nextLine();

        System.out.println("user name : " + name);
        System.out.println("user name and surname : " + nameSurname);

        System.out.println();


        // char ifadeleri
        System.out.println("bir harf giriniz : ");
        char letter = sc.next().charAt(0);

        System.out.print("girilen harf : " + letter);

        System.out.println();


        // example
        System.out.println("entry a first value : ");
        int v1 = sc.nextInt();

        System.out.println("entry a second value : ");
        int v2 = sc.nextInt();

        for (; v1 < v2; v1++) {
            System.out.println("sırayla değerler :" + v1);
        }
    }
}
