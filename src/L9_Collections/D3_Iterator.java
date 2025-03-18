package L9_Collections;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class D3_Iterator {
    public static void main(String[] args) {
        // Iterator, koleksiyon (Collection) nesneleri üzerinde sıralı bir şekilde gezmek için kullanılan bir arabirimdir.
        // Yani, List, Set gibi koleksiyonlardaki elemanları tek tek dolaşmak için kullanılır.

        // hasNext()	Sonraki eleman var mı? (true veya false döner)
        // next()	Sonraki elemanı döndürür ve konumu bir ileri kaydırır
        // remove()	Son elemanı siler (isteğe bağlı)

        List<String> names = new ArrayList<>();
        names.add("Java");
        names.add("Python");
        names.add("Spring");
        names.add("Django");

        List<String> languages = new ArrayList<>();
        languages.add("PHP");
        languages.add("Python");
        languages.add("Ruby");
        languages.add("C#");
        languages.add("C");
        languages.add("C++");

        Iterator<String> nameIterator = names.iterator();

        while (nameIterator.hasNext()) { // Sonraki eleman varsa
            /*String element = nameIterator.next(); // Elemanı al
            System.out.println(element);*/
            if (languages.contains(nameIterator.next())) {
                nameIterator.remove();
            }
        }
        System.out.println(names);
    }
}
