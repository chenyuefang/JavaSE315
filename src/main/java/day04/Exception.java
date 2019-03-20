package day04;

public class Exception extends Throwable {

    // Runtime
    public static void main(String[] args) {
        try {
            String s = null;
            System.out.println(s.length());  // NPE
            System.out.println(1 / 0);
            System.out.println("hello".charAt(5));
            System.out.println(new int[]{1, 2, 3}[3]);
            System.out.println(Integer.parseInt("l23"));
        }
        /*catch (Exception e) {
            System.out.println("Exception");
        }
        */catch (ArithmeticException e) {  // 后面跟多个catch
            System.out.println("ArithmeticException...");
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("StringIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundsException");
        } catch (NumberFormatException e) {
            System.out.println("NumberFormatException");
        }
        finally { // 只能有一个finally 可以没有
            System.out.println("finally...");
        }

        System.out.println("done.");
    }

}


/*
Try  {…}
Catch (ClassCastException ex) {………}
Catch (NumberFormatException ex) {………}
Catch (Exception ex) {………}  // 此句必须放在最后！


Exception是异常的父类。如果没有把该语句Catch (Exception ex) {………}放在最后，
那么try 块中产生的异常不可能被Catch (Exception ex) {………}之后的catch语句捕获，
也就是说Catch (Exception ex) {………}之后的catch语句永远都不会执行。
Java编译器不允许出现这样的情况，就会出现编译错误.
因此如果要捕获的异常有继承关系，则子类在前，父类在后
 */


/* 只捕获第一个空指针异常，其他的不再执行
输出    ArithmeticException...
        finally...
        done.
    第一个catch执行，即捕捉到异常后后面的异常将不再执行，因此后面多个catch也不再捕获异常
(finally中的内容是始终会执行）
*/