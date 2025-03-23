package L_10_ExceptionHandling;

import java.util.Scanner;

public class D4_BankAccountManagement {
    /*
    Bu uygulamada bir banka hesabı oluşturuyoruz. Kullanıcı:
    Para çekebilir (withdraw),
    Para yatırabilir (deposit),
    Hesap bakiyesini görüntüleyebilir (getBalance).

    Hataları simüle etmek için şu exception türlerini kullanacağız:
    ✅ IllegalArgumentException → Negatif para yatırma/çekme durumunda (Geçersiz İşlem Kontrolleri)
    ✅ ArithmeticException → Hesap bakiyesi sıfıra bölünürse (0 Bakiyeyle İşlem Engelleme)
    ✅ InsufficientFundsException → Yetersiz bakiye nedeniyle para çekme işlemi başarısız olursa (Yetersiz Bakiye Durumu)
    ✅ NumberFormatException → Geçersiz giriş hatası (Geçersiz Girdi Kontrolü)
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Kullanıcıdan başlangıç bakiyesini al
            System.out.print("Başlangıç bakiyesini giriniz: ");
            double initialBalance = Double.parseDouble(scanner.nextLine());  // Geçersiz sayı girilirse NumberFormatException fırlatır
            if (initialBalance == 0) {
                throw new ArithmeticException("Hesap bakiyesi 0! İşlem yapılamaz.");
            }
            BankAccount account = new BankAccount(initialBalance);

            while (true) {
                System.out.println("\n1. Para Yatır\n2. Para Çek\n3. Bakiye Görüntüle\n4. Çıkış");
                System.out.print("Seçiminizi yapınız: ");
                int choice = Integer.parseInt(scanner.nextLine());

                if (choice == 1) {
                    System.out.print("Yatırılacak miktarı giriniz: ");
                    double amount = Double.parseDouble(scanner.nextLine());
                    account.deposit(amount);
                } else if (choice == 2) {
                    System.out.print("Çekilecek miktarı giriniz: ");
                    double amount = Double.parseDouble(scanner.nextLine());
                    account.withdraw(amount);
                } else if (choice == 3) {
                    System.out.println("Hesap Bakiyesi: " + account.getBalance() + " TL");
                } else if (choice == 4) {
                    System.out.println("Çıkış yapılıyor...");
                    break;
                } else {
                    System.out.println("Geçersiz seçim! Tekrar deneyiniz.");
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Hata: Geçersiz sayı formatı! Lütfen bir sayı girin.");
        } catch (IllegalArgumentException e) {
            System.out.println("Hata: " + e.getMessage());
        } catch (InsufficientFundsException e) {
            System.out.println("Hata: " + e.getMessage());
        } catch (ArithmeticException e) {
            System.out.println("Hata: " + e.getMessage());
        } finally {
            System.out.println("Banka işlemleri sona erdi.");
            scanner.close();
        }
    }
}

// Özel istisna sınıfı (Custom Exception)
class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}

class BankAccount {
    private double balance;  // Hesap bakiyesi

    // Constructor
    public BankAccount(double initialBalance) {
        if (initialBalance < 0) {
            throw new IllegalArgumentException("Başlangıç bakiyesi negatif olamaz!");
        }
        this.balance = initialBalance;
    }

    // Para yatırma metodu
    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Yatırılacak para miktarı pozitif olmalıdır!");
        }
        balance += amount;
        System.out.println(amount + " TL yatırıldı. Güncel bakiye: " + balance + " TL");
    }

    // Para çekme metodu
    /*
    Bu, metodun çalışması sırasında InsufficientFundsException fırlatabileceğini bildirir.
    throws anahtar kelimesi, bu metodun istisna fırlatabileceğini çağıran koda bildirir.
    Eğer bu istisna fırlatılırsa, metodu çağıran kodun bunu try-catch bloğu ile yakalaması gerekir.
     */
    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount <= 0) {
            throw new IllegalArgumentException("Çekilecek miktar pozitif olmalıdır!");
        }
        if (amount > balance) {
            throw new InsufficientFundsException("Yetersiz bakiye! Güncel bakiyeniz: " + balance + " TL");
        }
        balance -= amount;
        System.out.println(amount + " TL çekildi. Güncel bakiye: " + balance + " TL");
    }

    // Hesap bakiyesini getirme metodu
    public double getBalance() {
        if (balance == 0) {
            throw new ArithmeticException("Hesap bakiyesi 0! İşlem yapılamaz.");
        }
        return balance;
    }
}