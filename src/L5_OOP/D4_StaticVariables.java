package L5_OOP;

public class D4_StaticVariables {
    static double interestRate = 5.0; // Statik değişken (Sınıfa ait)
    String accountHolder; // Nesneye özgü değişken

    D4_StaticVariables(String name) {
        this.accountHolder = name;
    }

    void displayInfo() {
        System.out.println("Hesap Sahibi: " + accountHolder);
        System.out.println("Faiz Oranı: " + interestRate);
    }

}
