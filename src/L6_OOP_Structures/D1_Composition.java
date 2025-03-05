package L6_OOP_Structures;

public class D1_Composition {
    public static void main(String[] args) {
        Motor motor = new Motor("V8");
    }
}

// Motor sınıfı
class Motor {
    private String type;

    public Motor(String type) {
        this.type = type;
    }

    public void start() {
        System.out.println(type + " motoru çalıştırıldı.");
    }
}

// Araba sınıfı (Engine nesnesini içerir)
class Araba {
    private String model;
    private Motor motor;  // Kompozisyon kullanımı

    public Araba(String model, Motor motor) {
        this.model = model;
        this.motor = motor;
    }

    public void startCar() {
        System.out.println(model + " arabası çalıştırılıyor...");
        motor.start();  // Motor sınıfındaki metodu çağırıyoruz
    }
}