import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Tester {

    @SneakyThrows
    public static <T> void test(Callable<T> callable) {
        ExecutorService exec = Executors.newFixedThreadPool(4);
        List<Callable<T>> l = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            l.add(callable);
        }
        List<Future<T>> futures = exec.invokeAll(l);
        T t = futures.get(0).get();
        for (var f : futures) {
            // System.out.println(f.get());
            if (t != f.get()) {
                throw new IllegalStateException();
            }
        }
        exec.shutdown();
    }

}
