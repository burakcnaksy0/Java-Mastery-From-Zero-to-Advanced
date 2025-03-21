package L9_Collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class D14_CollectionsMethodsHelperClass {
    public static void main(String[] args) {
        Students students1 = new Students(5, "burak", "aksoy", 60);
        Students students2 = new Students(6, "mehmet", "çakır", 45);
        Students students3 = new Students(9, "rıza", "çelik", 90);
        Students students4 = new Students(2, "hüsnü", "çoban", 22);

        ArrayList<Students> students = new ArrayList<>();

        students.add(students1);
        students.add(students2);
        students.add(students3);
        students.add(students4);

        System.out.println(students);

        // özel olarak max metodunun içinde neye göre en büyük değeri bulcağımızı Comparator metoduyla belirrtik
        Students max_grade = Collections.max(students, new Comparator<Students>() {
            @Override
            public int compare(Students o1, Students o2) {
                if (o1.grade > o2.grade) {
                    return 1;
                } else if (o1.grade < o2.grade) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
        System.out.println("en yüksek nota sahip öğrenci bilgileri : " + max_grade);

        // burda da aynı şekilde metodun içinde özel olarak neye göre sıralayacağımızı belirttik.
        Collections.sort(students, new Comparator<Students>() {
            @Override
            public int compare(Students o1, Students o2) {
                if (o1.id < o2.id) {
                    return -1;
                } else if (o1.id > o2.id) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });
        System.out.println("id ye göre sıralanmış hali ---↓");
        System.out.println(students);

        // binary search olması için class ta implements Comparable<Students> ve compareTo methodlarının olması gerekir.
        // ve sonuç olarak integer bir değer indeksini döndürür.
        int result = Collections.binarySearch(students, students1);
        System.out.println(students1.name + " adlı kullanıcının yeri  : " + result);

        // karıştırma işlemi yapar
        Collections.shuffle(students);

        System.out.println("karıştırıldıktan sonra ---↓");
        System.out.println(students);
    }
}

class Students implements Comparable<Students> {
    int id;
    String name;
    String surname;
    int grade;

    public Students(int id, String name, String surname, int grade) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Students{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", grade=" + grade +
                '}';
    }

    @Override
    public int compareTo(Students o2) {
        if (this.grade > o2.grade) {
            return 1;
        } else if (this.grade < o2.grade) {
            return -1;
        } else {
            return 0;
        }
    }
}
