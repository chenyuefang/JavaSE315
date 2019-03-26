package day08;


import java.util.Arrays;

/**
 * 插入排序 ：从第一个元素开始，该元素可以认为已经被排序，
 * 后面的的元素依次与其进行比较，若小于它则交换
 * <p>
 * 选择排序 ： 从未排序序列中，找到关键字最小的元素
 * <p>
 * 冒泡排序 : 比较两个相邻数的大小，进行交换
 * <p>
 * 快速排序  : 重新排序数列，所有比基准值小的元素摆放在基准前面，所有比基准值大的元素摆在基准后面（相同的数可以到任一边）。
 * 在这个分区结束之后，该基准就处于数列的中间位置。这个称为分区（partition）操作。
 * 递归地（recursively）把小于基准值元素的子数列和大于基准值元素的子数列排序。
 * 递归到最底部时，数列的大小是零或一，也就是已经排序好了
 * <p>
 * 希尔排序
 * 堆排序
 * 归并排序
 * 基数排序
 */

public class BubbleSort {

    public static void main(String[] args) {

        int[] ints = new int[10];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = (int) (Math.random() * 100);// 数组中随机产生10个数
        }
        System.out.println(Arrays.toString(ints)); // 输出随机的数组
        // Arrays.toString(ints) 字符串形式的数组
        // 算法
        for (int i = 0; i < ints.length; i++) {
            for (int j = 0; j < ints.length - 1 - i; j++) {
                if (ints[j + 1] < ints[j]) {
                    int temp = ints[j];
                    ints[j] = ints[j + 1];
                    ints[j + 1] = temp;
                }
            }
        }  // 冒泡排序




        System.out.println(Arrays.toString(ints));// 输出排序后的数组
    }
}
