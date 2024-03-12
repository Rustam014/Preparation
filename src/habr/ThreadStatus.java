package habr;

public class ThreadStatus {
    public static void main(String[] strings) throws InterruptedException {
        Object lock = new Object();

        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    synchronized (lock) {
                        lock.notifyAll();
                        lock.wait();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        synchronized (lock){
            thread.start();
            lock.wait();
            System.out.println(thread.getState()); // WAITING
            lock.notifyAll();
            System.out.println(thread.getState()); // BLOCKED
        }
    }
}
