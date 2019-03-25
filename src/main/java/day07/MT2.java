package day07;

/**
 * 多实现
 */
public class MT2 implements Runnable {


    public static void main(String[] args) throws InterruptedException {
        MT2 mt2 = new MT2();
        Thread thread = new Thread(mt2);
        thread.start();  // 开始一个线程
//        Thread.sleep(1); // 主线程休眠一毫秒
        System.out.println("test...");
    }

    @Override  // run方法是Runnable 中的方法，是方法的重写
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }
    }

}
