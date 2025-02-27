package L4_MetotlarVeDiziler;

public class D1_Metotlar {
    public static void main(String[] args) {
        showMenu();
        sumofnumbers(5, 8);
    }

    private static void sumofnumbers(int s1, int s2) {
        System.out.println(s1 + " + " + s2 + " işleminin sonucu : " + (s1 + s2));
    }

    private static void showMenu() {
        System.out.println("topla : ");
        System.out.println("çıkarma : ");
        System.out.println("çarpma : ");
        System.out.println("bölme : ");
    }
}
