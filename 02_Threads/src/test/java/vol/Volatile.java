package vol;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Демонстрация volatile
 */
public class Volatile extends Assert {
    /**
     * a
     */
    @Test
    public void testVolatile() throws InterruptedException {
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            Thread t1 = new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    TestVolatile.one();
                    TestVolatile.two();
                }
            });
            threads.add(t1);
            t1.start();
        }
        // Ждём завершения всех потоков
        for (Thread t : threads)
            t.join();

        assertTrue(TestVolatile.diffCounter > 0);
    }

    static class TestVolatile {
        static volatile int i = 0, j = 0;

        static int diffCounter = 0;

        static void one() {
            i++;
            j++;
        }

        static void two() {
            int lj = j, li = i;
            if (lj != li) {
                diffCounter++;
                //System.out.println("i=" + li + " j=" + lj);
            }
        }
    }
}
