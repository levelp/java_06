/**
 * Демонстрация работы с потоками
 */
public class ThreadDemo {
    private static final int ITERATIONS = 1000;
    static Integer counter = 0;
    static MyClass myClass = new MyClass();

    public static void main(String[] args) {
        int sleep = 1;
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < ITERATIONS; i++) {
                    myClass.inc();
                    counter++;
                    System.out.println("1) i = " + i);
                    if (sleep > 0)
                        try {
                            Thread.sleep(sleep);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                }
            }
        });
        thread1.start();
        // Лямбда-выражения
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < ITERATIONS; i++) {
                myClass.inc();
                counter++;
                System.out.println("2) i = " + i);
                if (sleep > 0)
                    try {
                        Thread.sleep(sleep);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
            }
        });
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("counter = " + counter);
        System.out.println("myClass.counter = " + myClass.counter);
    }

    static class MyClass {
        int counter = 0;

        void inc() {
            //counter++;
            synchronized (this) {
                counter++;
            }
        }

        // this
        public synchronized void inc2() {
            counter++;
        }
    }
}
