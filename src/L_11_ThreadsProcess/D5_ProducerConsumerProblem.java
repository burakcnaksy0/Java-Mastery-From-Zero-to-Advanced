package L_11_ThreadsProcess;

import java.util.Map;

public class D5_ProducerConsumerProblem {
    public static void main(String[] args) {
        CommonArea commonArea = new CommonArea();

        Producer producer = new Producer(commonArea);
        Consumer consumer = new Consumer(commonArea);

        producer.start();
        consumer.start();

    }
}

class CommonArea {
    private int data;

    // tüketici (consumer)
    public int takeData() {
        return data;
    }

    // üretici (producer)
    public void giveData(int v) {
        this.data = v;
    }
}

class Producer extends Thread {
    private CommonArea commonArea;

    Producer(CommonArea commonArea) {
        this.commonArea = commonArea;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            commonArea.giveData(i);
            System.out.println(ThreadColours.Magenta + "Producer Thread give data  : " + i);
            try {
                sleep((int) (Math.random() * 3000));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class Consumer extends Thread {
    private CommonArea commonArea;

    Consumer(CommonArea commonArea) {
        this.commonArea = commonArea;
    }

    @Override
    public void run() {
        int readData = 0;
        for (int i = 1; i <= 10; i++) {
            readData = commonArea.takeData();
            System.out.println(ThreadColours.Cyan + "Consumer Thread take data  :" + readData);
            try {
                sleep((int) (Math.random() * 3000));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }


    }
}













