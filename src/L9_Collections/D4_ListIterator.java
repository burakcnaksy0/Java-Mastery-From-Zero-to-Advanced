package L9_Collections;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class D4_ListIterator {
    public static void main(String[] args) {
        // Java'da List koleksiyonları üzerinde çift yönlü gezinmeyi sağlayan bir arabirimdir.
        // ListIterator, hem ileri (next()) hem de geri (previous()) hareket edebilir.

        // hasNext()	Sonraki eleman var mı? (true veya false döner)
        // next()	Sonraki elemanı döndürür ve ilerler
        // hasPrevious()	Önceki eleman var mı?
        // previous()	Önceki elemanı döndürür ve geri gider
        // remove()	Mevcut elemanı listeden siler
        // set(E e)	Mevcut elemanı verilen eleman ile değiştirir
        // add(E e)	O anki konuma yeni eleman ekler

        List<String> names = new ArrayList<>();
        names.add("Java");
        names.add("Python");
        names.add("Spring");
        names.add("Django");

        ListIterator<String> listIterator = names.listIterator();

        System.out.println("İleri doğru gezinme:");
        while (listIterator.hasNext()) {
            System.out.println("index : " + listIterator.nextIndex() + "  eleman : " + listIterator.next());
        }

        System.out.println("\nGeriye doğru gezinme:");
        while (listIterator.hasPrevious()) {
            System.out.println("index : " + listIterator.previousIndex() + "  eleman : " + listIterator.previous());
        }

        // iteratörü başa al
        listIterator = names.listIterator();
        while (listIterator.hasNext()) {
            String name = listIterator.next();
            if (name.equals("Python")) {
                listIterator.set("C++"); // Python yerine C++ ekleniyor
            }
        }
        System.out.println(names);

        // iteratörü başa al
        listIterator = names.listIterator();
        while (listIterator.hasNext()) {
            String name = listIterator.next();
            if (name.equals("Spring")) {
                listIterator.previous(); // Geri git
                listIterator.add("Kotlin"); // Şimdi ekle
                break;
            }
        }
        System.out.println(names);

        // Java'yı silmek için iteratörü başa al
        listIterator = names.listIterator();

        while (listIterator.hasNext()) {
            String name = listIterator.next();
            if (name.equals("Java")) {
                listIterator.remove(); // Java'yı sil
            }
        }

        System.out.println(names);
    }
}
