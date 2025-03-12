package L6_OOP_Structures;

public class D6_Binding {
    public static void main(String[] args) {
        Parent parent = new Parent();
        Child child = new Child();

        Parent.nameTell();
        Child.nameTell();
    }
}

class Parent {
    // static metotlar override edilmezler
    public static void nameTell() {
        System.out.println("ı'm parent object.");
    }
}

class Child extends Parent {
    public static void nameTell() {
        System.out.println("ı'm child object.");
    }
}