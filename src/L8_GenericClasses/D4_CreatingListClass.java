package L8_GenericClasses;

public class D4_CreatingListClass {
    public static void main(String[] args) {
        // Varsayılan boyutlu liste (10 elemanlık başlangıç)
        MyList<Integer> myList = new MyList<>();

        System.out.println("Başlangıç Kapasitesi: " + myList.getCapacity()); // 10

        // Listeye eleman ekleyelim
        for (int i = 1; i <= 15; i++) {
            myList.add(i);
        }

        myList.printList(); // 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15

        System.out.println("Eleman Sayısı: " + myList.size()); // 15
        System.out.println("Yeni Kapasite: " + myList.getCapacity()); // 20 (Çünkü 10'dan 20'ye büyüdü)

        // Kapasitesi başlangıçta 5 olan bir liste oluşturma
        MyList<String> stringList = new MyList<>(5);
        stringList.add("Java");
        stringList.add("Generics");
        stringList.printList(); // Java Generics
        System.out.println("String List Kapasitesi: " + stringList.getCapacity()); // 5
    }
}
class MyList<T> {
    private T[] array;
    private int size = 0; // Eleman sayısı

    // Varsayılan constructor (başlangıç kapasitesi 10)
    public MyList() {
        this.array = (T[]) new Object[10];
    }

    // Kapasiteyi belirleyen constructor
    public MyList(int capacity) {
        this.array = (T[]) new Object[capacity];
    }

    // Dizideki eleman sayısını döndürür
    public int size() {
        return size;
    }

    // Dizinin kapasitesini döndürür
    public int getCapacity() {
        return array.length;
    }

    // Eleman ekleme metodu
    public void add(T data) {
        // Eğer dizi dolmuşsa, kapasiteyi 2 katına çıkar
        if (size == array.length) {
            expandCapacity();
        }
        array[size++] = data;
    }

    // Kapasiteyi 2 katına çıkaran metod
    private void expandCapacity() {
        int newCapacity = array.length * 2;
        T[] newArray = (T[]) new Object[newCapacity];

        // Eski diziyi yeni diziye kopyala
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }

        array = newArray;
    }

    // Diziyi ekrana yazdırma (Test için)
    public void printList() {
        System.out.print("Liste: ");
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
