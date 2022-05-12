import java.util.concurrent.ExecutionException;
import java.util.*;
import java.util.concurrent.Future;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

public class Main {

    public static void main(String args[]) throws InterruptedException, ExecutionException {
        List<Future<String>> futures = new ArrayList<Future<String>>();
        Callable<String> callable = new CallableClass();
        List<Callable<String>> callables = new ArrayList<>();
        ExecutorService ex = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        for (int i = 0; i < 4; i++) {
            callables.add(new CallableClass());
            ex.submit(callable);// запускаем потоки

        }
        String t = ex.invokeAny(callables); // повторно запускаем потоки и проверяем кто первым завершил работу,
        // выводим на печать
        System.out.println(t);

    }

}



