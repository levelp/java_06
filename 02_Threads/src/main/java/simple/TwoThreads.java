package simple;

/**
 * Пример с двумя потоками
 */
public class TwoThreads {

    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                System.out.println(Thread.currentThread().getName() +
                        " i = " + i);
                pause(100);
            }
        });
        // Запуск второго потока
        thread.setName("Поток2");
        thread.start();
        Thread.currentThread().setName("Поток1");
        for (int i = 0; i < 1000; i++) {
            System.out.println(Thread.currentThread().getName() +
                    " i = " + i);
            pause(60);
        }
    }

    private static void pause(int pause) {
        try {
            Thread.sleep(pause);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
