package L8_GenericClasses;

import java.util.ArrayList;

public class D5_VeterinaryAssociationSimulation {
    public static void main(String[] args) {
        Cat cat = new Cat("23.07.2002", true, "Siyam kedisi");
        Cat cat1 = new Cat("20.05.2002", true, "Scottish Fold");
        Cat cat2 = new Cat("11.01.2010", false, "Sfenks Kedisi");

        System.out.println(cat1);

        Dog dog = new Dog("10.01.2010", true, 5, "Golden Retriever");
        Dog dog1 = new Dog("24.11.2006", false, 2, "Bulldog");
        Dog dog2 = new Dog("14.06.2017", true, 1, "Beagle");

        System.out.println(dog1);

        Customer customer = new Customer("burakcan", "aksoy", "432365", "kocaeli", "gebze", "sultanorhan");
        customer.addAnimalToCustomer(dog);
        customer.addAnimalToCustomer(cat1);
        customer.addAnimalToCustomer(cat);

        showAnimals(customer);

        Veterinary veterinary = new Veterinary("ceren", "alkan", "3454", 2, "celal bayar");
        veterinary.addToCustomer(customer);

        showCustomer(veterinary);

        CityVeterinarly izmir_veterinary = new CityVeterinarly("izmir");
        izmir_veterinary.addToVeterinary(veterinary);
        izmir_veterinary.totalVeterinarNumber();

        System.out.println("********************************");

        AdminPanel adminPanel = new AdminPanel();
        adminPanel.customersAnimals(customer);
        adminPanel.veterinariesCustomers(veterinary);
        adminPanel.citiesVeterinaries(izmir_veterinary);
    }

    public static void showCustomer(Veterinary veterinary) {
        if (veterinary == null) {
            System.out.println("Veteriner bilgisi bulunamadı.");
            return;
        }
        ArrayList<Customer> customers = veterinary.getCustomers();
        if (customers.isEmpty()) {
            System.out.println(veterinary.getName() + " adlı veterinerin müşterisi yok");
        } else {
            System.out.println(veterinary.getName() + " adlı veterinerin müşterileri : ");
            for (Customer customer : customers) {
                System.out.println(customer);
            }
        }
    }

    public static void showAnimals(Customer customer) {
        if (customer == null) {
            System.out.println("Müşteri bilgisi bulunamadı.");
            return;
        }

        ArrayList<Animal> animals = customer.getAnimals();

        if (animals.isEmpty()) {
            System.out.println(customer.getName() + " adlı müşterinin kayıtlı hayvanı yok.");
        } else {
            System.out.println(customer.getName() + " adlı müşterinin hayvanları:");
            for (Animal animal : animals) {
                System.out.println(animal);
            }
        }
    }


}

abstract class Animal {
    private String birthday;
    private boolean registered;

    public Animal(String birthday, boolean registered) {
        setBirthday(birthday);
        setRegistered(registered);
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public boolean isRegistered() {
        return registered;
    }

    public void setRegistered(boolean registered) {
        this.registered = registered;
    }

    abstract void showIt();

    @Override
    public String toString() {
        return "Animal{" + "birthday='" + birthday + '\'' + ", registered=" + registered + '}';
    }
}

class Cat extends Animal {

    private String type;
    private String genus;

    public Cat(String birthday, boolean registered, String genus) {
        super(birthday, registered);
        this.type = "Cat";
        setGenus(genus);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getGenus() {
        return genus;
    }

    public void setGenus(String genus) {
        this.genus = genus;
    }


    @Override
    void showIt() {
        System.out.println("cat objects");
    }

    @Override
    public String toString() {
        return super.toString() + " Cat{" + "type='" + type + '\'' + ", genus='" + genus + '\'' + '}';
    }
}

class Dog extends Animal {

    private int vaccineNumber;
    private String genus;

    public Dog(String birthday, boolean registered, int vaccineNumberi, String genus) {
        super(birthday, registered);
        setVaccineNumber(vaccineNumber);
        setGenus(genus);
    }

    public int getVaccineNumber() {
        return vaccineNumber;
    }

    public String getGenus() {
        return genus;
    }

    public void setGenus(String genus) {
        this.genus = genus;
    }

    public void setVaccineNumber(int vaccineNumber) {
        this.vaccineNumber = vaccineNumber;
    }

    @Override
    void showIt() {
        System.out.println("dog pbjects");
    }

    @Override
    public String toString() {
        return super.toString() + " Dog{" + "vaccineNumber=" + vaccineNumber + ", genus='" + genus + '\'' + '}';
    }
}

abstract class Person {

    private String name;
    private String surname;
    private String identfyNo;

    public Person(String name, String surname, String identfyNo) {
        setName(name);
        setSurname(surname);
        setIdentfyNo(identfyNo);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getIdentfyNo() {
        return identfyNo;
    }

    public void setIdentfyNo(String identfyNo) {
        this.identfyNo = identfyNo;
    }

    abstract void showMe();

    @Override
    public String toString() {
        return "Person{" + "name='" + name + '\'' + ", surname='" + surname + '\'' + ", identfyNo='" + identfyNo + '\'' + '}';
    }
}

class Customer extends Person {

    private String city;
    private String district;
    private String address;
    private ArrayList<Animal> animals;

    public Customer(String name, String surname, String identfyNo, String city, String district, String address) {
        super(name, surname, identfyNo);
        setCity(city);
        setDistrict(district);
        setAddress(address);
        setAnimals(new ArrayList<>());
    }

    public void addAnimalToCustomer(Animal animal) {
        animals.add(animal);
        System.out.println(animal.toString() + " hayvan bilgileri " + getName() + " isimli müşteriye eklendi");
    }

    public ArrayList<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(ArrayList<Animal> animals) {
        this.animals = animals;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    @Override
    void showMe() {
        System.out.println("I'm customer object. ");
    }

    @Override
    public String toString() {
        return super.toString() + " Customer{" + "city='" + city + '\'' + ", district='" + district + '\'' + ", address='" + address + '\'' + '}';
    }
}

class Veterinary extends Person {
    private int experience;
    private String graduated_school;
    private ArrayList<Customer> customers;

    public Veterinary(String name, String surname, String identfyNo, int experience, String graduated_school) {
        super(name, surname, identfyNo);
        setExperience(experience);
        setGraduated_school(graduated_school);
        setCustomers(new ArrayList<>());
    }

    public void addToCustomer(Customer customer) {
        customers.add(customer);
        System.out.println(customer.toString() + " bilgilerine sahip kişi " + getName() + " adlı veterinerin müşterisidir. ");

    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(ArrayList<Customer> customers) {
        this.customers = customers;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public String getGraduated_school() {
        return graduated_school;
    }

    public void setGraduated_school(String graduated_school) {
        this.graduated_school = graduated_school;
    }

    @Override
    void showMe() {
        System.out.println("I'm veterinary object");
    }

    @Override
    public String toString() {
        return super.toString() + " Veterinary{" + "experience='" + experience + '\'' + ", graduated_school='" + graduated_school + '\'' + '}';
    }
}

class CityVeterinarly {
    private String city;
    private ArrayList<Veterinary> veterinaries;

    public CityVeterinarly(String city) {
        setCity(city);
        setVeterinaries(new ArrayList<>());
    }

    public void addToVeterinary(Veterinary veterinary) {
        veterinaries.add(veterinary);
        System.out.println(veterinary.toString() + " bilgilerine sahip veteriner " + getCity() + " şehrinde bulunmaktadır. ");
    }

    public void totalVeterinarNumber() {
        System.out.println(getCity() + " ilindeki toplam kayıtlı veteriner sayısı  :" + veterinaries.size());
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public ArrayList<Veterinary> getVeterinaries() {
        return veterinaries;
    }

    public void setVeterinaries(ArrayList<Veterinary> veterinaries) {
        this.veterinaries = veterinaries;
    }

    @Override
    public String toString() {
        return "CityVeterinarly{" + "city='" + city + '\'' + '}';
    }
}

class AdminPanel<T> {
    public <T extends Customer> void customersAnimals(T nesne) {
        ArrayList<Animal> animals = nesne.getAnimals();
        for (Animal i : animals) {
            System.out.println(i);
        }
    }

    public <T extends Veterinary> void veterinariesCustomers(T nesne) {
        ArrayList<Customer> customers = nesne.getCustomers();
        for (Customer i : customers) {
            System.out.println(i);
        }
    }

    public <T extends CityVeterinarly> void citiesVeterinaries(T nesne) {
        ArrayList<Veterinary> veterinaries = nesne.getVeterinaries();
        for (Veterinary i : veterinaries) {
            System.out.println(i);
        }
    }
}