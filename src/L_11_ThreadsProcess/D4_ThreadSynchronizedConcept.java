package L_11_ThreadsProcess;

public class D4_ThreadSynchronizedConcept {
    public static void main(String[] args) {
        Printer printer = new Printer(10);

        Thread burak = new Burak(printer);
        burak.setName("burak thread");

        Thread ceren = new Ceren(printer);
        ceren.setName("ceren thread");

        burak.start();
        ceren.start();
    }
}

class Printer {
    private int copyNumber;

    public Printer(int copyNumber) {
        this.copyNumber = copyNumber;
    }

    // thread lerin senkronize çalışmasını sağlar.
    // yazıcıya ilk belge gönderen kişinin işi halledilir sonra ondan sonrakinin bitirilir..
    // public synchronized void print() -> böyle de kullanılır.
    // bütün bir metodu yapmak yerine koşul vererek de yapabiliriz.
    public void print() {
        // aynı anda sadece tek bir thread işlem yapsın.
        synchronized (this) {
            for (int i = 0; i < copyNumber; i++) {
                if (Thread.currentThread().getName().equals("burak thread")) {
                    System.out.println(ThreadColours.Red + "dokuman no  :" + i + " thread adı : " + Thread.currentThread().getName());
                } else {
                    System.out.println(ThreadColours.Blue + "dokuman no  :" + i + " thread adı : " + Thread.currentThread().getName());
                }
            }
        }
    }
}

class Burak extends Thread {
    private Printer printer;

    Burak(Printer printer) {
        this.printer = printer;
    }

    @Override
    public void run() {
        printer.print();
    }
}

class Ceren extends Thread {
    private Printer printer;

    Ceren(Printer printer) {
        this.printer = printer;
    }

    @Override
    public void run() {
        printer.print();
    }
}
