package newbie.base.leetcode;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {

    /**
     * 求众数
     *
     * 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于  n/2  的元素。
     * 你可以假设数组是非空的，并且给定的数组总是存在众数。
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = {-1,1,1,1,2,1,2};
        int i = majorityElement(arr);
        System.out.println("--->" + i);
    }

    /**
     * 自己的
     */
    /*public static int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num)+1);
            }else{
                map.put(num, 1);
            }
        }
        int result = 0, temp =0, sum=0;
        for (Integer key : map.keySet()) {
            if(map.get(key) > temp){
                temp = map.get(key);
                result = key;
            }
        }
        return result;
    }*/

    /**
     * 大佬的
     * @param nums
     * @return
     */
    public static int majorityElement(int[] nums) {
        int count=1;
        int res=nums[0];
        for(int i=1; i<nums.length; i++){
            if(res==nums[i])
                count++;
            else{
                count--;
                if(count==0)
                    res=nums[i+1];
            }
        }
        return res;
    }
}
