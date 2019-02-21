package newbie.base.exercises;

public class FactorialDemo {


    public static void main(String[] args) {

        System.out.println(normalFactorial(10));

        System.out.println(endFactorial(10));

    }

    /**
     * 普通递归计算阶乘
     *
     * @param n
     * @return
     */
    private static long normalFactorial(int n) {
        if (0 >= n) {
            return n;
        } else if (1 == n) {
            return 1;
        } else {
            return n * normalFactorial(n - 1);
        }
    }

    /**
     * 尾递归计算阶乘
     *
     * @param n
     * @return
     */
    private static long endFactorial(int n) {
        if (0 >= n) {
            return n;
        } else if (1 == n) {
            return 1;
        } else {
            return endFactorial(n, 1);
        }
    }

    /**
     * 将结果当成参数传递并进行计算， 复用栈 避免造成堆栈溢出
     *
     * @param n
     * @param result
     * @return
     */
    private static long endFactorial(int n, int result) {

        if (1 == n) {
            return result;
        } else {
            return endFactorial(n - 1, n * result);
        }

    }


}
