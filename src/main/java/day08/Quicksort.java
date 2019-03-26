package day08;

public class Quicksort {


    /**
     *  int low;
     *         int high;
     *         //已经排完
     *         if (low >= high) {
     *             return;
     *         }
     *         int left = low;
     *         int right = high;
     *
     *         //保存基准值
     *         int pivot = ints[left];
     *         while (left < right) {
     *             //从后向前找到比基准小的元素
     *             while (left < right && ints[right] >= pivot)
     *                 right--;
     *             ints[left] = ints[right];
     *             //从前往后找到比基准大的元素
     *             while (left < right && ints[left] <= pivot)
     *                 left++;
     *             ints[right] = ints[left];
     *         }
     *         // 放置基准值，准备分治递归快排
     *         ints[left] = pivot;
     *         sort(a, low, left - 1);
     *         sort(a, left + 1, high);
     */
}
