package L4_MetotlarVeDiziler;

import java.util.Scanner;

public class D2_MethodsExample {
    public static void main(String[] args) {
        int user_choose = -1;
        for (; ; ) {
            user_choose = showMenu();
            if (user_choose == 0) {
                break;
            }
            getInfos(user_choose);
        }
    }

    private static void getInfos(int user_choose) {
        Scanner sc = new Scanner(System.in);

        double v1 = 0;
        double v2 = 0;
        if (user_choose >= 1 && user_choose < 6) {

            System.out.print("ilk sayıyı giriniz :");
            v1 = sc.nextInt();
            System.out.print("ikinci değeri giriniz : ");
            v2 = sc.nextInt();

        }

        switch (user_choose) {
            case 1:
                System.out.println("sonuc : " + (v1 + v2));
                break;
            case 2:
                System.out.println("sonuc : " + (v1 - v2));
                break;
            case 3:
                System.out.println("sonuc : " + (v1 * v2));
                break;
            case 4:
                System.out.println("sonuc : " + (v1 / v2));
                break;
            case 5:
                System.out.println("sonuc : " + (v1 % v2));
                break;
            case 6:
                System.out.print("üsü alınacak sayıyı giriniz :  :");
                int k1 = sc.nextInt();

                System.out.print("üs değerini giriniz : ");
                int k2 = sc.nextInt();

                System.out.println("sonuc : " + (Math.pow(k1, k2)));
                break;
            default:
                System.out.println("yanlış değer girildi.");
        }
    }

    public static int showMenu() {

        System.out.println("************** MENU **************");
        System.out.println("1. toplama işlemi : ");
        System.out.println("2. çıkarma işlemi : ");
        System.out.println("3. çarpma işlemi : ");
        System.out.println("4. bölme işlemi : ");
        System.out.println("5. mod alma işlemi : ");
        System.out.println("6. üs alma işlemi : ");
        System.out.println("0. çıkmak ");

        System.out.println();
        Scanner sc = new Scanner(System.in);
        System.out.print("Bir case seçiniz : ");
        int chooseCase;
        chooseCase = sc.nextInt();

        return chooseCase;
    }
}
