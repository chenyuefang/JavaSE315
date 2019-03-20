package day04;

public class ExceptionTest {

    // Runtime
    public static void main(String[] args) {

//        System.out.println(1/0);
         // 算数异常  java.lang.ArithmaticException
//        System.out.println("hello".charAt(5));
         // 字符串下标越界异常  java.lang.StringIndexOutOfBoundsException
//        System.out.println(new int[]{1,2,3}[3]);
         //  数组越界异常 java.lang.ArrayIndexOutOfBoundsException
//        System.out.println(Integer.parseInt("l23"));
         //  数字初始化异常  java.lang.NumberFormatExceptio
//        NullPointerException NPE
        //空指针异常  java.lang.NullPointerException


        String s = "hello";
        s = null;
        try {  // try 中的语句不会被执行
//                System.exit(0);
//            System.out.println(s.length());
            System.out.println("in try block...");
        } catch (ArithmeticException e) {
            // 捕捉到异常则会执行catch中的语句
//            e.printStackTrace();
            System.out.println("NPE...");
        } finally {
            //  finally 中的语句总会被输出，除非程序在finally 之前结束
            System.out.println("always print...");
        }
        System.out.println("done.");
    }
}


