package newbie.base.leetcode;

public class ZConvert {

    /**
     * Z字形转换
     *
     * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
     * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
     *
     * L   C   I   R
     * E T O E S I I G
     * E   D   H   N
     * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
     *
     * 请你实现这个将字符串进行指定行数变换的函数：
     * string convert(string s, int numRows);
     *
     * 示例 1:
     * 输入: s = "LEETCODEISHIRING", numRows = 3
     * 输出: "LCIRETOESIIGEDHN"
     *
     * 示例 2:
     * 输入: s = "LEETCODEISHIRING", numRows = 4
     * 输出: "LDREOEIIECIHNTSG"
     * 解释:
     *
     * L   C   I   R
     * E T O E S I I G
     * E   D   H   N
     *
     * 0   4   8    12
     * 1 3 5 7 9 11 13 15
     * 2   6   10   14
     *
     *
     * L     D     R
     * E   O E   I I
     * E C   I H   N
     * T     S     G
     *
     * 0     6      12
     * 1   5 7   11 13
     * 2 4   8 10   14
     * 3     9      15
     *
     * 0      8          16
     * 1    7 9       15 17
     * 2   6  10   14    18
     * 3 5    11 13      19
     * 4      12         20
     *
     * 第一列 (x-1) * 2
     * 第二列
     * @param args
     */
    public static void main(String[] args) {

    }

    private String convert(String s, int numRows) {

        return s;

    }



}
