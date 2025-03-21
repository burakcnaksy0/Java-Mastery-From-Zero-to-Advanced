package L9_Collections;

import java.util.HashMap;
import java.util.Iterator;

public class D9_HashMapUsage {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>(16,0.75f);  // default olarak 16 uzunluğunda map oluşturur.
        map.put("gs", 85);
        map.put("fb", 72);
        map.put("bjk", 67);
        map.put("ts", 31);

        Iterator iterator = map.keySet().iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }
}
