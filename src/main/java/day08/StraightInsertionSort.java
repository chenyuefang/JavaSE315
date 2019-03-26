package day08;

import java.util.Arrays;

public class StraightInsertionSort { // 直接插入排序  ：从第一个元素开始，该元素可以认为已经被排序，
                                         // 后面的的元素依次与其进行比较，若小于它则交换

    public static void main(String[] args) {

        int[] int1 = new int[10];
        for (int i = 0; i < int1.length; i++) {
            int1[i] = (int) (Math.random() * 100);  // 数组中随机产生10个数
        }
        System.out.println(Arrays.toString(int1));     // 输出随机的数组

        for (int i = 0; i < int1.length; i++) {
            for (int j = i + 1; j < int1.length; j++) {
                if (int1[j] < int1[j - 1]) {
                    int temp = int1[j];
                    int1[j] = int1[j - 1];
                    int1[j - 1] = temp;
                }
            }
        }


        System.out.println(Arrays.toString(int1));     // 输出排序后的数组
    }
}




