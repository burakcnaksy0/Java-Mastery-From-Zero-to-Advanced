package L9_Collections;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class D13_Hashset {
    public static void main(String[] args) {
        HashSet<String> letters = new HashSet<>();
        // değerleri unique olarak alır.
        // sırasız gelirler

        letters.add("a");
        letters.add("b");
        letters.add("v");
        letters.add("d");
        letters.add("a");
        letters.add("1");
        letters.add("2");
        letters.add("2");
        letters.add("1");

        System.out.println(letters);

        LinkedHashSet<String> linkedHashSet_Letters = new LinkedHashSet<>();
        // değerleri unique olarak alır.
        // eklediğin sırayla gelirler

        linkedHashSet_Letters.add("a");
        linkedHashSet_Letters.add("b");
        linkedHashSet_Letters.add("v");
        linkedHashSet_Letters.add("d");
        linkedHashSet_Letters.add("a");
        linkedHashSet_Letters.add("1");
        linkedHashSet_Letters.add("2");
        linkedHashSet_Letters.add("2");
        linkedHashSet_Letters.add("1");

        System.out.println(linkedHashSet_Letters);

        TreeSet<String> treeSet_letters = new TreeSet<>();
        // değerleri unique olarak alır.
        // alfabetik olarak sıralı gelirler

        treeSet_letters.add("a");
        treeSet_letters.add("b");
        treeSet_letters.add("v");
        treeSet_letters.add("d");
        treeSet_letters.add("a");
        treeSet_letters.add("k");
        treeSet_letters.add("b");
        treeSet_letters.add("p");
        treeSet_letters.add("h");

        System.out.println(treeSet_letters);

        // ilk elemanı verir ve sonra yapıdan siler
        System.out.println("poll first : " + treeSet_letters.pollFirst());

        // son elemanı verir ve sonra yapıdan siler
        System.out.println("poll last : " + treeSet_letters.pollLast());

        System.out.println(treeSet_letters);

    }
}
