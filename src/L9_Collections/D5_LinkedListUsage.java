package L9_Collections;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class D5_LinkedListUsage {
    public static void main(String[] args) {

        LinkedList<Integer> numbers = new LinkedList<>();
        ArrayList<Integer> numbers2 = new ArrayList<>();

        prepareArraylist(numbers2);
        prepareLinkedlist(numbers);

        System.out.println(numbers);
        System.out.println(numbers2);
    }

    // Sıralı ekleme metodu
    public static boolean sortedAdd(List<Integer> liste, int value) {
        ListIterator<Integer> iterator = liste.listIterator();
        while (iterator.hasNext()) {
            int compareResult = iterator.next().compareTo(value);
            if (compareResult == 0) {
                iterator.add(value);
                return true;
            } else if (compareResult > 0) {
                iterator.previous();
                iterator.add(value);
                return true;
            }
        }
        iterator.add(value);
        return true;
    }

    // ArrayList hazırlama metodu
    public static void prepareArraylist(ArrayList<Integer> number) {
        for (int i = 0; i < 100; i++) {
            int newValue = (int) (Math.random() * 500);
            sortedAdd(number, newValue);
        }
    }

    // LinkedList hazırlama metodu
    public static void prepareLinkedlist(LinkedList<Integer> number) {
        for (int i = 0; i < 100; i++) {
            int newValue = (int) (Math.random() * 500);
            sortedAdd(number, newValue);
        }
    }
}
