package day01;

public class Hello {
    public static void main(String[] args) {

        int x = 0;

        long l1 = 2L; // Java int

        float f = 1.2f;

        int y = 0b101010;
        int m = 07654321;
        int n = 0xabcdef;

        char c = '\u9fbb'; // '\u4e00'; // '\123'; // 97; // 'a'; // 1;

        char c1 = '\u4e00'; // 汉字第一个字
        char c2 = '\u9fbb'; // 汉字最后一个字

        System.out.println("Hello, Java SE!");

        System.out.println((int)'一');

        if (x == 1) {
            System.out.println("Hello, Java SE!");
        }

        String s1 = "hello";
        String s2 = "hello";
        String s3 = new String("hello");
        System.out.println(s1);
        System.out.println(s3);

        System.out.println(s1 == s2);
        System.out.println(s1 == s3);

        System.out.println(s1.equals(s3));

    }

    }


