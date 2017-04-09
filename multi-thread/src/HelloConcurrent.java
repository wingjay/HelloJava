import java.util.Random;
import java.util.concurrent.CountDownLatch;

/**
 * Concurrent library learning
 */
public class HelloConcurrent {

    public static void main(String[] args) {
//        testCountDownLatch();
        exampleOfRunners();
    }

    private static void testCountDownLatch() {
        // wait all workers finish their job first
        int worker = 10;
        CountDownLatch countDownLatch = new CountDownLatch(worker);

        for (int i=0; i<worker; i++) {
            final int index = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("worker " + index + " is working ");
                    try {
                        Thread.sleep(100);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    System.out.println("worker " + index + " finishes job, current count: " + countDownLatch.getCount());
                    countDownLatch.countDown();
                }
            }).start();
        }

        try {
            countDownLatch.await();
            System.out.println("Hey! All workers finished their job");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void exampleOfRunners() {
        // 5 runners -> 5 thread
        // 1 referee -> main thread

        // runners getting ready
        // runners are ready
        // referee starts
        // runners start run
        Random RANDOM = new Random();
        int RUNNER_NUMBER = 5;
        CountDownLatch prepareLatch = new CountDownLatch(RUNNER_NUMBER);
        CountDownLatch startLatch = new CountDownLatch(1);

        for (int i=0; i<RUNNER_NUMBER; i++) {
            final int index = i+1;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    int preparingTime = RANDOM.nextInt(1000);
                    System.out.println("Runner " + index + " is preparing, needs time: " + preparingTime);

                    try {
                        Thread.sleep(preparingTime);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    System.out.println("Runner " + index + " is Ready");
                    prepareLatch.countDown();

                    try {
                        startLatch.await();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    System.out.println("Runner " + index + " starts run");
                }
            }).start();
        }

        try {
            prepareLatch.await();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("All runners are ready, GO!");
        startLatch.countDown();
    }


}