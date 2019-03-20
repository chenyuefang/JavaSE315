package day04;

public class BoxTest {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        long sum = 0L;
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            sum += i;
        }
        System.out.println(sum);

        System.out.println(System.currentTimeMillis() - start);
        // 程序运行的时间
    }
}
