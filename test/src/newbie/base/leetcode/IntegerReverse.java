package newbie.base.leetcode;

public class IntegerReverse {

    /**
     * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
     * <p>
     * 示例 1:
     * 输入: 123
     * 输出: 321
     * <p>
     * 示例 2:
     * 输入: -123
     * 输出: -321
     * <p>
     * 示例 3:
     * 输入: 120
     * 输出: 21
     *
     * @param args
     */
    public static void main(String[] args) {
        int i = -1002;
        int reverse = reverse(i);
        System.out.println(reverse);
    }

    /**
     * 自己的  转换成String 然后倒叙输出
     * @param x
     * @return
     */
    /*private static int reverse(int x) {
        try {
            if (x == 0) return 0;
            StringBuffer sb = new StringBuffer();
            String s = new Integer(x).toString();
            if (x < 0) sb.append("-");
            for (int j = s.length()-1; j >= 0; j--) {
                sb.append(s.charAt(j));
            }
            if (sb.lastIndexOf("-") >= 0) {
                sb.delete(sb.length()-1, sb.length());
            }
            return Integer.parseInt(sb.toString());
        } catch (Exception e) {
            return 0;
        }
    }*/

    /**
     * 大佬的
     * 反转整数的方法可以与反转字符串进行类比。
     *
     * 我们想重复“弹出” xx 的最后一位数字，并将它“推入”到 \text{rev}rev 的后面。最后，\text{rev}rev 将与 xx 相反。
     *
     * 要在没有辅助堆栈 / 数组的帮助下 “弹出” 和 “推入” 数字，我们可以使用数学方法。
     *
     * //pop operation:
     * pop = x % 10;
     * x /= 10;
     *
     * //push operation:
     * temp = rev * 10 + pop;
     * rev = temp;
     * @param x
     * @return
     */
    public static int reverse(int x) {
        long rev = 0;
        while (x != 0) {
            rev = rev * 10 + x % 10;
            x = x / 10;
        }
        return (rev == (int) rev) ? (int) rev : 0;
    }

}
