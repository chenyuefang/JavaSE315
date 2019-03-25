package day07;

public class MT3 implements Runnable{

    public static void main(String[] args) {
        Thread thread = new Thread(new MT3());
        thread.start();
        try {
            thread.join(); // 等待其他线程执行后，主线程在运行
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        for (int i = 0; i < 1 ; i++) {
            System.out.println(i);
        }
    }
}
