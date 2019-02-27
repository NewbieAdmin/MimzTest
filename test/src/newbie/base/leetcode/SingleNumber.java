package newbie.base.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SingleNumber {

    /**
     * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
     * 说明：
     * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
     * @param args
     */
    public static void main(String[] args) {

        int[] arr = {1,2,1,2,4};

        int i = singleNumber(arr);

        System.out.println(i);

    }

    /**
     * 自己的
     */
   /* public static int singleNumber(int[] nums) {

        boolean flag = true;
        for (int i=0, k=nums.length; i < k; i++) {
            if(i == k-1){
                return nums[i];
            }
            flag = true;
            for (int j = 0; j < k; j++) {
                if (i != j && nums[j] == nums[i]) {
                    flag = false;
                }
            }
            if (flag) {
                return nums[i];
            }
        }
        return nums[0];

    }*/

    /**
     * 大佬的
     *
     * @param nums
     * @return
     */
    public static int singleNumber(int[] nums) {
        int single = 0;
        for(int i = 0;i < nums.length; i++){
            single = single ^ nums[i];
        }
        return single;
    }



}
