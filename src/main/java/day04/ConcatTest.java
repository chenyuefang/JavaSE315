package day04;

public class ConcatTest<T> { //T :类型参数   Type Parameters
    // 泛型
    private void concat(T t1, T t2) {

        System.out.println(String.valueOf(t1) + String.valueOf(t2));

    }  // 可代替下面被注释掉的三段


    //    private static void concat(String s1, String s2) {
//        System.out.println(s1 + s2);
//    }
//
//    private static void concat(int i1, int i2) {
//        System.out.println(i1 + "" + i2);
//    }
//
//    private static void concat(boolean b1, boolean b2) {
//        System.out.println(b1 + "" + b2);
//    }

    public static void main(String[] args) {
        String s1 = "Tom,";
        String s2 = "Jerry";
        ConcatTest<String> c1 = new ConcatTest<>();
        c1.concat(s1, s2);

        int i1 = 1;
        int i2 = 2;
        ConcatTest<Integer> c2 = new ConcatTest<>();
        c2.concat(i1, i2);

        boolean b1 = true;
        boolean b2 = false;
        ConcatTest<Boolean> c3 = new ConcatTest<>();
        c3.concat(b1, b2);
    }
}
