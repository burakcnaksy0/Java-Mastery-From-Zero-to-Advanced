package L_10_ExceptionHandling;

import java.io.*;
import java.util.ArrayList;

public class D7_DataIOStream {
    public static void main(String[] args) {

        writeFile();

        readFile();

    }

    private static void writeFile() {
        DataOutputStream dataOutputStream = null;

        Student student = new Student(5, "burak", true);
        Student student1 = new Student(2, "hikmet", false);
        Student student2 = new Student(4, "orhan", true);
        try {
            /*
            new FileOutputStream("students.dat",true)
            parametre True olarak ayarlanırsa, yeni veriler dosyadaki mevcut verilerin sonuna eklenecektir.
            Aksi takdirde, yeni veriler dosyadaki mevcut verilerin üzerine yazar.
             */
            dataOutputStream = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("students.dat")));

            dataOutputStream.writeInt(student.id);
            dataOutputStream.writeUTF(student.name);
            dataOutputStream.writeBoolean(student.active);

            dataOutputStream.writeInt(student1.id);
            dataOutputStream.writeUTF(student1.name);
            dataOutputStream.writeBoolean(student1.active);

            dataOutputStream.writeInt(student2.id);
            dataOutputStream.writeUTF(student2.name);
            dataOutputStream.writeBoolean(student2.active);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (dataOutputStream != null) {
                try {
                    dataOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void readFile() {
        DataInputStream dataInputStream = null;
        ArrayList<Student> studentArrayList = new ArrayList<>();
        boolean endFile;
        try {
            try {
                // burda buffer kullanmamızın amacı harddiskten byte byte okumak yerine buffer sayesinde hepsini
                // tek seferde alabilmemizdir.
                dataInputStream = new DataInputStream(new BufferedInputStream(new FileInputStream("students.dat")));
                Student readStudent;

                endFile = false;

                while (!endFile) {
                    try {
                        int student_id = dataInputStream.readInt();
                        String student_name = dataInputStream.readUTF();
                        boolean student_active = dataInputStream.readBoolean();

                        readStudent = new Student(student_id, student_name, student_active);
                        studentArrayList.add(readStudent);
                        System.out.println("student : " + readStudent);

                    } catch (EOFException e) {
                        System.out.println("it reached end of file.");
                        endFile = true;
                    }
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            if (dataInputStream != null) {
                try {
                    dataInputStream.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        System.out.println(studentArrayList.size());
    }
}

class Student {
    int id;
    String name;
    boolean active;

    public Student(int id, String name, boolean active) {
        this.id = id;
        this.name = name;
        this.active = active;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", active=" + active +
                '}';
    }
}
