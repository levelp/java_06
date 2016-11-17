package thread_samples;

/**
 * Пример создания своего потока
 */
public class T1 implements Runnable {
    public int iterations = 100;
    private long sleep;

    public T1(long sleep, int iterations) {
        this.sleep = sleep;
        this.iterations = iterations;
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new T1(300, 60));
        thread.start();

        for (int i = 0; i < 30; i++) {
            System.out.println("Main thread " + i);
            try {
                Thread.sleep(256);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        thread.join();
    }

    @Override
    public void run() {
        for (int i = 0; i < iterations; i++) {
            System.out.println(i);
            try {
                Thread.sleep(sleep);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
