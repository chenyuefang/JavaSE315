package work;

public class E394 extends Thread {

    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("hello,word");
            try {
                sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        E394 tt = new E394();
        tt.start();
    }
}
