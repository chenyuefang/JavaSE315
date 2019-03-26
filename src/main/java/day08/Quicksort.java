package day08;

import java.util.Arrays;

public class Quicksort {

    public static void Quicksort(int low, int high) {

        int[] int3 = new int[10];
        for (int i = 0; i < int3.length; i++) {
            int3[i] = (int) (Math.random() * 100);// 数组中随机产生10个数
        }
        System.out.println(Arrays.toString(int3)); // 输出随机的数组
        // Arrays.toString(ints) 字符串形式的数组


        //已经排完
        if (low >= high) {
            return;
        }
        int left = low;
        int right = high;

        //保存基准值
        int pivot = int3[left];
        while (left < right) {
            //从后向前找到比基准小的元素
            while (left < right && int3[right] >= pivot)
                right--;
            int3[left] =int3[right];
            //从前往后找到比基准大的元素
            while (left < right &&int3[left] <= pivot)
                left++;
            int3[right] = int3[left];
        }
        // 放置基准值，准备分治递归快排
        int3[left] = pivot;
        Quicksort(int3, low, left - 1);
        Quicksort(int3, left + 1, high);

        System.out.println(Arrays.toString(int3));
    }


}
