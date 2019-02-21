package newbie.base.sort;

import java.util.Arrays;

/**
 * 归并排序
 */
public class MergeSort {

    /**
     * 归并排序 将一个数组拆分并单独排序 再合并成一个数组
     *
     * @param args
     */
    public static void main(String[] args) {

        int[] arr = {20, 10, 40, 30, 50, 60};
        System.out.println(Arrays.toString(arr));

        mergeSort(arr);

        System.out.println(Arrays.toString(arr));

    }

    private static void mergeSort(int[] arr) {
        // 为了避免重复创建数组 先创建一个与原数组长度相同的数组
        int[] temp = new int[arr.length];
        mergeSort(arr, 0, arr.length - 1, temp);
    }

    private static void mergeSort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            // 将左边数组归并排序, 使左边有序
            mergeSort(arr, left, mid, temp);
            // 右边归并排序
            mergeSort(arr, mid+1, right, temp);
            // 将两个有序数据进行合并操作
            merge(arr, left, mid, right, temp);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left;//左序列指针
        int j = mid+1;//右序列指针
        int t = 0;//临时数组指针
        while (i<=mid && j<=right){
            if(arr[i]<=arr[j]){
                temp[t++] = arr[i++];
            }else {
                temp[t++] = arr[j++];
            }
        }
        while(i<=mid){//将左边剩余元素填充进temp中
            temp[t++] = arr[i++];
        }
        while(j<=right){//将右序列剩余元素填充进temp中
            temp[t++] = arr[j++];
        }
        t = 0;
        //将temp中的元素全部拷贝到原数组中
        while(left <= right){
            arr[left++] = temp[t++];
        }

    }

}
