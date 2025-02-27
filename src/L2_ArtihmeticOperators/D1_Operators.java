package L2_ArtihmeticOperators;

public class D1_Operators {
    public static void main(String[] args) {
        // + - * / %

        int a, b;

        a = 25;
        b = 4;

        int sum, extraction, multipy, divide, mode;

        sum = a + b;
        extraction = a - b;
        multipy = a * b;
        divide = a / b;
        mode = a % b;

        System.out.println("toplamı sonucu : " + sum);
        System.out.println("cıkarma sonucu :" + extraction);
        System.out.println("çarpma sonucu : " + multipy);
        System.out.println("bölme sonucu : " + (double)5 / (double)2);
        System.out.println("bölme sonucu : " + divide);
        System.out.println("mode sonucu : " + mode);

        a++;
        System.out.println("1 artırılmış sonucu : "+ a);
        a--;
        a--;
        System.out.println("1 azaltılmış sonucu : "+a);

        a *= 5;
        System.out.println("5 ile çarpılmış hali : "+a);

    }
}
