package L1_Main;

public class D1_main {
    public static void main(String[] args) {
        int i, y;
        i = 15;
        y = 6;

        System.out.println(i * y + " : sonuc ");

        int letter = 'b'; // Unicode equivalent
        System.out.println(letter);

        char harf = 'a'; // It takes up 16 bit of memory.
        boolean isTrue = true; // It takes up 1 bit of memory.

        System.out.println(harf + " harf");
        System.out.println(isTrue + " statament");

        String text = "150"; // is not a primitive data type..

        int number;

        number = Integer.parseInt(text);
        System.out.println("string ifade  :" + text);
        System.out.println("integer ifade : " + number);
    }
}
