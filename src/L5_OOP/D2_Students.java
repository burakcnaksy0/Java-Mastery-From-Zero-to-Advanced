package L5_OOP;

public class D2_Students {
    String name;
    String surname;
    int no;
    byte sınıf;
    boolean status;

    D2_Students() {

    }

    D2_Students(String name) {
        this.name = name;
    }

    D2_Students(String name, String surname) {
        //this.name = name;
        this(name);
        this.surname = surname;

    }

    D2_Students(String name, String surname, int no) {
        /*this.name = name;
        this.surname = surname;*/
        this(name, surname);
        this.no = no;
    }

    D2_Students(String name, String surname, int no, byte sınıf) {
        /*this.name = name;
        this.surname = surname;
        this.no = no;*/
        this(name, surname, no);
        this.sınıf = sınıf;

    }

    D2_Students(String name, String surname, int no, byte sınıf, boolean status) {
        /*this.name = name;
        this.surname = surname;
        this.no = no;
        this.sınıf = sınıf;*/
        this(name, surname, no, sınıf);
        this.status = status;
    }

    public void showStudentInfo() {
        System.out.println("name : " + name);
        System.out.println("surname : " + surname);
        System.out.println("no : " + no);
        System.out.println("sınıf : " + sınıf);
        System.out.println("status : " + status);
    }
}
