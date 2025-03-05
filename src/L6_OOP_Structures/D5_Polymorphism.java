package L6_OOP_Structures;

public class D5_Polymorphism {
    public static void main(String[] args) {
        /*
        Parent p = new Child();
        Üst sınıf değişkeninin alt sınıf nesnelerini referans edebilmesidir.
         */
        Animal animals = new Animal();
        Dog dogs = new Dog();
        Cat cats = new Cat();

        tellMeName(animals);
        tellMeName(dogs);
        tellMeName(cats);

    }

    public static void tellMeName(Animal animal) {
        animal.makeSound();
    }
}

// Üst sınıf (Super Class)
class Animal {
    private int foot_number;

    Animal() {
    }

    Animal(int foot_number) {
        setFoot_number(foot_number);
    }

    public int getFoot_number() {
        return foot_number;
    }

    public void setFoot_number(int foot_number) {
        this.foot_number = foot_number;
    }

    public void makeSound() {
        System.out.println("Hayvan ses çıkarıyor...");
    }
}

// Alt sınıf (Subclass) - Metodu Override ediyor
class Dog extends Animal {
    private String gender;

    public Dog() {
    }

    public Dog(int foot_number, String gender) {
        super(foot_number);
        setGender(gender);
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public void makeSound() {
        System.out.println("Köpek havlıyor: Hav hav!");
    }
}

// Alt sınıf (Subclass) - Metodu Override ediyor
class Cat extends Animal {
    private String type;

    public Cat() {
    }

    public Cat(int foot_number, String type) {
        super(foot_number);
        setType(type);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public void makeSound() {
        System.out.println("Kedi miyavlıyor: Miyav miyav!");
    }
}