package L7_AbstractInterface;

public class D6_LocalInnerClass {
    //Bir metodun içinde tanımlanır.
    //Sadece tanımlandığı metod içinde kullanılabilir.
    //Metodun final olmayan değişkenlerine doğrudan erişemez, ancak final veya effectively final olan değişkenlere erişebilir.
    public static void main(String[] args) {
        LocalOuter outer = new LocalOuter();
        outer.outerMethod();
    }
}

class LocalOuter {
    void outerMethod() {
        System.out.println("Dış sınıf metodu çalışıyor...");

        class LocalInner {
            void localDisplay() {
                System.out.println("Yerel İç Sınıf çalışıyor...");
            }
        }

        LocalInner local = new LocalInner();
        local.localDisplay();
    }
}
