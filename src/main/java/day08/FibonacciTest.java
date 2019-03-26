package day08;

/**
 * 斐波那契 Fibonacci 数列：0, 1, 1, 2, 3, 5, 8..., 求f(n)
 */

public class FibonacciTest {

// f(1) = 0;
    // f(2) = 1;
    // f(n) = f(n - 1) + f(n - 2); (n>2)

    private static int fibonacci(int n) {
        if (n == 1) {
            return 0;
        } else if (n == 2) {
            return 1;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2); // recursive 递归算法
        }
    }

    public static void main(String[] args) {
        int n = 80;
        System.out.println(fibonacci(n));
    }

}
