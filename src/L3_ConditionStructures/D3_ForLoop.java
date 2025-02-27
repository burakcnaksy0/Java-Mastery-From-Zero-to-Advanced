package L3_ConditionStructures;

public class D3_ForLoop {
    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            System.out.println("for loop");
        }
        System.out.println();

        // nested foor loop
        int count = 0;    // burdaki ifadenin ilk değeri olması önemli
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.println("nested loop");
                count++;
            }
        }
        System.out.println(count + " kere bu döngü çalıştı.");

        System.out.println();
        int sum = 0;
        for (int i = 0; i < 20; i++) {
            if (i % 2 == 0) {
                System.out.println("çift olan değerler : " + i);
                sum += i;
            }
        }
        System.out.println("bu çift değerlerin toplamı : " + sum);

        System.out.println();

        // infinity loop
        for (; ; ) {
            System.out.println("infinity loop");
        }

    }
}
