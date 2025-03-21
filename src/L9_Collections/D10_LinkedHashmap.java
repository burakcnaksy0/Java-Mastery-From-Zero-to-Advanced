package L9_Collections;

import java.util.LinkedHashMap;
import java.util.Map;

public class D10_LinkedHashmap {
    public static void main(String[] args) {
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        map.put("burak", 41);
        map.put("ceren", 35);
        map.put("berat", 61);
        map.put("acun", 25);

        System.out.println(map);

        System.out.println();
        for (String name : map.keySet()) {
            System.out.println(name);
        }


        System.out.println();
        for (Integer id : map.values()) {
            System.out.println(id);
        }

        System.out.println();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println("name : " + entry.getKey() + " id : " + entry.getValue());
        }
    }
}
