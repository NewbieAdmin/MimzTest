package newbie.base.sort;

public class SelectionSort {

    /**
     * 选择排序 从数组中找到最大(最小)的元素 将其放在对应位置
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = {20, 10, 40, 30, 50, 60};

        System.out.printf("before array is : ");
        for (int i : arr) {
            System.out.printf("%d ", i);
        }
        System.out.println("\n");

        System.out.println("---------------------------");

        selectionSort(arr, arr.length);

        System.out.printf("after array is : ");
        for (int i : arr) {
            System.out.printf("%d ", i);
        }
        System.out.println("\n");

    }

    /**
     * 选择排序  小 -> 大
     *
     * @param arr
     * @param length
     */
    private static void selectionSort(int[] arr, int length) {
        int i, j, min, tmp; // 初始化外层循环、内层循环、最小值、交换模板
        for (i = 0; i < length; i++) {
            min = i; // 默认第一个数为最小值角标
            for (j = i + 1; j < length; j++) { // 内层循环 将外层循环元素之后元素进行对比
                if (arr[j] < arr[min]) { // 当内层循环的值小于最小值时候 替换最小值角标
                    min = j;
                }
            }
            if (min != i) { // 当最小值角标被替换时 进行元素交换
                tmp = arr[i];
                arr[i] = arr[min];
                arr[min] = tmp;
            }
        }
    }

}
