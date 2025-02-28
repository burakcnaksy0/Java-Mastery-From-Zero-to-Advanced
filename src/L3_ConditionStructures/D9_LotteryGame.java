package L3_ConditionStructures;

import java.util.Scanner;

public class D9_LotteryGame {
    public static void main(String[] args) {

        for (int i = 0; i < 20; i++) {
            int random_number = (int) (Math.random() * 90 + 10);
            Scanner sc = new Scanner(System.in);
            System.out.println("Sayıyı tahmin ediniz: ");
            int predictNumber = sc.nextInt();

            int random_left_value = random_number / 10;
            int random_right_value = random_number % 10;

            int predict_left_value = predictNumber / 10;
            int predict_right_value = predictNumber % 10;

            if (random_number == predictNumber) {
                System.out.println("tebrikler doğru tahmin ettiniz. 10000TL kazandınız.");
            } else if (random_left_value == predict_right_value & random_right_value == predict_left_value) {
                System.out.println("sayının tersini buldunuz. bizden 5000 tl kazandınız");
            } else if (random_left_value == predict_left_value || random_left_value == predict_right_value || random_right_value == predict_left_value || random_right_value == predict_right_value) {
                System.out.println("sadece tek bir basamak bildiniz. 1000tl kazandınız");
            } else {
                System.out.println("yanlış tahmin yaptınız .Kaybettiniz.");
            }
            System.out.println("Şanslı numara : " + random_number);
        }
    }
}
