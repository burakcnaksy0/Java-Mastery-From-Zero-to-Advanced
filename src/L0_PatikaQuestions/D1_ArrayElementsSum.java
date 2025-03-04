package L0_PatikaQuestions;

public class D1_ArrayElementsSum {
    public static void main(String[] args) {
        int[][] arr = new int[3][];
        arr[0] = new int[1]; // 1 elemanlı bir dizi
        arr[1] = new int[2]; // 2 elemanlı bir dizi
        arr[2] = new int[3]; // 3 elemanlı bir dizi

        int sum = 0;

        // Diziyi değerlerle doldurma
        for (int i = 0; i < 3; ++i)
            for (int j = 0; j < i + 1; ++j)
                arr[i][j] = j + 1;

        // Dizideki elemanların toplamını bulma
        for (int i = 0; i < 3; ++i)
            for (int j = 0; j < i + 1; ++j)
                sum += arr[i][j];

        System.out.print(sum);
    }

}

