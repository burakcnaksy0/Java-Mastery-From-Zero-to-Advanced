package L6_OOP_Structures;

public class D3_Inheritance {
    public static void main(String[] args) {
        Car1 car1 = new Car1("BMW", 200, 4);
        Motorcycle motorcycle = new Motorcycle("Yamaha", 150, false);

        car1.start();          // Override edilmiş start() metodu çalışır
        car1.honk();           // Arabaya özel metod
        car1.stop();           // Vehicle sınıfından miras alınmış metod

        System.out.println();

        motorcycle.start();    // Override edilmiş start() metodu çalışır
        motorcycle.wheelie();  // Motora özel metod
        motorcycle.stop();     // Vehicle sınıfından miras alınmış metod
    }
}

// Üst sınıf (Base Class / Parent Class)
class Vehicle {
    protected String brand;
    protected int speed;

    public Vehicle(String brand, int speed) {
        this.brand = brand;
        this.speed = speed;
    }

    public void start() {
        System.out.println(brand + " aracı çalıştırılıyor...");
    }

    public void stop() {
        System.out.println(brand + " aracı durduruluyor...");
    }
}

// Alt sınıf (Derived Class / Subclass) - Car
class Car1 extends Vehicle {
    private int doors;

    public Car1(String brand, int speed, int doors) {
        super(brand, speed); // Üst sınıfın constructor'ını çağır
        this.doors = doors;
    }

    public void honk() {
        System.out.println(brand + " korna çalıyor: BEEP BEEP!");
    }

    @Override
    public void start() {
        System.out.println(brand + " arabası çalıştırılıyor...");
    }
}

// Alt sınıf (Derived Class / Subclass) - Motorcycle
class Motorcycle extends Vehicle {
    private boolean hasSideCar;

    public Motorcycle(String brand, int speed, boolean hasSideCar) {
        super(brand, speed);
        this.hasSideCar = hasSideCar;
    }

    public void wheelie() {
        System.out.println(brand + " tek teker üzerinde gidiyor!");
    }

    @Override
    public void start() {
        System.out.println(brand + " motosikleti çalıştırılıyor...");
    }
}