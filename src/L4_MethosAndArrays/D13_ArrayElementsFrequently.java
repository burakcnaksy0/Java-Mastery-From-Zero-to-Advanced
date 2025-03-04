package L4_MethosAndArrays;

public class D13_ArrayElementsFrequently {
    public static void main(String[] args) {


        // dizideki elemanların kaç kez tekrar edildiğini yani frekanslarını bulan programı yazınız.
        int[] array = {10, 20, 20, 10, 10, 20, 5, 20};
        boolean[] visited = new boolean[array.length];

        System.out.println("Elemanların frekansları:");

        for (int i = 0; i < array.length; i++) {
            if (visited[i]) {
                continue; // dallanma
            }
            int count = 1;
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] == array[j]) {
                    visited[j] = true;
                    count++;
                }
            }
            System.out.println(array[i] + " -> " + count);
        }
    }
}
