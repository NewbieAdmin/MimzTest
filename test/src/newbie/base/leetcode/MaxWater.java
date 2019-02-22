package newbie.base.leetcode;

public class MaxWater {


    /**
     * 盛最多水的容器
     * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
     * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
     * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
     *
     * 说明：你不能倾斜容器，且 n 的值至少为 2。
     * 9|    =
     * 8|    =                 =
     * 7|    =-----------------=--=
     * 6|    =              =  =  =
     * 5|    =        =     =  =  =
     * 4| =  =        =     =  =  =
     * 3| =  =  =     =     =  =  =
     * 2| =  =  =  =  =     =  =  =
     * 1| =  =  =  =  =  =  =  =  =
     * 0-----------------------------------------
     *    1  2  3  4  5  6  7  8  9
     *
     * 示例:
     *
     * 输入: [1,8,6,2,5,4,8,3,7]
     * 输出: 49
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
    }

    /**
     * 自己的
     * 使用双指针方法
     * 将盛最大水的容器看成一个长方形
     * 长为左右指针距离 宽为指针对应元素大小
     * @param height
     * @return
     */
    public static int maxArea(int[] height) {
        if(height.length < 2) return 0;
        int max = 0;
        int left = 0; // 左指针
        int right = height.length-1; // 右指针

        for (; left < right;) {
            for (; right > left;) {
                // 使用左指针的数据和右指针的数据计算max值
                max = (right-left) * (Math.min(height[left], height[right])) > max ? (right-left) * (Math.min(height[left], height[right])) : max;
                if (height[left] > height[right]) {
                    right--;
                } else {
                    left++;
                }
            }
        }

        return max;
    }

    /**
     * 大佬的 4ms
     * @param height
     * @return
     */
    public int maxAreaBetter(int[] height) {
        int max = 0, nmax = 0;
        int i = 0, j = height.length - 1;
        int a;
        while(i < j){
            if (height[i] <= height[j]){
                nmax =  height[i] * (j - i);
                a = height[i];
                while(height[++i] <= a && i < j);
            }else{
                nmax =  height[j] * (j - i);
                a = height[j];
                while(height[--j] <= a && i < j);
            }
            if (nmax > max)max = nmax;
        }
        return max;
    }

}
