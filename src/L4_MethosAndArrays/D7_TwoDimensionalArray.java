package L4_MethosAndArrays;

public class D7_TwoDimensionalArray {
    public static void main(String[] args) {

        // veritipi[][] arrayname = new veritipi[satırsayısı][sütunsayısı];

        int[][] array = new int[2][3];  // 2 satır 3 sütun
        array[0][0] = 2;
        array[0][1] = 3;
        array[0][2] = 5;
        array[1][0] = 4;
        array[1][1] = 7;
        array[1][2] = 9;

        String[] name = new String[2];
        name[0] = "burak";
        name[1] = "ceren";

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.println(name[i] + " .satır ve " + j + " . sütundaki değer : " + array[i][j]);
            }
        }
    }
}
