import java.util.Random;
import java.util.concurrent.*;

public class CompletebleFutureExample {
    public static void main(String[] args) {

        ExecutorService service = Executors.newFixedThreadPool(10);
        Future<Integer> future = service.submit(new Task());
        try {
            Integer result = future.get();
            System.out.println("Result::"+result);

            for (int i=0;i<100;i++) {
                CompletableFuture.supplyAsync(() -> getOrder())
                        .thenApplyAsync(order -> enrichOrder(order))
                        .thenApply(order -> performPayment(order))
                        .thenApply(order -> dispatch(order))
                        .thenAccept(o -> sendEmail(o));
            }

        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

    }

    private static void sendEmail(final Data o) {
        System.out.println("sendEmail");

    }

    private static Data dispatch(final Data order) {
        System.out.println("dispatch");

        return new Data(1, "dispatch");
    }

    private static Data performPayment(final Data order) {
        System.out.println("performPayment");

        return new Data(1, "performPayment");
    }

    private static Data enrichOrder(final Data order) {
        System.out.println("enrichOrder");

        return new Data(1, "enrichOrder");
    }

    private static Data getOrder() {
        System.out.println("getOrder");

        return new Data(1, "getOrder");
    }

    static class Data {
        int id;
        String name;

        public Data(final int id, final String name) {
            this.id = id;
            this.name = name;
        }

    }
    static class Task implements Callable<Integer> {

        @Override
        public Integer call() {
            return new Random().nextInt();
        }
    }
}
