import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 */
public class SyncronizedTest extends Assert {

    public static final int ITERATIONS = 10000;
    final Random random = new Random();

    /**
     * Демонстрация ошибок при отсутсвии синхронизации
     *
     * @throws InterruptedException
     */
    @Test
    public void testSyncronized() throws InterruptedException {
        final MyClass myClass = new MyClass();

        List<Thread> threads = new ArrayList<>();

        // Страртуем 10000 потоков на increment
        for (int i = 0; i < ITERATIONS; ++i) {
            Thread t = new Thread(() -> {
                // Поток пусть поспит случайное время
                waitRandomTime();
                myClass.incrementAndGetCounter();
            });
            t.start();
            threads.add(t);
        }

        // Подождём теперь завершения всех потоков
        for (Thread t : threads)
            t.join();
        threads.clear();

        System.out.println("Без syncronized (< 10000): " + myClass.counter);

        // Страртуем 10000 потоков на increment
        for (int i = 0; i < ITERATIONS; ++i) {
            Thread t = new Thread(() -> {
                waitRandomTime();
                myClass.incrementAndGetCounterSync();
            });
            t.start();
            threads.add(t);
        }

        // Снова подождём теперь завершения всех потоков
        for (Thread t : threads)
            t.join();
        threads.clear();

        System.out.println("С syncronized всё точно: " + myClass.syncCounter);
        assertEquals(ITERATIONS, myClass.syncCounter);
    }

    private void waitRandomTime() {
        try {
            Thread.sleep(random.nextInt(10));
        } catch (InterruptedException e) {
            System.out.println("Глотаем исключение :)");
        }
    }

    static class MyClass {
        int counter = 0;
        int syncCounter = 0;

        int incrementAndGetCounter() {
            return ++counter;
        }

        synchronized int incrementAndGetCounterSync() {
            return ++syncCounter;
        }
    }

}
