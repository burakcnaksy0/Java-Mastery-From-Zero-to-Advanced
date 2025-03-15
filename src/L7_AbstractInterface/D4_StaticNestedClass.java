package L7_AbstractInterface;

public class D4_StaticNestedClass {
    // Dış sınıfın yalnızca statik üyelerine erişebilir.
    // Dış sınıfın bir örneğine (instance) ihtiyaç duymadan kullanılabilir.
    public static void main(String[] args) {
        Outer.StaticNested nested = new Outer.StaticNested();
        nested.display();
    }
}
class Outer {
    static String staticMessage = "Statik Mesaj";
    private int number = 5;
    public int id = 4;
    protected int gender = 1;

    static class StaticNested {
        void display() {
            System.out.println("Statik İç Sınıf: " + staticMessage);
        }
    }

}
