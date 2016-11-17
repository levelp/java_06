package thread_samples;

/**
 * Использование безымянного класса
 */
public class T3 {
    public static void main(String[] args) {
        int sleep = 100;
        int iterations = 100;
        new Thread(() -> {
            for (int i = 0; i < iterations; i++) {
                System.out.println(i);
                try {
                    Thread.sleep(sleep);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
