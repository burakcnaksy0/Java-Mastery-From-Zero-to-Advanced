package L_10_ExceptionHandling;

public class D2_NestedTryCatch {
    public static void main(String[] args) {
        /*
        ArrayIndexOutOfBoundsException → Dizi sınırları dışına çıkma
        NullPointerException → null nesnesine erişim
        NumberFormatException → Geçersiz sayı formatı
        ArithmeticException → Sıfıra bölme
        ClassCastException → Yanlış tür dönüşümü
        IllegalArgumentException → Geçersiz parametre
        StackOverflowError → Sonsuz özyineleme
        IOException → Dosya giriş-çıkış hatası
         */
        String[] name = {"burak", "123", null, "433", "ceren"};

        for (int i = 0; i < name.length + 2; i++) {
            try {
                int number = name[i].length() + Integer.parseInt(name[i]);
            } catch (NumberFormatException e) {
                System.out.println(e.toString());
            } catch (NullPointerException e) {
                System.out.println(e.toString());
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println(e.toString());
            }
        }

        System.out.println();

        for (int i = 0; i < name.length + 2; i++) {
            try {
                int number = name[i].length() + Integer.parseInt(name[i]);
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }

        System.out.println();

        System.out.println(returnToStringMethod());
    }

    private static String returnToStringMethod() {
        String name = "burak";

        try {
            name += " can";
            // return name;
        } catch (Exception e) {
            name += " alkan";
            System.out.println(e.toString());
            // return name;
        } finally {
            name += " aksoy";
            return name;
        }
    }
}
