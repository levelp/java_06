public class ThreadIncDecDemo {
    static int x;

    // Объект для синхронизации
    private static final Object toilet = new Object();
    private static final Object toilet2 = new Object();

    public static void main(String[] args) throws InterruptedException {
        for (int n = 0; n < 20; n++) {
            int COUNT = 10000000; // Количество итераций
            x = 0; // Общая переменная
            Thread it = new Thread(() -> {
                for (int k = 0; k < 1000; k++) {
                    synchronized (toilet) {
                        for (int i = 0; i < COUNT / 1000; i++) {
                            x++;
                        }
                    }
                }
            });
            Thread dt = new Thread(() -> {
                for (int k = 0; k < 1000; k++) {
                    synchronized (toilet2) {
                        for (int i = 0; i < COUNT / 1000; i++) {
                            x--;
                        }
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
