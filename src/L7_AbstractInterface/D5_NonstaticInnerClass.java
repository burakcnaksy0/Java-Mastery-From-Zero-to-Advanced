package L7_AbstractInterface;

public class D5_NonstaticInnerClass {
    //Dış sınıfın tüm üyelerine (statik ve statik olmayan) erişebilir.
    //Dış sınıfın bir örneği (instance) üzerinden oluşturulmalıdır.
    public static void main(String[] args) {

        Ouuter outer = new Ouuter();
        Ouuter.Inner inner = outer.new Inner();
        inner.display();
    }
}
class Ouuter {
    String instanceMessage = "Üye İç Sınıf Mesajı";
    static String staticMessage = "Statik Mesaj";
    private int number = 5;
    public int id = 4;
    protected int gender = 1;

    class Inner {
        void display() {
            System.out.println("Üye İç Sınıf: " + instanceMessage);
        }
    }
}