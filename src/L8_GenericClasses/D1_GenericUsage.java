package L8_GenericClasses;

public class D1_GenericUsage {
    /*
    Generic sınıflar farklı veri tipleriyle çalışabilen esnek yapılar oluşturmayı sağlar.
    Kod tekrarını önler ve tip güvenliğini artırır.
    Birden fazla tip parametresi tanımlanabilir.
    extends anahtar kelimesi ile belirli türlerle sınırlandırılabilir.
     */
    public static void main(String[] args) {

        Integer[] numbers = {10, 20, 30, 40, 50};
        String[] names = {"Ahmet", "Mehmet", "Zeynep", "Elif"};
        Character[] letters = {'A', 'B', 'C', 'D', 'E'};

        System.out.println("-------------------------");

        GenericArrayPrint<Integer> num = new GenericArrayPrint<>();
        num.print(numbers);

        System.out.println("-------------------------");

        GenericArrayPrint<String> name = new GenericArrayPrint<>();
        name.print(names);

        System.out.println("-------------------------");

        GenericArrayPrint<Character> letter = new GenericArrayPrint<>();
        letter.print(letters);

        System.out.println("-------------------------");


        Box<String> stringBox = new Box<>();
        stringBox.setItem("Merhaba, Java!");
        System.out.println(stringBox.getItem()); // Çıktı: Merhaba, Java!

        System.out.println("-------------------------");

        Box<Integer> intBox = new Box<>();
        intBox.setItem(42);
        System.out.println(intBox.getItem()); // Çıktı: 42

        System.out.println("-------------------------");

        Pair<String, Integer> student = new Pair<>("Ahmet", 90);
        System.out.println(student.getKey() + " - " + student.getValue()); // Ahmet - 90

        System.out.println("-------------------------");

        NumericBox<Integer> intbox = new NumericBox<>(5);
        System.out.println(intbox.getSquare()); // Çıktı: 25.0

        System.out.println("-------------------------");

        NumericBox<Double> doubleBox = new NumericBox<>(3.5);
        System.out.println(doubleBox.getSquare()); // Çıktı: 12.25

        System.out.println("-------------------------");
    }
}

class GenericArrayPrint<DataType> {
    public void print(DataType[] array) {
        for (DataType i : array) {
            System.out.println(i);
        }
    }
}

// Generic bir sınıf tanımlıyoruz
class Box<T> {
    private T item;

    public void setItem(T item) {
        this.item = item;
    }

    public T getItem() {
        return item;
    }
}

//Birden Fazla Tip Parametresi Kullanımı
class Pair<K, V> {
    private K key;
    private V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
}

//Generic Sınıflarda Kısıtlama (Bounded Type)
class NumericBox<T extends Number> {  // Sadece Number veya alt sınıfları (Integer, Double, Float vb.) kullanılabilir
    private T num;

    public NumericBox(T num) {
        this.num = num;
    }

    public double getSquare() {
        return num.doubleValue() * num.doubleValue();
    }
}
