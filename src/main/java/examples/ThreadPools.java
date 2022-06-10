package examples;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadPools {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Starting...");
        Thread.sleep(10000);

//        runPlatformThreads(1000);
        runVirtualThreads(1000);
    }

    static void runVirtualThreads(int taskCount) throws InterruptedException {
        System.out.println("Virtual threads test with " + taskCount + " tasks has started");
        ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor();

        for (int i = 0; i < taskCount; i++) {
            executor.execute(new FakeTask());
        }

        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.HOURS);
    }


    static void runPlatformThreads(int taskCount) throws InterruptedException {
        System.out.println("Platform threads test with " + taskCount + " tasks has started");
        ExecutorService executor = Executors.newFixedThreadPool(50);

        for (int i = 0; i < taskCount; i++) {
            executor.execute(new FakeTask());
        }

        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.HOURS);
    }

    static class FakeTask implements Runnable {

        @Override
        public void run() {
            try {
                Thread.sleep(5000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
