package newbie.base.exercises;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ControlThreadRunningSequence {

    /**
     * 方法一 : 创建三个线程 控制执行顺序
     */
    static Thread thread1 = new Thread(new Runnable() {
        @Override
        public void run() {
            System.out.println("this is thread1");
        }
    });

    static Thread thread2 = new Thread(new Runnable() {
        @Override
        public void run() {
            System.out.println("this is thread2");
        }
    });

    static Thread thread3 = new Thread(new Runnable() {
        @Override
        public void run() {
            System.out.println("this is thread3");
        }
    });

    static ExecutorService executorService = Executors.newSingleThreadExecutor();

    /**
     * 控制线程执行顺序
     *
     * 如果使用自己创建的线程 那么线程会等待CPU的调用再去执行 所以不一定会按照想要的顺序去执行
     * 所以使用Thread.join() 方法 去让 主线程等待子线程执行完成之后再去继续执行
     *
     *
     * 还可以使用线程池来执行
     * 创建一个单线程队列的线程池 Executors.newSingleThreadExecutor()
     * 创建的线程池有FIFO的规则(先进先出) 所以可以达到控制线程执行顺序的目的
     *
     */
    public static void main(String[] args) throws InterruptedException {

        /**
         * method1 使用join()方法
         */
        /*thread1.start();
        thread1.join();
        thread2.start();
        thread2.join();
        thread3.start();
        */

        /**
         * method2 使用线程池
         */
        executorService.submit(thread1);
        executorService.submit(thread2);
        executorService.submit(thread3);
        executorService.shutdown();


    }
}
