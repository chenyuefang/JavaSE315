package work;

/**
 * 线程有两种实现方法，分别是继承于Thread类和实现Runnable接口
 *
 * 方式一： 继承于Thread类
 */

public class E381 extends Thread {

public void run() { // 覆盖Thread的run（）方法，提供具体法的过程
    System.out.println(this.getName() + this.getId());
    for (int i = 0; i < 1000; i++) {
        System.out.println("做弹弓打你家的玻璃！");
    }
    System.out.println("弹弓Over！");
}
}
