package sync_threads;

/**
 * Первый поток
 */
public class ThreadsDemo {


    public static void main(String[] args) {
        Thread t1 = new Thread(new T1());
        Thread t2 = new Thread(new T2());
    }

    static class T1 implements Runnable {
        public int x, y;

        @Override
        public void run() {
            System.out.println("T1.run");
        }
    }

    static class T2 implements Runnable {
        @Override
        public void run() {
            System.out.println("T2.run");
        }
    }
}
