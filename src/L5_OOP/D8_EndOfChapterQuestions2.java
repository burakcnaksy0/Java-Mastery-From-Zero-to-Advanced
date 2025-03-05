package L5_OOP;

import java.sql.SQLOutput;
import java.util.Scanner;

public class D8_EndOfChapterQuestions2 {
    /*
    Hesap makinesi sınıfı oluşturun.Bu sınıfta 4 işlem yapabilmek için
    metotlarınız olsun. Bu metotlara istenilen sayıda parametre geçilebilmeli.
    Bölme işlemi için 0 değerini için gerekli kontrolü yazın.
     */
    public static void main(String[] args) {
        System.out.println("1 -topla");
        System.out.println("2 -cıkar");
        System.out.println("3 -böl");
        System.out.println("4 -çarp");

        System.out.println();

        Scanner sc = new Scanner(System.in);
        System.out.println("yapmak istediğiniz işlemi seçiniz : ");
        int p = sc.nextInt();
        System.out.println("ilk sayıyı giriniz : ");
        int n1 = sc.nextInt();
        System.out.println("ikinci sayıyı giriniz : ");
        int n2 = sc.nextInt();
        Calculater c1 = new Calculater(n1, n2, p);

        switch (c1.getChoose()) {
            case 1:
                System.out.println(c1.topla());
                break;
            case 2:
                System.out.println(c1.cıkar());
                break;
            case 3:
                System.out.println(c1.böl());
                break;
            case 4:
                System.out.println(c1.çarp());
                break;
            default:
                System.out.println("hatalı ifade girdiniz !!");
        }

    }
}

class Calculater {
    private int choose;
    private int number1;
    private int number2;

    Calculater(int number1, int number2, int choose) {
        this.number1 = number1;
        this.number2 = number2;
        this.choose = choose;

    }

    int topla() {
        return getNumber1() + getNumber2();
    }

    int cıkar() {
        return getNumber1() - getNumber2();
    }

    double böl() {
        if (getNumber2() != 0) {
            return (double) ((double) getNumber1() / (double) getNumber2());
        }
        return -1;
    }

    int çarp() {
        return getNumber1() * getNumber2();
    }

    public int getNumber1() {
        return number1;
    }

    public void setNumber1(int number1) {
        this.number1 = number1;
    }

    public int getChoose() {
        return choose;
    }

    public void setChoose(int choose) {
        this.choose = choose;
    }

    public int getNumber2() {
        return number2;
    }

    public void setNumber2(int number2) {
        this.number2 = number2;
    }


}