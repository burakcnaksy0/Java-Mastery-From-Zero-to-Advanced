package L_11_ThreadsProcess;

public class D3_JoinveInterrutMethods {
    public static void main(String[] args) {

        OddNumber oddNumber = new OddNumber("1");
        OddNumber oddNumber2 = new OddNumber("2");

        oddNumber.start();
        //oddNumber2.start();

        new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    if (i == 8) {
                        try {
                            oddNumber.join();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    if (i % 2 == 0) {
                        System.out.println(ThreadColours.Magenta + " " + i);
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
        }.start();

    }
}

class OddNumber extends Thread {

    String name;
    String colour;

    public OddNumber(String name) {
        super(name);
        this.name = name;
        if (name.equals("1")) {
            colour = ThreadColours.Cyan;
        } else {
            colour = ThreadColours.Red;
        }
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {

            if (i == 15) {
                interrupt();
            }
            if (i % 2 != 0) {
                System.out.println(colour + " " + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    return;
                }
            }
        }
    }
}
