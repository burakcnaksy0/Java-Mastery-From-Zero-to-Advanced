package L0_PatikaQuestions;

public class D3_SumOfDigits {
    public static void main(String[] args) {
        int sumdigits = basamaklarToplami(12312);
        System.out.println("basamakların toplamı : " + sumdigits);
    }

    static int basamaklarToplami(int sayi) {
        if (sayi == 0) {
            return 0;  // Temel durum: Sayı 0 ise toplam 0'dır.
        } else {
            return sayi % 10 + basamaklarToplami(sayi / 10);  // Son basamağı al, sonra özyinelemeyi çağır.
        }
    }

}
/*
Java'da ilkel veri tipleri şunlardır:

byte: 8 bit
short: 16 bit
int: 32 bit
long: 64 bit
float: 32 bit
double: 64 bit
char: 16 bit
boolean: 1 bit (gerçek değeri temsil eder: true veya false)
 */