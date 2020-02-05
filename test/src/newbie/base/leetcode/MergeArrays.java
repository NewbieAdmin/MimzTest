package newbie.base.leetcode;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class MergeArrays {

    /**
     * 合并两个有序数组
     *
     * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
     *
     * 说明:
     *
     * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
     * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
     * 示例:
     *
     * 输入:
     * nums1 = [1,2,3,0,0,0], m = 3
     * nums2 = [2,5,6],       n = 3
     *
     * 输出: [1,2,2,3,5,6]
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] arr1={1,2,3,0,0,0};
        int[] arr2={2,5,6};
        int m=3, n=3;
        merge(arr1,m,arr2,n);
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] arr = nums1.clone();
        int index1=0,index2=0;
        for (int i = 0, length = arr.length; i < length; i++) {
            // 两数组均为完全添加
            if (index1 < m && index2 < n) {
                if (arr[index1] <= nums2[index2]) {
                    nums1[i] = arr[index1++];
                } else {
                    nums1[i] = nums2[index2++];
                }
            } else if (index1 < m && index2 >= n) {
                // 数组2添加完成
                nums1[i] = arr[index1++];
            } else if (index1 >= m && index2 < n) {
                // 数组1添加完成
                nums1[i] = nums2[index2++];
            } else {
                break;
            }
        }
        System.out.println(Arrays.toString(nums1));

    }

}
