package day08;

import java.util.Arrays;

public class SimpleSort {

    public static void main(String[] args) {

        int[] int2 = new int[10];
        for (int i = 0; i < int2.length; i++) {
            int2[i] = (int) (Math.random() * 100);// 数组中随机产生10个数
        }
        System.out.println(Arrays.toString(int2)); // 输出随机的数组
        // Arrays.toString(ints) 字符串形式的数组

     for (int i = 0; i < int2.length; i++) {
     int min = i;
     for (int j = i + 1; j < int2.length; j++) {
     if (int2[j] < int2[i]) {
     min = int2[j];
     }
     }  //  选出之后待排序中值最小的位置
     if (min != i) {
     int temp = int2[i];
     int2[i] = int2[min];
     int2[min] = temp;
     }  // 只要小于之前被选出位置对应的值，就交换
     }    // 简单选择排序


        System.out.println(Arrays.toString(int2));// 输出排序后的数组
}

}


/**
 * public class SimpleSort{
 *     public static void sort(Comparable[] data){
 *         //数组长度
 *         int len=data.length;
 *         for(int i=0; i<len; i++){
 *             //记录当前位置
 *             int position = i;
 *             //找出最小的数，并用position指向最小数的位置
 *             for(int j=i+1; j<len; j++){
 *                 if( data[position].compareTo(data[j]) > 0 ) {
 *                     position=j;
 *                 }//endif
 *             }//endfor
 *             //交换最小数data[position]和第i位数的位置
 *             Comparable temp=data[i];
 *             data[i]=data[position];
 *             data[position]=temp;
 *         }//endfor
 *     }//endsort
 *     public static void main(String[] args) {
 *         //在JDK1.5版本以上,基本数据类型可以自动装箱
 *         //int,double等基本类型的包装类已实现了Comparable接口
 *         Comparable[] c={4,9,23,1,45,27,5,2};
 *         sort(c);
 *         for(Comparable data:c) {
 *             System.out.println(data);
 *         }
 *     }
 * }
 */