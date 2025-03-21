package L9_Collections;

import java.util.LinkedList;
import java.util.Queue;

public class D6_QueueInterface {
    public static void main(String[] args) {

        Queue<Integer> numbers = new LinkedList<>();

        numbers.offer(1);
        numbers.offer(11);
        numbers.offer(12);
        numbers.offer(14);
        numbers.offer(16);
        numbers.add(12);

        System.out.println(numbers);

        System.out.println(numbers.peek()); // ilk giren ilk çıkar (FIFO)  -> elemanı kaldırmaz gösterir.

        System.out.println(numbers.poll()); // FIFO -> elemanı kaldırır.

        System.out.println(numbers);


    }
}
