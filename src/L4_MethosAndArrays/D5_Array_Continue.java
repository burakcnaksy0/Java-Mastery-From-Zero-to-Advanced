package L4_MethosAndArrays;

public class D5_Array_Continue {
    public static void main(String[] args) {
        String[] array = {"burak", "can", "aksoy"};
        arrayShow(array);

        sumoftotal(123, 54, 12, 87, 21, 56, 12, 56, 12, 73, 12, 77, 328, 1287, 23, 67, 23, 76);
    }

    private static void sumoftotal(int... values) {
        int toplam = 0;
        for (int i : values) {
            toplam += i;
        }
        System.out.println("elemanların toplamı : " + toplam);
    }

    private static void arrayShow(String[] dizi) {
        for (String i : dizi) {
            System.out.println("dizi elemanı : " + i);
        }
    }
}
