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
        } catch (ArithmeticException e) {  // 后面跟多个catch
            System.out.println("ArithmeticException...");
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("StringIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundsException");
        } catch (NumberFormatException e) {
            System.out.println("NumberFormatException");
        }

        /*catch (Exception e) {
            System.out.println("Exception");
        }
        */
        finally { // 只能有一个finally 可以没有
            System.out.println("finally...");
        }

        System.out.println("done.");
    }

}
/* 只捕获第一个空指针异常，其他的不再执行
输出    ArithmeticException...
        finally...
        done.
    第一个catch执行，即捕捉到异常后后面的异常将不再执行，因此后面多个catch也不再捕获异常
(finally中的内容是始终会执行）
*/