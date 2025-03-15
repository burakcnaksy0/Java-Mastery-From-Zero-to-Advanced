package L7_AbstractInterface;

public class D7_AnonymousInnerClass {
    // İsimsiz bir iç sınıftır ve genellikle bir arayüzü (interface) veya
    // soyut sınıfı (abstract class) implemente etmek için kullanılır.
    //Tek seferlik (one-time) kullanım için uygundur.
    public static void main(String[] args) {
        // Anonim iç sınıf tanımlıyoruz
        AnonymousExample obj = new AnonymousExample() {
            void showMessage() {
                System.out.println("Anonim İç Sınıf çalışıyor...");
            }
        };

        obj.showMessage();
    }
}

abstract class AnonymousExample {
    abstract void showMessage();
}