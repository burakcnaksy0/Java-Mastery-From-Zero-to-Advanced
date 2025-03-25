package L_11_ThreadsProcess;


public class D6_ProducerConsumerSolve {
    public static void main(String[] args) {
        CommonAreas commonAreas = new CommonAreas();

        Producers producer = new Producers(commonAreas);
        Consumers consumer = new Consumers(commonAreas);

        producer.start();
        consumer.start();

    }
}

class CommonAreas {
    private int data;
    private boolean isDataAvailable = false;

    public synchronized int takeData() {
        while (!isDataAvailable) { // Eğer veri yoksa bekle
            try {
                // bekleme methodu
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        isDataAvailable = false;
        // uyandırma metodu
        notify(); // Üreticiyi uyandır
        return data;
    }

    public synchronized void giveData(int v) {
        while (isDataAvailable) { // Eğer veri varsa bekle
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.data = v;
        isDataAvailable = true;
        notify(); // Tüketiciyi uyandır
    }
}

class Producers extends Thread {
    private CommonAreas commonAreas;

    Producers(CommonAreas commonAreas) {
        this.commonAreas = commonAreas;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            commonAreas.giveData(i);
            System.out.println(ThreadColours.Magenta + "Producer Thread give data  : " + i);
            try {
                sleep((int) (Math.random() * 3000));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class Consumers extends Thread {
    private CommonAreas commonAreas;

    Consumers(CommonAreas commonAreas) {
        this.commonAreas = commonAreas;
    }

    @Override
    public void run() {
        int readData = 0;
        for (int i = 1; i <= 10; i++) {
            readData = commonAreas.takeData();
            System.out.println(ThreadColours.Cyan + "Consumer Thread take data  :" + readData);
            try {
                sleep((int) (Math.random() * 3000));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }


    }
}













