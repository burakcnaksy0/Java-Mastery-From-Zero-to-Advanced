package L6_OOP_Structures;

public class D8_FinalConcept {
    public static void main(String[] args) {
        //Java'da final anahtar kelimesi, bir değişkenin, metodun veya sınıfın değiştirilemez olmasını sağlamak için kullanılır.
        final int maxHiz = 200; // Sabit değer
        // maxHiz = 100;  hatalı gösterim
    }
}

class Matematik {
    static final double PI = 3.14159; // Değiştirilemez sabit
}

class Arac {
    final void calistir() {
        System.out.println("Araç çalışıyor...");
    }
}

class Araba2 extends Arac {
    // @Override
    // void calistir() { ❌ HATA! Final metod override edilemez.
    //     System.out.println("Araba çalışıyor...");
    // }
}

final class Banka {
    void faizOrani() {
        System.out.println("Faiz oranı: %10");
    }
}

// class Halkbank extends Banka { ❌ HATA! Final sınıf extend edilemez.
// }
