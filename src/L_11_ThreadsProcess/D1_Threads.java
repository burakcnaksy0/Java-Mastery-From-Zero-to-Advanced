package L_11_ThreadsProcess;

public class D1_Threads {
    public static void main(String[] args) {

        System.out.println("the program is beginned -> Thread Adı : " + Thread.currentThread().getName());

        // 1. yöntem
        Laborer laborer = new Laborer();
        laborer.setName("Laborer Class Thread");
        laborer.start();

        // 2. yöntem (tavsiye edilen yöntem)
        LaborerRunnable runnable = new LaborerRunnable();
        Thread thread = new Thread(runnable);
        thread.setName("LaborerRunnable Thread");
        thread.start();

        // 3. yöntem
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("laborerRunnableInner is worked -> Thread Adı : " + Thread.currentThread().getName());
                    Thread.sleep(10000);
                    System.out.println("laborerRunnableInner is finised -> Thread Adı : " + Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();

        // 4. yöntem
        new Thread(){
            @Override
            public void run() {
                try {
                    System.out.println("laborerThreadInner is worked -> Thread Adı : " + Thread.currentThread().getName());
                    Thread.sleep(10000);
                    System.out.println("laborerThreadInner is finised -> Thread Adı : " + Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }.start();



        System.out.println("the program is finished -> Thread Adı : " + Thread.currentThread().getName());

    }
}

class Laborer extends Thread {
    @Override
    public void run() {

        try {
            System.out.println("laborer is worked -> Thread Adı : " + Thread.currentThread().getName());
            Thread.sleep(10000);
            System.out.println("laborer is finised -> Thread Adı : " + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

class LaborerRunnable implements Runnable {

    @Override
    public void run() {
        try {
            System.out.println("laborerRunnable is worked -> Thread Adı : " + Thread.currentThread().getName());
            Thread.sleep(10000);
            System.out.println("laborerRunnable is finised -> Thread Adı : " + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}