package L9_Collections;

import java.util.PriorityQueue;

public class D7_PriorityQueue {
    public static void main(String[] args) {
        PriorityQueue<Student> students = new PriorityQueue<>();   // new Comparator<Student>  şeklinde de kullanılırdı.

        students.offer(new Student(1, 45));
        students.offer(new Student(2, 25));
        students.offer(new Student(5, 49));
        students.offer(new Student(3, 90));
        students.offer(new Student(6, 77));

        while (!students.isEmpty()){
            System.out.println(students.poll());
        }
    }
}

class Student implements Comparable<Student> {
    int id;
    int grade;

    public Student(int id, int grade) {
        this.id = id;
        this.grade = grade;
    }

    @Override
    public int compareTo(Student o) {
        if (this.grade > o.grade) {
            return 1;
        } else if (this.grade < o.grade) {
            return -1;
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", grade=" + grade +
                '}';
    }
}
