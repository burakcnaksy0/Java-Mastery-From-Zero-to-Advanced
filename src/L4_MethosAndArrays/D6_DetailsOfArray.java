package L4_MethosAndArrays;

import java.util.Random;

public class D6_DetailsOfArray {
    public static void main(String[] args) {

        // manuel kopyalama
        int[] main_array = {12, 6, 234, 93, 37, 17, 42, 72, 56};
        int[] copy_array = new int[main_array.length];

        for (int i = 0; i < main_array.length; i++) {
            copy_array[i] = main_array[i];
        }
        showArray(copy_array);

        System.out.println();

        // arraycopy
        int[] copy2_array = new int[main_array.length];
        System.arraycopy(main_array, 0, copy2_array, 0, main_array.length);

        showArray(copy2_array);

        System.out.println();

        // reverse array
        reverseArray(copy_array);

        System.out.println();

        // change array
        changeArray(copy_array);

        System.out.println();

        // fisherYatesShuffle (better change)
        fisherYatesShuffle(copy_array);

        System.out.println();

        // selection sort
        selectionSort(copy_array);

        System.out.println();

        // binary search
        System.out.println(binarySearch(copy_array, 37));

    }

    public static int binarySearch(int[] array, int searchValue) {
        int minIndeks = 0;
        int maxIndeks = array.length - 1;

        while (maxIndeks >= minIndeks) {
            int midIndeks = (maxIndeks + minIndeks) / 2;
            if (searchValue < array[midIndeks]) {
                maxIndeks = midIndeks - 1;
            } else if (searchValue == array[midIndeks]) {
                return midIndeks;
            } else {
                minIndeks = midIndeks + 1;
            }
        }
        return -1;
    }

    public static int[] selectionSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int minValue = array[i];
            int minValueIndeks = i;
            for (int j = i + 1; j < array.length; j++) {
                if (minValue > array[j]) {
                    minValue = array[j];
                    minValueIndeks = j;
                }
            }
            if (minValueIndeks != i) {
                array[minValueIndeks] = array[i];
                array[i] = minValue;
            }
        }
        for (int i : array) {
            System.out.println("sıralandıktan sonra dizi : " + i);
        }
        return array;
    }

    public static int[] fisherYatesShuffle(int[] array) {
        Random rand = new Random();
        for (int i = array.length - 1; i > 0; i--) {
            int randomIndeks = rand.nextInt(i + 1);
            int temp = array[i];
            array[i] = array[randomIndeks];
            array[randomIndeks] = temp;
        }
        for (int i : array) {
            System.out.println("değiştirildikten sonra dizi : " + i);
        }
        return array;
    }

    public static int[] changeArray(int[] dizi) {
        for (int i = 0; i < dizi.length; i++) {
            int randomIndeks = (int) (Math.random() * (i + 1));
            int temp = dizi[i];
            dizi[i] = dizi[randomIndeks];
            dizi[randomIndeks] = temp;
        }
        for (int i : dizi) {
            System.out.println("değiştirildikten sonra dizi : " + i);
        }
        return dizi;
    }

    public static int[] reverseArray(int[] dizi) {
        int[] newarray = new int[dizi.length];
        for (int i = 0, j = dizi.length - 1; i < dizi.length; i++, j--) {
            newarray[i] = dizi[j];
        }
        for (int i : newarray) {
            System.out.println("tersi çevrildikten sonra dizi : " + i);
        }
        return newarray;
    }

    public static void showArray(int[] array) {
        for (int i : array) {
            System.out.println("kopyalayan dizi : " + i);
        }
    }
}
