package L_10_ExceptionHandling;

public class D1_ExceptionConcept {
    /*
    try: Hata oluşabilecek kod buraya yazılır.
    catch: Hata yakalanır ve işlenir.
    finally: Hata olsun veya olmasın, her zaman çalışır (isteğe bağlıdır).
     */
    public static void main(String[] args) {
        try {
            int i = 5 / 0;
            System.out.println(i);
        } catch (Exception e) {
            System.out.println("hata  : " + e.toString());
        }

        try {
            Object o = new Object();
            String s = (String) o;
        } catch (Exception e) {
            System.out.println("hata : " + e.toString());
        } finally {   // kod hatalı olsa da olmasa da bu kod bloğu (scope) çalışacaktır.
            System.out.println("Bu blok her zaman çalışır.");
            System.out.println("kod çalışmaya devam ediyor ..");
        }


    }
}
