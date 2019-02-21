package newbie.base.leetcode;

import java.util.HashMap;
import java.util.Map;

public class PalindromeSubstring {

    /**
     * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
     * <p>
     * 示例 1：
     * 输入: "babad"
     * 输出: "bab"
     * 注意: "aba" 也是一个有效答案。
     * <p>
     * 示例 2：
     * 输入: "cbbd"
     * 输出: "bb"
     *
     * @param args
     */
    public static void main(String[] args) {
        String s = "abcda";
//        System.out.println(s.length());
        System.out.println(palindromeSubstring(s));


    }

    /**
     * 大佬的
     *
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }

    /**
     * 自己的
     * @param s
     * @return
     */
    private static String palindromeSubstring(String s) {
        if(null != s && "".equals(s)) return "";
        int index = 0, end = 0, temp = 0, max = 0;
        A:for (int i = index; i < s.length(); i++) {
            char c = s.charAt(i);
            B:for (int k = s.lastIndexOf(c); k > i; k--) {
                // 包含当前元素之后的相同元素
                if (k > -1 && k > i && s.charAt(i) == s.charAt(k)) {
                    // 当前回文长度大于之前的长度
                    if (k - i > max) {
                        temp = k;
                        // 循环对比内层元素是否相同
                        for (int j = i + 1; j < k; j++) {
                            temp--;
                            if(s.charAt(j) != s.charAt(temp)){
                                continue B;
                            }
                        }
                        max = k - i;
                        end = k;
                        index = i;
                    }
                }
            }

        }
        return 0==index && 0==end?s.charAt(index)+"":s.substring(index, ++end);
    }

}
