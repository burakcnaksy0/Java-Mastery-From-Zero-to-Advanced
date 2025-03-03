package L4_MethosAndArrays;

public class D10_MethodEX_2 {
    public static void main(String[] args) {
        /*
        Her bir elemanı rastgele oluşturulmuş 3*2lik bir matriste bulunan
        sayıların toplamını yazdıran program yazınız.Ayrıca bu matriste yer
        alan en küçük ve en büyük sayıyı da mesaj olarak göstersin.
         */
        int[][] array2d = new int[3][2];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 2; j++) {
                array2d[i][j] = (int) (Math.random() * 90 + 10);
            }
        }
        for (int i = 0; i < array2d.length; i++) {  // Satırları
            for (int j = 0; j < array2d[i].length; j++) {   //Sütunları
                System.out.print(array2d[i][j] + " ");
            }
            System.out.println(); // Her satır bittiğinde yeni satıra geç
        }

        int maxValue = array2d[0][0];
        int minValue = array2d[0][0];
        for (int i = 0; i < array2d.length; i++) {
            for (int j = 0; j < array2d[i].length; j++) {
                if (array2d[i][j] > maxValue) {
                    maxValue = array2d[i][j];
                }
                if (minValue > array2d[i][j]) {
                    minValue = array2d[i][j];
                }
            }
        }
        System.out.println("3*2 lik matrisin en büyük değeri :" + maxValue);
        System.out.println("3*2 lik matrisin en küçük değeri :" + minValue);

    }
}
