package day08;

import java.util.Arrays;

public class Quicksort { //快速排序  : 重新排序数列，所有比基准值小的元素摆放在基准前面，所有比基准值大的元素摆在基准后面（相同的数可以到任一边）。
                        // 在这个分区结束之后，该基准就处于数列的中间位置。这个称为分区（partition）操作。

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
       // Quicksort(int3, low, left - 1);
        //Quicksort(int3, left + 1, high);

        System.out.println(Arrays.toString(int3));
    }


}
