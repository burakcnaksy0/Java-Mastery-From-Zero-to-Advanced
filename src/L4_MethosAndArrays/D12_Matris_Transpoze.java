package L4_MethosAndArrays;

public class D12_Matris_Transpoze {
    public static void main(String[] args) {
        // elemanları rastgele oluşturulmuş olan 3*2 lik matris
        int[][] array2d = new int[3][2];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 2; j++) {
                array2d[i][j] = (int) (Math.random() * 90 + 10);
            }
        }
        for (int i = 0; i < array2d.length; i++) {
            for (int j = 0; j < array2d[i].length; j++) {
                System.out.print(array2d[i][j] + "  ");
            }
            System.out.println();
        }
        System.out.println();
        for (int i = 0; i < array2d[i].length; i++) {
            for (int j = 0; j < array2d.length; j++) {
                System.out.print(array2d[j][i] + "  ");
            }
            System.out.println();
        }
    }
}
