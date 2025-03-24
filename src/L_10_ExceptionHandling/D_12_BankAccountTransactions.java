package L_10_ExceptionHandling;

import java.io.Serializable;
import java.io.*;
import java.util.*;

public class D_12_BankAccountTransactions {
    public static void main(String[] args) {
        BankSystem bankSystem = new BankSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Banka Sistemi ---");
            System.out.println("1. Hesap Aç");
            System.out.println("2. Para Yatır");
            System.out.println("3. Para Çek");
            System.out.println("4. Hesapları Listele");
            System.out.println("5. Hesap Sil");
            System.out.println("6. Çıkış");
            System.out.print("Seçiminizi yapın: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Hesap No: ");
                    String accNumber = scanner.next();
                    System.out.print("Adınız: ");
                    String name = scanner.next();
                    System.out.print("İlk Bakiye: ");
                    double balance = scanner.nextDouble();
                    bankSystem.createAccount(accNumber, name, balance);
                    break;

                case 2:
                    System.out.print("Hesap No: ");
                    String depositAcc = scanner.next();
                    System.out.print("Yatırılacak Tutar: ");
                    double depositAmount = scanner.nextDouble();
                    bankSystem.deposit(depositAcc, depositAmount);
                    break;

                case 3:
                    System.out.print("Hesap No: ");
                    String withdrawAcc = scanner.next();
                    System.out.print("Çekilecek Tutar: ");
                    double withdrawAmount = scanner.nextDouble();
                    bankSystem.withdraw(withdrawAcc, withdrawAmount);
                    break;

                case 4:
                    bankSystem.displayAccounts();
                    break;

                case 5:
                    System.out.print("Hesap No: ");
                    String withdrawAc = scanner.next();
                    bankSystem.deleteAccount(withdrawAc);
                    break;
                case 6:
                    System.out.println("Çıkış yapılıyor..");
                    return;

                default:
                    System.out.println("Geçersiz seçim!");
            }
        }
    }
}

class BankAccounts implements Serializable {
    private static final long serialVersionUID = 1L;
    private String accountNumber;
    private String ownerName;
    private double balance;

    public BankAccounts(String accountNumber, String ownerName, double balance) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println(amount + " TL yatırıldı. Yeni bakiye: " + balance);
        } else {
            System.out.println("Geçersiz tutar!");
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println(amount + " TL çekildi. Yeni bakiye: " + balance);
            return true;
        } else {
            System.out.println("Yetersiz bakiye veya geçersiz tutar!");
            return false;
        }
    }

    @Override
    public String toString() {
        return accountNumber + "," + ownerName + "," + balance;
    }

    public static BankAccounts fromString(String line) {
        String[] parts = line.split(",");
        return new BankAccounts(parts[0], parts[1], Double.parseDouble(parts[2]));
    }
}

class BankSystem implements Serializable {
    private static final String FILE_NAME = "hesaplar.txt";
    private List<BankAccounts> accounts;

    public BankSystem() {
        accounts = new ArrayList<>();
        loadAccounts();
    }

    private void loadAccounts() {
        File file = new File(FILE_NAME);
        if (!file.exists()) {
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                accounts.add(BankAccounts.fromString(line));
            }
        } catch (IOException e) {
            System.out.println("Dosya okuma hatası: " + e.getMessage());
        }
    }

    private void saveAccounts() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (BankAccounts account : accounts) {
                writer.write(account.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Dosya yazma hatası: " + e.getMessage());
        }
    }

    public void createAccount(String accountNumber, String ownerName, double balance) {
        BankAccounts newAccount = new BankAccounts(accountNumber, ownerName, balance);
        accounts.add(newAccount);
        saveAccounts();
        System.out.println("Yeni hesap oluşturuldu: " + accountNumber);
    }

    public void deleteAccount(String accountNumber) {
        ListIterator<BankAccounts> bankAccount = accounts.listIterator();
        while (bankAccount.hasNext()) {
            BankAccounts account = bankAccount.next();
            if (account.getAccountNumber().equals(accountNumber)) {
                bankAccount.remove();
                saveAccounts();
                System.out.println(accountNumber + "-" + account.getOwnerName() + " hesabı silindi.");
                return; // Hesap bulunduğunda döngüden çık
            }
        }
        System.out.println("Hata: " + accountNumber + " numaralı hesap bulunamadı!");
    }


    public BankAccounts findAccount(String accountNumber) {
        for (BankAccounts account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        return null;
    }

    public void deposit(String accountNumber, double amount) {
        BankAccounts account = findAccount(accountNumber);
        if (account != null) {
            account.deposit(amount);
            saveAccounts();
        } else {
            System.out.println("Hesap bulunamadı!");
        }
    }

    public void withdraw(String accountNumber, double amount) {
        BankAccounts account = findAccount(accountNumber);
        if (account != null) {
            if (account.withdraw(amount)) {
                saveAccounts();
            }
        } else {
            System.out.println("Hesap bulunamadı!");
        }
    }

    public void displayAccounts() {
        if (accounts.isEmpty()) {
            System.out.println("Kayıtlı hesap bulunmamaktadır.");
        } else {
            System.out.println("Mevcut hesaplar:");
            for (BankAccounts account : accounts) {
                System.out.println(account.getAccountNumber() + " - " + account.getOwnerName() + " - Bakiye: " + account.getBalance());
            }
        }
    }
}