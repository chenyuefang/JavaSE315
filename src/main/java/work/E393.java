package work;

public class E393 {

    public interface StackInterface {
        public void push(int n); // 压入子弹

        public int[] pop(); // 射出子弹
    }

    // 生产者线程
    public static class PushThread implements Runnable {

        private StackInterface s;

        public PushThread(StackInterface s) {
            this.s = s;
        }

        @Override
        public void run() {
            int i = 0;
            while (true) {
                java.util.Random r = new java.util.Random();
                i = r.nextInt(10);
                s.push(i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }

    }

    // 消费者线程
    public static class PopThread implements Runnable {
        private StackInterface s;

        public PopThread(StackInterface s) {
            this.s = s;
        }

        @Override
        public void run() {
            while (true) {
                System.out.println("->" + s.pop()[10] + "<-");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // 实现生产和消费的过程
    public static class SafeStack implements StackInterface {

        private int top = 0;
        private int[] values = new int[20]; // 表示枪膛对象
        private boolean dataAvailable = false;

        @Override
        public void push(int n) {

            synchronized (this) {
                while (dataAvailable)  // 1
                {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace(); // 忽略// 2
                    }
                }

                values[top] = n;
                System.out.println("压入数字" + n + "步骤1完成");
                top++;
                dataAvailable = true ;
                notifyAll();
                System.out.println("压入数字完成");
            }
        }

        @Override
        public int[] pop() {
          synchronized (this) {
             while (!dataAvailable) // 3
             {
                 try {
                     wait();
                 } catch (InterruptedException e) {
                     e.printStackTrace(); // 忽略// 4
                 }
             }
              System.out.println("弹出");
             top--;
             int[] test = {values[top] ,top};
             dataAvailable = false;
             // 唤醒正在等待压入数据的线程
              notifyAll();
              return test;
          }
        }

    }

    // 测试
    public static class  TsetSafeStack {
        public static void main(String[] args) {
            SafeStack s= new SafeStack();
            PushThread r1= new PushThread(s);
            PopThread r2 =new PopThread(s);
            PopThread r3 =new PopThread(s);

            Thread t1 =new Thread(r1);
            Thread t2 =new Thread(r2);
            Thread t3 =new Thread(r3);

            t1.start();
            t2.start();
            t3.start();
        }
    }
}