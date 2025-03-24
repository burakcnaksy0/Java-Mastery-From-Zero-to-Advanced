package L_10_ExceptionHandling;

import java.io.*;

public class D8_ObjectIOStream {
    public static void main(String[] args) {

        writeObjectFile();

        readObjectFile();

    }

    private static void readObjectFile() {

        try (ObjectInputStream objectInputStream = new ObjectInputStream(new BufferedInputStream(new FileInputStream("ogrenciNesneleri")))) {
            boolean endFile = false;
            while (!endFile) {
                try {
                    Ogrenci ogrenci = (Ogrenci) objectInputStream.readObject();
                    System.out.println(ogrenci);
                } catch (EOFException e) {
                    endFile = true;
                    System.out.println("it reached end of file.");
                }
            }

        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static void writeObjectFile() {

        Ogrenci ogrenci = new Ogrenci(324, "ceren", true);
        Ogrenci ogrenci1 = new Ogrenci(561, "muhammed", true);
        Ogrenci ogrenci2 = new Ogrenci(925, "dursun", false);

        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("ogrenciNesneleri.dat")))) {
            objectOutputStream.writeObject(ogrenci);
            objectOutputStream.writeObject(ogrenci1);
            objectOutputStream.writeObject(ogrenci2);


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
// Java nesnelerini dosyaya yazmak ve okumak için Serializable Interface kullanılır.
class Ogrenci implements Serializable {
    int id;
    String name;
    boolean active;
    private static final long serialVersionUID = 1L;

    public Ogrenci(int id, String name, boolean active) {
        this.id = id;
        this.name = name;
        this.active = active;
    }

    @Override
    public String toString() {
        return "Ogrenci{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", active=" + active +
                '}';
    }
}
