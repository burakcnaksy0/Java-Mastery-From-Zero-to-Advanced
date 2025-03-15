package L7_AbstractInterface;

import java.util.Arrays;

class D3_ComparableUsage {
    public static void main(String[] args) {

        Person p1 = new Person(3, "burak");
        Person p2 = new Person(8, "hasan");
        Person p3 = new Person(6, "kemal");

        Person[] people = {p1, p2, p3};
        for (Person p : people) {
            System.out.println(p.id + " " + p.name);
        }

        System.out.println("sort according to name");

        Arrays.sort(people);

        for (Person p : people) {
            System.out.println(p.id + " " + p.name);
        }

    }
}

class Person implements Comparable<Person> {
    String name;
    int id;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public int compareTo(Person o) {
        /*if (this.id < o.id) {
            return -1;  // küçükten büyüğe
        } else if (this.id > o.id) {
            return 1;
        } else {
            return 0;
        }*/
        if (this.name.compareTo(o.name) < 0) {
            return 1;
        } else if (this.name.compareTo(o.name) > 0) {
            return -1;
        } else {
            return 0;
        }
    }
}
