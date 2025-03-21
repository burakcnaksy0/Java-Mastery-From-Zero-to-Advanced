package L9_Collections;

import java.util.HashMap;
import java.util.Map;

public class D8_Hashmap {
    public static void main(String[] args) {
        HashMap<Integer, String> plakalar = new HashMap<>();

        plakalar.put(1, "Adana");
        plakalar.put(61, "Trabzon");
        plakalar.put(41, "Kocaeli");
        plakalar.put(45, "Manisa");
        plakalar.put(35, "İzmir");
        plakalar.put(34, "İstanbul");

        System.out.println(plakalar.get(61));

        System.out.println(plakalar.containsKey(35));

        System.out.println(plakalar.containsValue("Kocaeli"));  // case sensivity (küçük - büyük harf duyarlıdır.)

        System.out.println(plakalar.isEmpty());

        System.out.println(plakalar.size());

        System.out.println("**********************");
        System.out.println("plaka değerleri");
        for (Integer plaka : plakalar.keySet()) {
            System.out.println("plaka değeri : " + plaka);
        }
        System.out.println("**********************");

        System.out.println("şehirler");
        for (String cities : plakalar.values()) {
            System.out.println("şehir : " + cities);
        }
        System.out.println("**********************");
        for (Map.Entry<Integer, String> entry : plakalar.entrySet()) {
            System.out.println("plaka : " + entry.getKey() + " şehirler : " + entry.getValue());
        }

        System.out.println("**********************");


        System.out.println("başka kullanımı  : ");
        HashMap<String, String> capitalCities = new HashMap<>();

        capitalCities.put("England", "London");
        capitalCities.put("Germany", "Berlin");
        capitalCities.put("Norway", "Oslo");
        capitalCities.put("USA", "Washington DC");

        System.out.println(capitalCities);

        capitalCities.get("England");
        //capitalCities.remove("England");
        //capitalCities.clear();
        System.out.println(capitalCities.size());

        for (String i : capitalCities.keySet()) {
            System.out.println(i);
        }

        for (String i : capitalCities.values()) {
            System.out.println(i);
        }

        for (String i : capitalCities.keySet()) {
            System.out.println("key: " + i + " value: " + capitalCities.get(i));
        }
    }
}
