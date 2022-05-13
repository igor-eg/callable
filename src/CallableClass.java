import java.util.concurrent.Callable;

class CallableClass implements Callable<String> {

    @Override
    public String call() throws Exception {
        Integer i = 0;
        int workingHoursStream = 5000;
        int delayTime = 1000;
        long start = System.currentTimeMillis();
        long end = start + workingHoursStream; // 60 seconds * 1000 ms/sec
        while (System.currentTimeMillis() < end) {
            Thread.sleep(delayTime);
            System.out.printf("Я %s,Всем привет!\n", Thread.currentThread().getName());
            i++;

        }

        return "Первым завершил работу поток: " + Thread.currentThread().getName() + " Повторений:  " + i;
    }
}