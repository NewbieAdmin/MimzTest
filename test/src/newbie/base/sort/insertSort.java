package newbie.base.sort;

import java.util.Arrays;

public class insertSort {

    /**
     * 直接插入排序
     * 将n个待排序的元素看成一个有序表和一个无序表
     * 初始 有序表包含1个元素 无序表包含n-1个元素
     * 过程 取出无序表中的第一个元素将其放在适当位置
     * 重复n-1次即可完成当前过程
     * @param args
     */
    public static void main(String[] args) {
        int[] a = {40,20,30,10,60,50};
        System.out.println(Arrays.toString(a));

        insertSort(a, a.length);

        System.out.println(Arrays.toString(a));
    }

    /**
     * 直接插入排序
     * @param arr    待排序数组
     * @param n      数组长度
     */
    private static void insertSort(int[] arr, int n){
        int i,j,k;
        for (i = 1; i < n; i++) {
            // 为arr[i]在前边的arr[0 ... i-1]区间中找一个合适的位置
            for (j = i - 1; j >= 0; j--) {
                if (arr[j] < arr[i]) { // 在有序区从大向小寻找位置
                    break;
                }
            }
            // 如果找到了一个合适的位置
            if (j != i - 1) {
                // 将比a[i]大的数据向后移
                int temp = arr[i];
                for (k = i - 1; k > j; k--) {
                    arr[k+1] = arr[k];
                }
                // 将a[i]放到正确的位置上
                arr[k+1] = temp;
            }

        }
    }

}
