package L_11_ThreadsProcess;

public class D2_ThreadTypes {
    public static void main(String[] args) {

        // main thread
        Thread threadMain = Thread.currentThread();
        System.out.println("main thread id -> " + threadMain.threadId());

        // user thread -> başladığında bitmesini de beklememiz gerekir.
        // bir thread sadece bir kere start() metodyla çalıştırılabilir.
        MyThread myThread = new MyThread("User Thread", ThreadColours.Green, 5);
        System.out.println("is it daemon thread  : " + myThread.isDaemon());
        System.out.println("thread id -> " + myThread.threadId());
        myThread.start();

        // daemon thread -> daemon thread oluşturulduğunda bitmesini beklememize gerek yok.
        MyThread myThread2 = new MyThread("Daemon Thread", ThreadColours.Magenta, 20);
        myThread2.setDaemon(true);
        System.out.println("is it daemon thread  : " + myThread2.isDaemon());
        System.out.println("thread id -> " + myThread2.threadId());
        myThread2.start();


    }
}

class MyThread extends Thread {
    private String colour;
    private int sleepClock;

    public MyThread(String name, String colour, int sleepClock) {
        super(name);
        this.colour = colour;
        this.sleepClock = sleepClock;
    }

    @Override
    public void run() {
        System.out.println(colour + "  " + sleepClock + " saniyelik işlem başlatıyorum.  Thread Adı -> " + Thread.currentThread().getName());

        try {
            Thread.sleep(sleepClock * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(colour + "  " + sleepClock + " saniyelik işlem bitiriyorum.   Thread Adı -> " + Thread.currentThread().getName());
    }
}


class ThreadColours {
    public static String Black = "\u001b[30m";
    public static String Red = "\u001b[31m";
    public static String Green = "\u001b[32m";
    public static String Yellow = "\u001b[33m";
    public static String Blue = "\u001b[34m";
    public static String Magenta = "\u001b[35m";
    public static String Cyan = "\u001b[36m";
    public static String White = "\u001b[37m";
    public static String Reset = "\u001b[0m ";
}