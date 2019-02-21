package newbie.base.sort;

import java.util.Arrays;

public class QuickSort {

    /**
     * 快速排序
     * 1. 选取一个基准值(一般选择第一个) x
     * 2. 将所有小于x的数值放到x前边， 将所有大于x的值放在x的后边， 在这个分区退出后 x就在中间
     * 3. 将x前边的的子数列和x后边的子数列进行排序
     *
     * @param args
     */
    public static void main(String[] args) {

        int[] arr = {40, 45, 30, 10, 16, 20, 60, 50};

        System.out.println(Arrays.toString(arr));

        quickSort(arr, 0, arr.length-1);

        System.out.println(Arrays.toString(arr));

    }

    /**
     *
     * @param arr  待排序的数组
     * @param l    数组的左边界(例如 从数组起始位置开始排序， l = 0)
     * @param r    数组的右边界(例如 排序至数组尾， r = arr.length-1)
     */
    private static void quickSort(int[] arr, int l, int r){
        if(l < r){
            int i,j,x;
            i = l;
            j = r;
            x = arr[i];

            while(i<j){ // 传入左边界小于右边界时

                while(i < j && arr[j] > x){ // 从右向左找出第一个小于x的数
                    j--;
                }
                if(i < j){
                    arr[i++] = arr[j];
                }

                while (i < j && arr[i] < x) { // 从左向右找出第一个大于x的数
                    i++;
                }
                if (i < j) {
                    arr[j--] = arr[i];
                }
            }
            arr[i] = x;

            quickSort(arr, l, i-1);
            quickSort(arr, i+1, r);
        }
    }
}
