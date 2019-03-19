package day03;

public class ArrayTest {


    public static void main(String[] args) {
        int[] ints = null;   // 初始化

        System.out.println(ints);

        String[] strings = new String[10];   //初始化 + 赋值   【 数组的个数 】

        double[] doubles = {1, 2, 3, 4};

//        System.out.println(ints.length);

        System.out.println(strings.length);

        System.out.println(doubles[2]);

        for (int i = 0; i < 4; i++) {
            System.out.println(doubles[i]);
        }

        for (int i = 0; i < doubles.length; i++) {
            System.out.println(doubles[i]);
        }

        for (double aDouble : doubles) {
            System.out.println(aDouble);
        }

        int[][] ints1 = new int[3][5];

        System.out.println(ints1[2][4]);  //从0开始算起

        for (int i = 0; i < ints1.length; i++) {    // 循环赋值
            for (int j = 0; j < ints1[i].length; j++) {
                ints1[i][j] = i + j;
            }
        }

        double[][] doubles1 = {   //  每一维度长度不等的数组赋值
                {0},
                {1, 2},
                {1, 2, 3}
        };
    }
}
