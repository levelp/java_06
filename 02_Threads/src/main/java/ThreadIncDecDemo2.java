// JIT -
// Когда метод выполняется > 10000 раз, он компилируется в
// native-машинный код
public class ThreadIncDecDemo2 {
    static int x;

    static class MyClass {
        static synchronized void inc() {
            x++;
        }

        synchronized void dec() {
            x--;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        for (int n = 0; n < 20; n++) {
            int COUNT = 1000000; // Количество итераций
            x = 0; // Общая переменная
            MyClass myClass = new MyClass();
            Thread it = new Thread(() -> {
                for (int k = 0; k < 1000; k++) {
                    for (int i = 0; i < COUNT / 1000; i++) {
                        MyClass.inc();
                    }
                }
            });
            Thread dt = new Thread(() -> {
                for (int k = 0; k < 1000; k++) {
                    for (int i = 0; i < COUNT / 1000; i++) {
                        myClass.dec();
                    }
                }
            });
            //  Первый поток
            //  из памяти i -> R = 0
            //                 R++ = 1  (*)
            //     x--- прервали и переключились на поток 2 ---
            //  Второй поток
            //            i -> R = 0
            //                 R-- = -1
            //            i <- R    i = -1
            //     x--- возвращаемся в первый поток ---
            //             i  <-  R = 1
            //              i = 1
            // Запускаем оба потока
            it.start();
            dt.start();
            // Ждём их завершения
            it.join();
            dt.join();
            // Печатаем значение x
            System.out.println("x = " + x);
        }
    }
}
