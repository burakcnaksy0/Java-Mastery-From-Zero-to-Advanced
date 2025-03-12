package L6_OOP_Structures;

import java.util.Objects;

public class D7_ObjectsEqualsMethod {
    public static void main(String[] args) {
        Person p1 = new Person(13, 22);
        Person p2 = new Person(13, 22);
        System.out.println("p1 ve p2 nesnesi birbirine eşit midir ? " + p1.equals(p2));

        Employee e1 = new Employee(5, 25, 22000, "pc eng");
        Employee e2 = new Employee(3, 25, 22000, "pc eng");
        System.out.println("e1 ve e2 nesnesi birbirine eşit midir ? " + e1.equals(e2));
    }
}

class Person {
    private int id;
    private int age;

    Person(int id, int age) {
        setId(id);
        setAge(age);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Person person)) return false;
        return getId() == person.getId() && getAge() == person.getAge();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getAge());
    }
}

class Employee extends Person {

    private int salary;
    private String department;

    Employee(int id, int age, int salary, String department) {
        super(id, age);
        setSalary(salary);
        setDepartment(department);
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public boolean equals(Object o) {   // varsayılan (default) equals() metodu, bellek adreslerini karşılaştırır.yani iki nesnenin referanslarının aynı olup olmadığını kontrol eder.
        // Eğer o bir Employee nesnesi değilse, false döndürerek eşit olmadığını belirtir.
        if (!(o instanceof Employee employee)) return false;
        // Eğer üst sınıftaki özellikler eşleşmiyorsa, direkt false döndürülür.
        if (!super.equals(o)) return false;
        return Objects.equals(getSalary(), employee.getSalary()) && Objects.equals(getDepartment(), employee.getDepartment());
        // return getSalary() == employee.getSalary() && Objects.equals(getDepartment(), employee.getDepartment());
    }

    @Override

    public int hashCode() {
        return Objects.hash(super.hashCode(), getSalary(), getDepartment());
    }
}