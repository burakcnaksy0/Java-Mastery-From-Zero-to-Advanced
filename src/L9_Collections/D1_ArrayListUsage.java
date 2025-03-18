package L9_Collections;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class D1_ArrayListUsage {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("burak");   // arrayliste eleman ekler
        names.add("ceren");
        names.add("irem");
        names.add("berat");

        System.out.println(names);

        System.out.println(names.size());   // arraylistin size değerini döndürür.
        System.out.println(names.isEmpty());   // arraylistin dolu mu boş mu olduğunu döndürür

        // names.clear();   arraylisti temizler

        System.out.println(names);
        System.out.println(names.isEmpty());

        System.out.println(names.contains("burak"));
        System.out.println(names.contains("mert"));

        String[] array = names.toArray(new String[0]); // Doğru kullanım

        for (String i : array) {
            System.out.println(i);
        }

        // belirli indeksteki değeri okumak.
        System.out.println(names.get(0));
        // belirli indeksteki değeri güncellemek
        names.set(0, "burakcan");
        System.out.println(names.get(0));
        // belirli bir indekse eleman yerleştirmek
        names.add(0, "can");
        System.out.println(names);
        // belirli bir indeksteki değeri silme
        names.remove(1);
        System.out.println(names);
        // belirli indeksler arasındaki değerleri başka bir listeye atmak
        List<String> newNames = names.subList(1, 3);   // ilk indeksi alır , son indeks değerini almaz.
        System.out.println(newNames);
        // iki listeyi birleştirmek , belirli indeksten sonra birleştirmek
        List<String> firstNames = new ArrayList<>();
        firstNames.add("burak");
        firstNames.add("ceren");
        firstNames.add("berat");
        firstNames.add("irem");

        List<String> surnames = new ArrayList<>();
        surnames.add("alkan");
        surnames.add("aksoy");

        firstNames.addAll(1, surnames);    // içerdeki list ifadesini beliritlen indeks değerine ekleme.
        System.out.println(firstNames);
        // arrayi listeye dönüştürmek
        // List<String> city = new ArrayList<>(Arrays.asList(cities));
        String[] cities = {"ankara", "izmir", "istanbul", "adana", "trabzon"};
        List<String> city;
        city = Arrays.asList(cities);
        System.out.println(city);
    }
}
