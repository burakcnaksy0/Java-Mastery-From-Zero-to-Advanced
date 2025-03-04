package L3_ConditionStructures;

import java.util.Scanner;

public class D11_PerfectNumber {
    public static void main(String[] args) {
        System.out.println("bir sayı giriniz : ");

        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        sc.close();

        int sum = 0;
        for (int i = 1; i < number; i++) {
            if (number % i == 0) {
                sum += i;
            }
        }
        if (number == sum) {
            System.out.println(number + " mükemmel sayıdır.");
        } else {
            System.out.println(number + " mükemmel sayı değildir.");
        }

    }
}
