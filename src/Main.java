import java.util.concurrent.ExecutionException;
import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

public class Main {
    private static final int NUMBER_OF_THREADS = 4;

    public static void main(String args[]) throws InterruptedException, ExecutionException {
        Callable<String> callable = new CallableClass();
        List<Callable<String>> callables = new ArrayList<>();
        ExecutorService ex = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        for (int i = 0; i < NUMBER_OF_THREADS; i++) {
            callables.add(new CallableClass());
            ex.submit(callable);// запускаем потоки

        }

        try {
            String t = ex.invokeAny(callables); // повторно запускаем потоки и проверяем кто первым завершил работу,
            // выводим на печать
            System.out.println(t);
            ex.shutdown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

}



