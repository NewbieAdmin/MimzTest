package newbie.base.leetcode;

import java.util.*;

public class TheLengthLongsString {


    /**
     * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
     * <p>
     * 示例 1:
     * 输入: "abcabcbb"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     * <p>
     * 示例 2:
     * 输入: "bbbbb"
     * 输出: 1
     * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
     * <p>
     * 示例 3:
     * 输入: "pwwkew"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
     *
     * @param s
     * @return
     */
    private static int longsSubString(String s) {

        if(null == s || "".equals(s)){
            return 0;
        }
        byte[] bytes = s.getBytes();
        List<String> temp = new ArrayList<>();
        int max = 0;
        for (int i = 0; i < bytes.length; i++) {
            if (temp.size() <= 0) {
                temp.add(bytes[i]+"");
                continue;
            }
            if (temp.contains(bytes[i]+"")) {
                if (max > 0) {
                    if (max < temp.size()) {
                        max = temp.size();
                    }
                } else {
                    max = temp.size();
                }
                while (true) {
                    String remove = temp.remove(0);
                    if(remove.equals(bytes[i]+"")){
                        break;
                    }
                }
                temp.add(bytes[i]+"");
                continue;
            }
            temp.add(bytes[i]+"");
        }
        if (temp.size() > max) return temp.size();
        return max;

        /**
         * 大佬的 18ms 最快
         *
         * 相当于滑动窗口
         * 让右边界移动 获取字串每个位的元素
         * 如果有重复的元素 那么记录当前长度 让左边界移动到当前下标+1
         * 最后计算max的值
         */
        /*int max = 0;
        int left = 0;
        int right = 0;
        for (; right < s.length(); ++right) {
            char rightC = s.charAt(right);
            for (int index = left; index < right; ++index) {
                if (s.charAt(index) == rightC) {
                    max = (right - left) > max ? (right - left) : max;
                    left = index + 1;
                    break;
                }
            }
        }
        max = (right - left) > max ? (right - left) : max;
        return max;*/

        /**
         * 大佬的 21 ms 第二快
         */
        /*int n = s.length();
        if (n < 2) return n;
        int[] record = new int[128];
        int left = 0;
        int res = 0;
        for (int right = 0; right < n; right++){
            char cur = s.charAt(right);
            // left更新
            if (record[cur] > left){
                left = record[cur];
            }
            // 记录位置
            record[cur] = right + 1;
            // res更新
            res = Math.max(res, right - left + 1);
        }
        return res;*/
    }

    public static void main(String[] args) {
        String s = "dvdf";
        /*byte[] bytes = s.getBytes();
        for (byte aByte : bytes) {
            System.out.println(aByte);
        }*/
        int i = longsSubString(s);
        System.out.println(i);
    }

}
