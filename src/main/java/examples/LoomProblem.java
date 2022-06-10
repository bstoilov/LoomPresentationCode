package examples;

import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LoomProblem {

    public static void main(String[] args) {
        for (int i = 0; i < 1_000_000; i++) {
            Thread.startVirtualThread(() -> {
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }

        exampleForReusedThreads();
    }

    static void exampleForReusedThreads() {
        try (ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor()) {
            for (int i = 1; i <= 10; i++) {
                String taskName = "Task" + i;
                executor.execute(() -> someWork(taskName));
            }
        }
    }


    static void someWork(String taskName) {
        try {
            System.out.println(Thread.currentThread() + " executing " + taskName);

            new URL("https://httpstat.us/200?sleep=2000").getContent();

            System.out.println(Thread.currentThread() + " completed " + taskName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
