package L4_MethosAndArrays;

import java.util.Arrays;

public class D8_ArrayClassMethods {
    public static void main(String[] args) {
        int[] main_array = {12, 6, 234, 93, 37, 17, 42, 72, 56};

        Arrays.sort(main_array);    // sıralama yapar
        Arrays.parallelSort(main_array);  // daha etkili (büyük verilerde) sıralama yapar
        sortArray(main_array);
    }

    public static void sortArray(int[] array) {
        for (int i : array) {
            System.out.println("sıralanmış dizi  : " + i);
        }
    }
}
