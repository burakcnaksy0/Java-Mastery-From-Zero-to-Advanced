package L4_MethosAndArrays;

public class D9_MethodEX_1 {
    public static void main(String[] args) {

        /*
        100 elemanlı bir dizi oluşturun ve bu dizinin tüm elemanlarını
        rastgele olacak şekilde üretin. Bu işlemden sonra dizideki
        elemanların ortalamasını hesaplayarak bu ortalamanın altında kaç
        tane eleman olduğunu yazdırın.
        */

        int[] values = new int[100];
        for (int i = 0; i < values.length; i++) {
            values[i] = (int) (Math.random() * 99 + 1);
        }
        double avg, sum = 0;
        for (int i = 0; i < values.length; i++) {
            sum += values[i];
        }
        System.out.println("arrayin toplamı : " + sum);
        avg = sum / values.length;
        System.out.println("arrayin ortalaması : " + avg);
        int count = 0;
        for (int i = 0; i < values.length; i++) {
            if (values[i] < avg) {
                count++;
            }
        }
        System.out.println("ortalamanın altında kalan değerler : " + count);
    }
}
