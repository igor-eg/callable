import java.util.concurrent.Callable;

class CallableClass implements Callable<String> {
    private static final int WORKING_HOURS_STREAM = 5000;
    private static final int DELAY_TIME = 1000;

    @Override
    public String call() throws Exception {
        Integer i = 0;
        long start = System.currentTimeMillis();
        long end = start + WORKING_HOURS_STREAM; // 60 seconds * 1000 ms/sec
        while (System.currentTimeMillis() < end) {
            Thread.sleep(DELAY_TIME);
            System.out.printf("Я %s,Всем привет!\n", Thread.currentThread().getName());
            i++;

        }

        return "Первым завершил работу поток: " + Thread.currentThread().getName() + " Повторений:  " + i;
    }
}