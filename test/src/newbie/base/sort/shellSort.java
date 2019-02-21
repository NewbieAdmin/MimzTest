package newbie.base.sort;

import java.util.Arrays;

public class shellSort {

    /**
     * 希尔排序 缩小增量排序
     * 按照步长进行排序 将相距为步长的两个元素进行比较排序
     * 当步长缩小到1时 算法变成插入排序
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = {6, 2, 4, 9, 5, 7, 10, 8, 1, 3};
        System.out.println(Arrays.toString(arr));

        shellSort(arr);

        System.out.println(Arrays.toString(arr));

    }

    /**
     * 希尔排序
     * @param arr 待排序数组
     */
    private static void shellSort(int[] arr){
        int gap = arr.length / 2;
        while(1 <= gap){
            // 把步长为gap的元素分成一个组, 扫描所有组
            for (int i = gap; i < arr.length; i++) {
                int j = 0;
                int temp = arr[i];
                // 对距离为gap的元素进行操作
                for (j = i - gap; j >= 0 && temp < arr[j]; j -= gap) {
                    arr[j+gap] = arr[j];
                }
                arr[j+gap] = temp;
            }
            System.out.println("gap = " + gap);
            gap = gap/2;
        }

    }

}
