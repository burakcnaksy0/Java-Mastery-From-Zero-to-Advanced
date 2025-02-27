package L3_ConditionStructures;

public class D5_BreakContinue {
    public static void main(String[] args) {

        // break kullanımı
        for (int i = 0; i < 10; i++) {
            System.out.println("i değeri : " + i);
            if (i == 4) {
                break;
            }
        }
        upfor:
        for (int i = 0; i < 10; i++) {
            downfor:
            for (int j = 0; j < 5; j++) {
                System.out.println("i : " + i + "   j: " + j);
                if (i == 1 && j == 4) {
                    break upfor;
                }
            }
        }
        System.out.println();

        // continue kullanımı
        for (int i = 0; i < 5; i++) {
            if (i == 2) {
                continue;
            }
            System.out.println("i değeri : " + i);

        }

        // return kullanımı
        for (int i = 0; i < 5; i++) {
            if (i == 2) {
                return;  // break ten farkı direkt olarak kendine kadar olan yeri işler . kendisinden sonra olanları çalışmaz.program sonlanır
            }
            System.out.println("i değeri : " + i);

        }
    }
}
