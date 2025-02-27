package L3_ConditionStructures;

public class D4_WhilelLoop {
    public static void main(String[] args) {
        int a;
        a = 0;
        int count = 0;
        while (a < 10) {
            System.out.println("while loop");
            a++;
            count++;
        }
        System.out.println("toplam sayaç : " + count);
    }
}
