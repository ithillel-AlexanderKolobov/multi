package lecture14;


import java.util.Random;

public class InterruptingThreads {

    public static void main(String[] args) throws InterruptedException {

        System.out.println("Starting ... ");
        Thread t1 =new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Random random = new Random();

                        for (int i = 0; i < 1E8; i++) {

                            if (Thread.currentThread().isInterrupted()) {
                                System.out.println("Interrupted");
                                break;
                            }

                            Math.sin(random.nextDouble());
                        }
                    }
                }, "First");
        t1.start();

        Thread.sleep(500);

        t1.interrupt();

        t1.join();

        System.out.println("Finish");
    }
}
