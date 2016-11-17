import org.junit.Assert;
import org.junit.Test;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Сравнение обычного счётчика, volatile и atomic
 */
public class VolatileTest extends Assert {
    long counter = 0;
    volatile long volatileCounter = 0;
    AtomicLong atomicLong = new AtomicLong(0);

    @Test
    public void testVolatile() throws InterruptedException {
        long expectedValue = 0;
        for (int t = 0; t < 2; t++) {
            // Создаём много потоков
            int numberOfThreads = 1000;
            int numberOfIterations = 1000;
            expectedValue += numberOfThreads * numberOfIterations;

            Thread th[] = new Thread[numberOfThreads];
            for (int i = 0; i < numberOfThreads; ++i) {
                th[i] = new Thread(() -> {
                    for (int j = 0; j < numberOfIterations; j++) {
                        counter++;
                        volatileCounter++;
                        atomicLong.incrementAndGet();
                    }
                });
                th[i].start();
            }
            // Ожидаем пока все потоки завершатся
            for (Thread thread : th) thread.join();

            assertEquals(expectedValue, atomicLong.intValue());
            assertTrue(counter < expectedValue);
            assertTrue(volatileCounter < expectedValue);

            System.out.println("counter = " + counter +
                    "  volatile = " + volatileCounter +
                    "  atomic = " + atomicLong);
        }
    }


}
