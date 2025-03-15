package L7_AbstractInterface;

public class D2_Interfaces {
    public static void main(String[] args) {
        /*
        bir sınıfın uygulaması gereken metotları belirleyen bir şablondur
        Çoklu kalıtımı desteklemediği için Java'da interface'ler,
        bir sınıfa birden fazla yetenek kazandırmanın yaygın bir yoludur.
        */

        // Farklı ödeme yöntemlerinden nesneler oluşturuyoruz
        PaymentProcessor creditCard = new CreditCardPayment("1234567812345678");
        PaymentProcessor payPal = new PayPalPayment("user@example.com");
        PaymentProcessor bitcoin = new BitcoinPayment("1A1zP1eP5QGefi2DMPTfTL5SLmv7DivfNa");

        // Ödemeleri gerçekleştiriyoruz
        creditCard.processPayment(500.75);
        payPal.processPayment(250.00);
        bitcoin.processPayment(0.015);
    }
}

interface PaymentProcessor {
    void processPayment(double amount); // Ödeme işlemini gerçekleştiren metod
}

// CreditCardPayment.java
class CreditCardPayment implements PaymentProcessor {
    private String cardNumber;

    public CreditCardPayment(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public void processPayment(double amount) {
        System.out.println("Kredi kartı ile " + amount + " TL ödendi. Kart No: " + maskCardNumber());
    }

    private String maskCardNumber() {
        return "**** **** **** " + cardNumber.substring(cardNumber.length() - 4);
    }
}

// PayPalPayment.java
class PayPalPayment implements PaymentProcessor {
    private String email;

    public PayPalPayment(String email) {
        this.email = email;
    }

    @Override
    public void processPayment(double amount) {
        System.out.println(email + " adresi ile " + amount + " TL PayPal üzerinden ödendi.");
    }
}

// BitcoinPayment.java
class BitcoinPayment implements PaymentProcessor {
    private String walletAddress;

    public BitcoinPayment(String walletAddress) {
        this.walletAddress = walletAddress;
    }

    @Override
    public void processPayment(double amount) {
        System.out.println("Bitcoin cüzdanı (" + walletAddress + ") ile " + amount + " BTC ödendi.");
    }
}
