package L6_OOP_Structures;

public class D5_Polymorphism {
    public static void main(String[] args) {
        /*
        Parent p = new Child();
        Üst sınıf değişkeninin alt sınıf nesnelerini referans edebilmesidir.
         */

        /*
        int sayi = 10;
        double sonuc = sayi; // Implicit casting (int → double)

        double pi = 3.14;
        int yuvarlanmisPi = (int) pi; // Explicit casting (double → int)
         */

        Animal animals = new Animal(); // implicit , upcasting
        Animal dogs = new Dog();
        Animal cats = new Cat();

        ((Dog) dogs).toRun();
        ((Cat) cats).toClimb();

        tellMeName(animals);
        tellMeName(dogs);
        tellMeName(cats);

        Animal a1 = new Animal();
        Cat c1 = new Cat();
        Dog d1 = new Dog();

        tellMeName(a1);
        tellMeName(c1);
        tellMeName(d1);

        System.out.println();

        Dog dg = (Dog) dogs;  // explicit , downcasting

        tellMeName(dg);

    }

    public static void tellMeName(Animal animal) {
        /*
        if (animal instanceof Cat) {        // polymorphism olmasaydı.
            Cat c1 = (Cat) animal;
            c1.makeSound();
        } else if (animal instanceof Dog) {
            Dog d1 = (Dog) animal;
            d1.makeSound();
        } else {
            animal.makeSound(); */
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

    public void toRun() {
        System.out.println("the dog can run.");
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

    public void toClimb() {
        System.out.println("the cat can climb.");
    }
}