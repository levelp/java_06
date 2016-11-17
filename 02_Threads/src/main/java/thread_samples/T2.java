package thread_samples;

/**
 * Второй способ объявления своего потока
 */
public class T2 extends Thread {
    public static void main(String[] args) {
        T2 t2 = new T2();
        t2.setName("T2");
        t2.start();
        t2.run();
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            // Имя текущего потока
            String s = Thread.currentThread().getName();
            System.out.println(s + " " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
