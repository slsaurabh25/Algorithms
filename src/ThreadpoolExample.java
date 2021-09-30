import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadpoolExample {

    public static void main(String[] args) {

        ExecutorService service = Executors.newFixedThreadPool(100);

        for (int i=0;i<100;i++) {
            service.execute(new Task());
        }
    }

    static class Task implements Runnable {

        @Override
        public void run() {
            System.out.println("Thread - "+Thread.currentThread().getName());
        }
    }
}
