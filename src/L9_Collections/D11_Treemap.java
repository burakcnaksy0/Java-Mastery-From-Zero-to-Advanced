package L9_Collections;

import java.util.Comparator;
import java.util.TreeMap;

public class D11_Treemap {
    public static void main(String[] args) {
        Square s1 = new Square(3, "sarı");
        Square s2 = new Square(2, "mavi");
        Square s3 = new Square(7, "kırmızı");
        Square s4 = new Square(4, "yeşil");

        TreeMap<Square, String> map = new TreeMap<>(new Comparator<Square>() {
            @Override
            public int compare(Square o1, Square o2) {
                //return o1.renk.compareTo(o2.renk);
                if (o1.kenar < o2.kenar) {
                    return 1;
                } else if (o1.kenar > o2.kenar) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
        map.put(s1, "sarı");
        map.put(s2, "mavi");
        map.put(s3, "kırmızı");
        map.put(s4, "yeşil");

        System.out.println("\n" + map);
    }
}

class Square {
    int kenar;
    String renk;

    public Square(int kenar, String renk) {
        this.kenar = kenar;
        this.renk = renk;
    }

    @Override
    public String toString() {
        return "Square{" +
                "kenar=" + kenar +
                ", renk='" + renk + '\'' +
                '}';
    }
}

