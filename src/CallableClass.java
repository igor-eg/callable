import java.util.concurrent.Callable;

class CallableClass implements Callable<String> {

    @Override
    public String call() throws Exception {
        Integer i = 0;

        long start = System.currentTimeMillis();
        long end = start + 5 * 1000; // 60 seconds * 1000 ms/sec
        while (System.currentTimeMillis() < end) {
            Thread.sleep(1000);
            System.out.printf("Я %s,Всем привет!\n", Thread.currentThread().getName());
            i++;

        }

        return "Первым завершил работу поток: " + Thread.currentThread().getName() + " Повторений:  " + i;
    }
}