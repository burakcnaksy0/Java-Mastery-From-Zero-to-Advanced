package L6_OOP_Structures;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/*
        CarDealership (Araba Bayisi) sınıfı, birden fazla Car (Araba) nesnesine sahiptir.
        Car (Araba) sınıfı, bir Engine (Motor) ve Owner (Sahip) nesnesine sahiptir.
        Owner (Sahip) sınıfı, bir Address (Adres) nesnesine sahiptir.
        Özetle:

        CarDealership → Birden fazla Car içerir.
        Car → Bir Engine ve Owner içerir.
        Owner → Bir Address içerir.
 */

// Main metodu
public class D2_ComplexComposition {
    public static void main(String[] args) {
        // Motorlar oluşturuluyor
        Engine engine1 = new Engine("V8", 450);
        Engine engine2 = new Engine("Electric", 300);

        // Sahipler ve adresler oluşturuluyor
        Address address1 = new Address("İstanbul", "Bağdat Caddesi");
        Address address2 = new Address("Ankara", "Atatürk Bulvarı");

        Owner owner1 = new Owner("Ahmet Yılmaz", address1);
        Owner owner2 = new Owner("Mehmet Demir", address2);

        // Arabalar oluşturuluyor
        Car car1 = new Car("Ford", "Mustang", engine1, owner1);
        Car car2 = new Car("Tesla", "Model S", engine2, owner2);

        // Bayi oluşturuluyor
        CarDealership dealership = new CarDealership("XYZ Motors");

        // Arabalar bayiye ekleniyor
        dealership.addCar(car1);
        dealership.addCar(car2);

        // Bayideki arabalar gösteriliyor
        dealership.showCars();

        // Arabalar çalıştırılıyor
        System.out.println();
        car1.startCar();
        car2.startCar();
    }
}

// Motor sınıfı
class Engine {
    private String type;
    private int horsepower;

    public Engine(String type, int horsepower) {
        this.type = type;
        this.horsepower = horsepower;
    }

    public void start() {
        System.out.println(type + " motoru (" + horsepower + " HP) çalıştırıldı.");
    }

    @Override
    public String toString() {
        return type + " - " + horsepower + " HP";
    }
}

// Adres sınıfı
class Address {
    private String city;
    private String street;

    public Address(String city, String street) {
        this.city = city;
        this.street = street;
    }

    @Override
    public String toString() {
        return city + ", " + street;
    }
}

// Sahip (Owner) sınıfı
class Owner {
    private String name;
    private Address address;

    public Owner(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    @Override
    public String toString() {
        return name + " (Adres: " + address + ")";
    }
}

// Araba sınıfı (Car) - Engine ve Owner içeriyor
class Car {
    private String brand;
    private String model;
    private Engine engine;
    private Owner owner;

    public Car(String brand, String model, Engine engine, Owner owner) {
        this.brand = brand;
        this.model = model;
        this.engine = engine;
        this.owner = owner;
    }

    public void startCar() {
        System.out.println(brand + " " + model + " arabası çalıştırılıyor...");
        engine.start();
    }

    @Override
    public String toString() {
        return brand + " " + model + " (Motor: " + engine + ", Sahip: " + owner + ")";
    }
}

// Araba Bayisi (CarDealership) - Birden fazla Car içeriyor
class CarDealership {
    private String name;
    private List<Car> cars;

    public CarDealership(String name) {
        this.name = name;
        this.cars = new ArrayList<>();
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    public void showCars() {
        System.out.println("** " + name + " Bayisindeki Arabalar **");
        for (Car car : cars) {
            System.out.println(car);
        }
    }
}

