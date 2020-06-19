package newbie.base.test;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.*;

public class Test {

    public static void main(String[] args) throws ParseException, ExecutionException, InterruptedException {

        ExecutorService executor = Executors.newCachedThreadPool();
        Callable task = new Callable() {
            @Override
            public Object call() throws Exception {
                return "123123";
            }
        };

        FutureTask ft = new FutureTask(task);
        executor.submit(ft);
        System.out.println(ft.get());
        executor.shutdown();

    }

    /**
     * 不重复排列组合
     *
     * a  = 1
     * ab = 2 * 1 = 2
     * abc = 3 * 2 * 1 = 6
     * abcd = 4 * 3 * 2 * 1 = 24
     *
     * @param arr
     * @return
     */
    public static int arrangementAndcombination(int[] arr) {
        return execute(arr.length, 1);
    }

    public static int execute(int length, int sum) {
        if (length > 1) {
            sum = sum * length--;
            return execute(length, sum);
        }
        return sum;

    }

}
