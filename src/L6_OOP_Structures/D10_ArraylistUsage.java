package L6_OOP_Structures;

import java.util.ArrayList;

public class D10_ArraylistUsage {
    public static void main(String[] args) {
        ArrayList<Phone> phones = new ArrayList<>();
        Phone p1 = new Phone("ıphone 12", 29000);
        Phone p2 = new Phone("redmi note 12 pro", 35000);
        Phone p3 = new Phone("samsung A50", 50000);
        Phone p4 = new Phone("nokia 3310", 900);

        phones.add(p1);
        phones.add(p2);
        phones.add(p3);
        phones.add(p4);

        phones_show(phones);

        System.out.println();

        Phone p5 = new Phone("Nubia Neo ", 10000);
        phones.set(2, p5);   // belirtilen indeks değerini kaldırır onun yerine verilen değeri yazdırır.

        phones_show(phones);

        System.out.println();

        phones.remove(1);   // verilen indeks değerini kaldırır
        phones.remove(p5);      // verilen nesne ismini kaldırır.

        phones_show(phones);

        System.out.println();

        System.out.println(phones.contains(p5));    // girilen nesne değerinin arraylistte olup olmadığını true-false olarak döndürür.
        System.out.println(phones.contains(p1));
    }

    private static void phones_show(ArrayList<Phone> phones) {
        for (Phone i : phones) {
            System.out.println(i);
        }
    }
}

class Phone {
    private String phone_name;
    private int price;

    public Phone(String phone_name, int price) {
        this.phone_name = phone_name;
        this.price = price;
    }

    public String getPhone_name() {
        return phone_name;
    }

    public void setPhone_name(String phone_name) {
        this.phone_name = phone_name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "phone_name='" + phone_name + '\'' +
                ", price=" + price +
                '}';
    }
}
