package work;

/**
 * 方式二：创建一个类实现Runnable接口，
 * 重写run方法以实现Runnable接口的方法
 */

public class E381_2  implements Runnable{


    @Override
    public void run() { // 实现Runnable的run方法，提供具体的过程
        System.out.println(this.getName() + "," + this.getId());
        for (int i = 0; i < 1000; i++) {
            System.out.println("做弹弓打你家的玻璃！");
        }
        System.out.println("弹弓Over！");
        }

    private String getId() {
        return null;
    }

    private String getName() {
        return null;
    }


}
