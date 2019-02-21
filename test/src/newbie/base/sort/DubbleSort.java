package newbie.base.sort;

import java.util.Arrays;

public class DubbleSort {

    /**
     * 数组元素 小 -> 大
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = {30, 20, 40, 10, 60, 50};
        dubbleSort(arr, arr.length);

        System.out.println(Arrays.toString(arr));

        System.out.println("---------------------------------");

        int[] newArr = {30, 20, 40, 10, 60, 50};
        System.out.println(Arrays.toString(newArr));
        betterDubbleSort(newArr, newArr.length);

        System.out.println(Arrays.toString(newArr));
    }

    /**
     * 冒泡排序 将最大的数放在末尾
     *
     * @param intArr
     * @param length
     */
    private static void dubbleSort(int[] intArr, int length) {
        int sum, index, tmp;

        for (sum = length - 1; sum > 0; sum--) { // 循环sum次
            for (index = 0; index < sum; index++) { // 使用index作为arr的角标判断
                if (intArr[index] > intArr[index + 1]) { // 交换相邻元素
                    tmp = intArr[index];
                    intArr[index] = intArr[index + 1];
                    intArr[index + 1] = tmp;
                }
            }
        }
    }

    private static void betterDubbleSort(int[] arr, int length) {
        int sum, index, tmp;
        boolean flag; // 使用flag做判断

        for (sum = length - 1; sum > 0; sum--) {
            flag = true;
            for (index = 0; index < sum; index++) {
                if (arr[index] > arr[index + 1]) {
                    tmp = arr[index];
                    arr[index] = arr[index + 1];
                    arr[index + 1] = tmp;
                    flag = false;
                }
            }
            if (flag) { // 如果循环一次没有做交换 证明已经排序完毕
                break;
            }
        }
    }
}
