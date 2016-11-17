import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 */
public class ManyThread {
    static final Object lock = new Object();
    // Обычный счётчик без синхронизации
    static int counter = 0;
    // Cчётчик с внешним объектом для синхронизации
    static int counterLock = 0;
    // Экземпляр класса с синхронизацией по this
    static MyClass myClass = new MyClass();
    // Специальный класс для реализации счётчиков
    static AtomicInteger atomicCounter =
            new AtomicInteger();

    static void pause() {
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        while (true) {
            // Обнуляем значения всех счётчиков
            counter = 0;
            atomicCounter.set(0);
            counterLock = 0;
            MyClass.counter = 0;
            myClass = new MyClass();

            // Создаём массив потоков
            List<Thread> threads = new ArrayList<Thread>();
            //                  Поток1       Поток2
            //    counter = 2    Считал 2
            //                              Считал 2
            //                  2+1 = 3
            //                  Записал 3
            //                            2+1 = 3
            //                            Записал 3
            for (int i = 0; i < 10000; i++) {
                //final int N = i + 1;
                Thread thread = new Thread(() -> {
                    pause();
                    for (int j = 0; j < 100; j++) {
                        counter++;
                    }
                 /*   int threadNo = N; */
                    pause();
                    MyClass.inc4();
                    pause();
                    MyClass.incStatic();
                    pause();
                    atomicCounter.addAndGet(1);
                    pause();
                    // lock - мьютекс
                    synchronized (lock) {
                        counterLock++;
                        //int value2 = counterLock;
                        //counterLock = value2 + 1;
                    }
                    //pause();
                });
                thread.start();
                threads.add(thread);
            }
            // Ждём пока все потоки завершатся
            for (Thread thread : threads)
                thread.join();
            // Печатаем значение всех счётчиков
            System.out.println("counter = " + counter);
            System.out.println("atomicCounter = " + atomicCounter.intValue());
            System.out.println("counterLock = " + counterLock);
            System.out.println("myClass.get() = " + myClass.get());
        }
    }

    static class MyClass {
        static int counter;

        static void incStatic2() {
            synchronized (MyClass.class) {
                counter++;
            }
        }

        // MyClass.class
        synchronized static void incStatic() {
            counter++;
        }

        static void inc4() {
            counter++;
        }

        // this
        synchronized void inc() {
            counter++;
        }

        void inc2() {
            synchronized (this) {
                counter++;
            }
        }

        void inc3() {
            synchronized (MyClass.class) {
                counter++;
            }
        }

        int get() {
            return counter;
        }
    }
}
