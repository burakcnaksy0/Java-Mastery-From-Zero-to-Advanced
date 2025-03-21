package L9_Collections;

import java.util.*;

public class D15_LuckyNumber10Game {
    static final int MAX_LİMİT = 60;
    static final int NUMBER_QUANTİTY = 1000000;

    /*
    1 ile 60 arasında rastgele sayılar üretir (1.000.000 kez).
    Sayıların kaç kez tekrarlandığını bir Map<Integer, Integer> içinde saklar.
    Frekansa göre sıralayarak en çok tekrar edenleri bir List<Integer> içine ekler.
    En yüksek 10 sayıyı seçer, bir TreeSet<Integer> içine koyarak küçükten büyüğe sıralar.
    Son olarak bu şanslı 10 numarayı ekrana yazdırır.
     */
    public static void main(String[] args) {

        Random random = new Random();
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        // 1 ile 60 arasında 1.000.000 kez rastgele sayı üret ve frekansını sakla
        for (int i = 0; i < NUMBER_QUANTİTY; i++) {
            int number = random.nextInt(MAX_LİMİT) + 1; // 1 ile 60 arasında sayı üret
            if (frequencyMap.containsKey(number)) {
                // Eğer sayı map'te varsa, mevcut değeri 1 artır
                frequencyMap.put(number, frequencyMap.get(number) + 1);
            } else {
                // Eğer sayı map'te yoksa, başlangıç değeri olarak 1 ekle
                frequencyMap.put(number, 1);
            }
        }
        List<Integer> numbers = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();

            for (int i = 0; i < value; i++) {
                numbers.add(key);
            }
        }
        // Frekansa göre büyükten küçüğe sıralı bir liste oluştur
        List<Map.Entry<Integer, Integer>> sortedList = new ArrayList<>(frequencyMap.entrySet());
        Collections.sort(sortedList, (a, b) -> b.getValue().compareTo(a.getValue()));

        // İlk 10 sayıyı bir TreeSet içine ekleyerek sıralı hale getir
        TreeSet<Map.Entry<Integer, Integer>> luckyNumbers = new TreeSet<>(Comparator.comparing(Map.Entry::getKey));
        for (int i = 0; i < 10; i++) {
            luckyNumbers.add(sortedList.get(i));
        }

        // Şanslı 10 numarayı ekrana yazdır (sıralı olarak)
        System.out.println("Şanslı 10 Numara (Tekrar Sayıları ile):");
        for (Map.Entry<Integer, Integer> entry : luckyNumbers) {
            System.out.println("Numara: " + entry.getKey() + " | Tekrar Sayısı: " + entry.getValue());
        }
    }
}
