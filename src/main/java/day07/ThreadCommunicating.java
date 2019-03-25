package day07;

public class ThreadCommunicating {
    public static void main(String[] args) {
        // Ctrl + N
        // Ctrl + F12

        Object lock = new Object();

        Thread thread1 = new Thread(new OutputThread(1, lock));
        Thread thread2 = new Thread(new OutputThread(2, lock));

        thread1.start();
        thread2.start();
    }
}

class OutputThread implements Runnable {

    private int number;
    private final Object lock;

    OutputThread(int number, Object lock) {
        this.number = number;
        this.lock = lock;
    }

    @Override
    public void run() {
        try {
            while (true) {
                synchronized (lock) {
                    System.out.println(number);
                    Thread.sleep(1000);
                    lock.notify(); // 唤醒其他线程
                    lock.wait(); // 自身陷入阻塞
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}